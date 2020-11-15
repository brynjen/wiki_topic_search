package no.brynjenordli.vippsintervju

import android.app.Application
import no.brynjenordli.vippsintervju.core.injection.networkModule
import no.brynjenordli.vippsintervju.core.injection.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InterviewApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@InterviewApplication)
            modules(
                listOf(
                    networkModule, viewModelsModule
                )
            )
        }
    }
}