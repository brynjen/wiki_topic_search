package no.brynjenordli.vippsintervju.core.injection

import no.brynjenordli.vippsintervju.features.rest_wiki.presentation.viewmodels.WikiViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel<WikiViewModel>()
}