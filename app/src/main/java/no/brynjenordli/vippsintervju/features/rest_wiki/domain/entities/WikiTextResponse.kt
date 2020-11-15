package no.brynjenordli.vippsintervju.features.rest_wiki.domain.entities

import com.google.gson.annotations.SerializedName

data class WikiTextResponse(@SerializedName("*") val content: String) {
    fun toTopicRow(topic:String): TopicRow {
        val amount = content.split(topic)
        return TopicRow(text = "Found ${amount.size} occurrences of word $topic in '$topic' wiki")
    }
}