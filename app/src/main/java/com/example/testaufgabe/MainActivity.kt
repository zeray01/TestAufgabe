package com.example.testaufgabe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.testaufgabe.presentation.compose.SWScreen
import com.example.testaufgabe.ui.theme.TestAufgabeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAufgabeTheme{
                SWScreen()
            }
        }
    }
}