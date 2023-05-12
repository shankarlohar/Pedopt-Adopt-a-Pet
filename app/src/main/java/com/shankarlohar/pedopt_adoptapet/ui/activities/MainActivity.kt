package com.shankarlohar.pedopt_adoptapet.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.shankarlohar.pedopt_adoptapet.di.PedoptApplication
import com.shankarlohar.pedopt_adoptapet.ui.screens.PedoptApp
import com.shankarlohar.pedopt_adoptapet.ui.theme.EdenAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (application as PedoptApplication).appContainer
        setContent {
            ProvideWindowInsets {
                EdenAppTheme {
                    Surface {
                        PedoptApp(appContainer)
                    }
                }
            }
        }
    }
}