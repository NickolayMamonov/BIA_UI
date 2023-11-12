package com.whysoezzy.bia_ui.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whysoezzy.bia_ui.presentation.chat.ChatScreen
import com.whysoezzy.bia_ui.presentation.graphics.GraphicsScreen
import com.whysoezzy.bia_ui.presentation.login_num.LoginNumScreen
import com.whysoezzy.bia_ui.presentation.login_pass.LoginPassScreen
import com.whysoezzy.bia_ui.presentation.profile.ProfileScreen
import com.whysoezzy.bia_ui.presentation.splash.SplashScreen
import com.whysoezzy.bia_ui.presentation.tasks.TasksScreen
import com.whysoezzy.bia_ui.presentation.ui.theme.BIA_UITheme
import com.whysoezzy.bia_ui.presentation.ui.utils.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarAnimationApp() {

    // State of bottomBar, set state to false, if current page route is "car_details"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    BIA_UITheme {
        val navController = rememberNavController()

        // Subscribe to navBackStackEntry, required to get current route
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // Control TopBar and BottomBar
        when (navBackStackEntry?.destination?.route) {
            Screen.TasksScreen.route -> {
                bottomBarState.value = true
            }

            Screen.GraphicsScreen.route -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            Screen.ChatScreen.route -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            Screen.ProfileScreen.route -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            Screen.SplashScreen.route -> {
                // Hide BottomBar
                bottomBarState.value = false
            }
        }

        Scaffold(
            bottomBar = {
                BottomBar(
                    navController = navController,
                    bottomBarState = bottomBarState
                )
            },
            content = { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.SplashScreen.route,
                    modifier = Modifier
                        .padding(paddingValues)
                ) {
                    composable(Screen.SplashScreen.route){
                        SplashScreen(navController = navController)
                    }

                    composable(Screen.LoginNumScreen.route){
                        LoginNumScreen(navController = navController)
                    }
                    composable(Screen.LoginPassScreen.route){
                        LoginPassScreen(navController = navController)
                    }
                    composable(Screen.TasksScreen.route){
                        TasksScreen(navController = navController)
                    }
                    composable(Screen.GraphicsScreen.route){
                        GraphicsScreen(navController = navController)
                    }
                    composable(Screen.ChatScreen.route){
                        ChatScreen(navController = navController)
                    }
                    composable(Screen.ProfileScreen.route){
                        ProfileScreen(navController = navController)
                    }
                }
            }
        )
    }

}
