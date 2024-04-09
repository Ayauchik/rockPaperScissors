package jusan.hackathon

import android.app.Application
import jusan.hackathon.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){
    private val modulesToUse= listOf(
        viewModelModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(modulesToUse)
        }
    }
}