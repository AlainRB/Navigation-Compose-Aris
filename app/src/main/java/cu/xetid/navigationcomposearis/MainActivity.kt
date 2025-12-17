package cu.xetid.navigationcomposearis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cu.xetid.navigationcomposearis.core.navigation.NavigationWrapper
import cu.xetid.navigationcomposearis.ui.theme.NavigationComposeArisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationComposeArisTheme {
                NavigationWrapper()
            }
        }
    }
}

