package com.example.assigment.ui.nav

import android.provider.CalendarContract
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.assigment.ui.map.GoogleMap

@Composable
fun Nav() {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigation(modifier = Modifier.height(64.dp)) {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination?.hierarchy

            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = android.R.drawable.ic_dialog_map),
                        contentDescription = "Map"
                    )
                },
                label = { Text("Map") },
                selected = currentDestination?.any { it.route == "map" } == true,
                onClick = {
                    navController.navigate("map") {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = false
                    }
                }
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = android.R.drawable.ic_dialog_map),
                        contentDescription = "Map"
                    )
                },
                label = { Text("2") },
                selected = currentDestination?.any { it.route == "map" } == true,
                onClick = {
                    navController.navigate("map") {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = false
                    }
                }
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = android.R.drawable.ic_dialog_map),
                        contentDescription = "3"
                    )
                },
                label = { Text("Map") },
                selected = currentDestination?.any { it.route == "map" } == true,
                onClick = {
                    navController.navigate("map") {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = false
                    }
                }
            )
        }
    }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "map",
        ) {
            composable("map") { GoogleMap() }

        }
    }
}