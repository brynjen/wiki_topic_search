package no.brynjenordli.vippsintervju.features.rest_wiki.domain.repositories

import no.brynjenordli.vippsintervju.features.rest_wiki.domain.entities.WikiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiApi {
    @GET("api.php")
    suspend fun wiki(
        @Query("action") action: String="parse",
        @Query("section") section: String="0",
        @Query("prop") prop: String="text",
        @Query("format") format:String="json",
        @Query("page") topic: String
    ): Response<WikiResponse>
}