package com.kpit.demoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kpit.demoapplication.ui.DemoScreen
import com.kpit.demoapplication.ui.theme.Cloud_orbit_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cloud_orbit_demoTheme {
                DemoScreen()
            }
        }
    }
}

