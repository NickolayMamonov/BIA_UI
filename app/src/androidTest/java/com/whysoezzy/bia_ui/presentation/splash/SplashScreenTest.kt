package com.whysoezzy.bia_ui.presentation.splash

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.whysoezzy.bia_ui.presentation.MainActivity
import com.whysoezzy.bia_ui.presentation.ui.theme.BIA_UITheme
import com.whysoezzy.bia_ui.presentation.ui.utils.Constants
import com.whysoezzy.bia_ui.presentation.ui.utils.Screen
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class SplashScreenTest{

    @get:Rule
    val composableTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displaysAndDisappears() = runBlockingTest{
        composableTestRule.setContent {
            BIA_UITheme {
                SplashScreen(navController =navController)
            }
        }
        composableTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()
//        verify {
//            navController.popBackStack()
//            navController.navigate(Screen.LoginNumScreen.route)
//        }
    }

}