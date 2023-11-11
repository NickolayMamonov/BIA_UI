package com.whysoezzy.bia_ui.presentation.ui.utils

sealed class Screen(val route: String){
    object SplashScreen : Screen("splash_screen")
    object LoginNumScreen : Screen("login_num_screen")
    object LoginPassScreen : Screen("login_pass_screen")
    object TasksScreen : Screen("tasks_screen")
    object DetailsTaskScreen : Screen("details_task_screen")
    object MapScreen : Screen("map_screen")
    object DischargeScreen : Screen("discharge_screen")
    object IncidentScreen : Screen("incident_screen")
    object GraphicsScreen : Screen("graphics_screen")
    object ChatScreen : Screen("chat_screen")
    object ProfileScreen : Screen("profile_screen")
}
