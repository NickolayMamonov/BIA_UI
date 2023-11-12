package com.whysoezzy.bia_ui.domain.models

data class BottomNavItem(
    val route: String,
    val icon: Int,
    val contentDescription: String,
    val alertCount: Int? = null,
)
