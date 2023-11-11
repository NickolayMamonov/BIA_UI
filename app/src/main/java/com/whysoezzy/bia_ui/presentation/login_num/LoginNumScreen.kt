package com.whysoezzy.bia_ui.presentation.login_num

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.whysoezzy.bia_ui.presentation.ui.utils.Screen

@Composable
fun LoginNumScreen(navController: NavController){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "THIS IS THE LOGIN SCREEN")
    }
}