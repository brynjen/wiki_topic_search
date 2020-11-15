package no.brynjenordli.vippsintervju.core.presentation.views

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewBindings {
    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun setRecyclerViewItems(
            recyclerView: RecyclerView,
            items: List<RecyclerItem>?
        ) {
            var adapter = (recyclerView.adapter as? RecyclerViewAdapter)
            if (adapter == null) {
                adapter = RecyclerViewAdapter()
                recyclerView.adapter = adapter
            }

            adapter.updateData(items.orEmpty())
        }
    }
}