package com.shankarlohar.pedopt_adoptapet.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * A sealed class that contains the [route],[icon] and [label]
 * associated with a single bottom navigation item.
 */
sealed class BottomNavigationRoutes(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object AdoptionScreen : BottomNavigationRoutes(
        AdoptionScreenNavigationRoutes.homeScreenRoute,
        Icons.Filled.Home,
        "Adopt"
    )
    object NotificationsScreen : BottomNavigationRoutes(
        EdenAppNavigationRoutes.notificationsScreenRoute,
        Icons.Filled.Notifications,
        "Notifications"
    )
}