package no.brynjenordli.vippsintervju.features.rest_wiki.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import no.brynjenordli.vippsintervju.core.presentation.views.RecyclerItem
import no.brynjenordli.vippsintervju.features.rest_wiki.domain.repositories.WikiApi
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class WikiViewModel : ViewModel(), KoinComponent {
    private val networkApi by inject<WikiApi>()
    val searchText = MutableLiveData<String>().apply { value = "test" }

    val data = MutableLiveData<List<RecyclerItem>>()

    fun search(topic: String)  {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = networkApi.wiki(topic = topic)
                if (result.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val item = result.body()?.parse?.text?.toTopicRow(topic)?.toRecyclerItem()!!
                        val oldList = data.value?.toMutableList()?: mutableListOf()
                        oldList.add(item)
                        data.value = oldList
                    }
                }
            } catch (e:Exception) {
                Log.e("Error", "Failed due to $e")
            }
        }
    }
}