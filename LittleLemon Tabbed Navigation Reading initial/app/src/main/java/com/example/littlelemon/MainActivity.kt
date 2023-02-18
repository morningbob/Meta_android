package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myApp()
        }
    }
}

@Composable
fun myApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { myBottomNavigation(navController = navController)}
    ) {
        Box(Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = Home.route) {
                composable(Menu.route) {
                    MenuScreen()
                }
                composable(Home.route) {
                    HomeScreen()
                }
                composable(Location.route) {
                    LocationScreen()
                }
            }
        }
    }
}

@Composable
fun myBottomNavigation(navController: NavHostController) {
    val destinationsList = listOf<Destinations>(
        Menu,
        Home,
        Location
    )
    
    var selectedIndex = rememberSaveable() {
        mutableStateOf(1) // select home at first
    }

    BottomNavigation() {
        destinationsList.forEachIndexed { index, destination ->
            BottomNavigationItem(
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destination.route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                          },
                icon = { Icon(painter = painterResource(id = destination.icon), contentDescription = destination.title) }
            )

        }
    }
}