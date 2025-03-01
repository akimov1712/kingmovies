package ru.topbun.kingmovies

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.topbun.agreement.di.agreementScreenModule
import ru.topbun.auth.di.authScreenModule
import ru.topbun.filter.di.filterScreenModule
import ru.topbun.kingmovies.di.appModule
import ru.topbun.privacy_policy.di.privacyScreenModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        registerKoin()
    }

    private fun registerKoin(){
        startKoin{
            androidLogger()
            androidContext(this@App)
            registerScreenModules()
            modules(appModule)
        }
    }

    private fun registerScreenModules() {
        ScreenRegistry {
            privacyScreenModule()
            agreementScreenModule()
            authScreenModule()
            filterScreenModule()
        }
    }

}