package com.whysoezzy.bia_ui.presentation.ui.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.whysoezzy.bia_ui.presentation.login_num.LoginNumScreen
import com.whysoezzy.bia_ui.presentation.login_pass.LoginPassScreen
import com.whysoezzy.bia_ui.presentation.splash.SplashScreen
//
//@Composable
//fun Navigation(){
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = Screen.SplashScreen.route
//    ){
//        composable(Screen.SplashScreen.route){
//            SplashScreen(navController = navController)
//        }
//        composable(Screen.LoginNumScreen.route){
//            LoginNumScreen(navController = navController)
//        }
//        composable(Screen.LoginPassScreen.route){
//            LoginPassScreen(navController = navController)
//        }
//
//    }
//}