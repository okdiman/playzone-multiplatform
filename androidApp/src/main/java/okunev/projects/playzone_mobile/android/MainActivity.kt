package okunev.projects.playzone_mobile.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import navigation.setupThemedNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupThemedNavigation()
    }
}
