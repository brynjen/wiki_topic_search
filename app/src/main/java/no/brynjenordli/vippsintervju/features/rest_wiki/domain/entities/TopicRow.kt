package no.brynjenordli.vippsintervju.features.rest_wiki.domain.entities

import no.brynjenordli.vippsintervju.R
import no.brynjenordli.vippsintervju.BR
import no.brynjenordli.vippsintervju.core.presentation.views.RecyclerItem

data class TopicRow(val text:String) {
    fun toRecyclerItem(): RecyclerItem {
        return RecyclerItem(
            data = this,
            variableId = BR.topicRow,
            layoutId = R.layout.topic_row
        )
    }
}