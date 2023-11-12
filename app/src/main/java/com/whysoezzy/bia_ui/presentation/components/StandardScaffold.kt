//package com.whysoezzy.bia_ui.presentation.components
//
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.outlined.Home
//import androidx.compose.material.icons.outlined.Message
//import androidx.compose.material.icons.outlined.Person
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.NavHost
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import com.whysoezzy.bia_ui.R
//import com.whysoezzy.bia_ui.domain.models.BottomNavItem
//import com.whysoezzy.bia_ui.presentation.ui.utils.Screen
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun StandardScaffold(
//    navController: NavController,
//    modifier: Modifier = Modifier,
//    showBottomBar: Boolean = true,
//    bottomNavItems: List<BottomNavItem> = listOf(
//
//        BottomNavItem(
//            route = Screen.TasksScreen.route,
//            icon = R.drawable.taskicon,
//            contentDescription = "Tasks"
//        ),
//        BottomNavItem(
//            route = Screen.GraphicsScreen.route,
//            icon = R.drawable.graphicsicon,
//            contentDescription = "Graphics"
//        ),
//        BottomNavItem(route = ""),
//        BottomNavItem(
//            route = Screen.ChatScreen.route,
//            icon = R.drawable.chat_icon,
//            contentDescription = "Chat"
//
//        ),
//        BottomNavItem(
//            route = Screen.ProfileScreen.route,
//            icon = R.drawable.profileicon,
//            contentDescription = "Profile"
//        ),
//    ),
//    onFabClick: () -> Unit = {},
//    content: @Composable () -> Unit
//) {
//    val navController = rememberNavController()
//
//    // Subscribe to navBackStackEntry, required to get current route
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    Scaffold(
//        bottomBar = {
//            BottomBar(
//                navController = navController,
//                bottomBarState = bottomBarState
//            )
//        },
//        content = { paddingValues ->
//            NavHost(
//                navController = navController,
//                startDestination = Screen.SplashScreen.route,
//                modifier = Modifier
//                    .padding(paddingValues)
//            ) {
//                composable(route = Screens.SplashScreen.name) {
//                    SplashScreen(navController = navController)
//                }
//                composable(route = Screens.TaskScreen.name) {
//                    TaskScreen(navController = navController)
//                }
//                composable(route = Screens.GraphicsScreen.name) {
//                    GraphicsScreen(navController = navController)
//                }
//                composable(route = Screens.ChatScreen.name) {
//                    ChatScreen(navController = navController)
//                }
//                composable(route = Screens.ProfileScreen.name) {
//                    ProfileScreen(navController = navController)
//                }
//            }
//        }
//    )
//}