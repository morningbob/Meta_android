package com.example.littlelemon

interface Destinations {
    val route : String
}

object Home : Destinations {
    override val route: String = "Home"
}

object Menu : Destinations {
    override val route: String = "Menu"
}