package no.brynjenordli.vippsintervju.core.injection

import com.google.gson.GsonBuilder
import no.brynjenordli.vippsintervju.features.rest_wiki.domain.repositories.WikiApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .writeTimeout(45, TimeUnit.SECONDS)
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()
        Retrofit.Builder().baseUrl("https://en.wikipedia.org/w/")
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(WikiApi::class.java)
    }
}