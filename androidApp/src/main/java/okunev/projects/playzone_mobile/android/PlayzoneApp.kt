package okunev.projects.playzone_mobile.android

import PlatformSDK
import android.app.Application
import platform.PlatformConfiguration

class PlayzoneApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PlatformSDK.init(configuration = PlatformConfiguration(applicationContext))
    }
}