package no.brynjenordli.vippsintervju.features.rest_wiki.domain.entities

data class WikiParseResponse(val title: String, val pageid: String, val text: WikiTextResponse)