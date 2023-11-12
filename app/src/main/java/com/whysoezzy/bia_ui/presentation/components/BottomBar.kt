package com.whysoezzy.bia_ui.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.whysoezzy.bia_ui.R
import com.whysoezzy.bia_ui.domain.models.BottomNavItem
import com.whysoezzy.bia_ui.presentation.ui.utils.Screen

@Composable
fun BottomBar(navController: NavController, bottomBarState: MutableState<Boolean>) {
//    val items = listOf(
//        Screens.TaskScreen,
//        Screens.GraphicsScreen,
//        Screens.ChatScreen,
//        Screens.ProfileScreen
//    )
    val listofNavItems: List<BottomNavItem> = listOf(

    BottomNavItem(
        route = Screen.TasksScreen.route,
        icon = R.drawable.taskicon,
        contentDescription = "Tasks"
    ),
    BottomNavItem(
        route = Screen.GraphicsScreen.route,
        icon = R.drawable.graphicsicon,
        contentDescription = "Graphics"
    ),
    BottomNavItem(
        route = Screen.ChatScreen.route,
        icon = R.drawable.chat_icon,
        contentDescription = "Chat"

    ),
    BottomNavItem(
        route = Screen.ProfileScreen.route,
        icon = R.drawable.profileicon,
        contentDescription = "Profile"
    ),
    )

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                listofNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = item.contentDescription)

                        },
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )

                }
            }
        }
    )
}