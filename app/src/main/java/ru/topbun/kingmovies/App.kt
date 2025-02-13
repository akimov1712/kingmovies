package ru.topbun.kingmovies

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.topbun.kingmovies.di.appModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        registerKoin()
    }

    private fun registerKoin(){
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

}