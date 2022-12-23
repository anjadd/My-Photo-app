package com.anjad.myphotoapp

sealed class NavRoutes(val route: String) {
    object MainScreen : NavRoutes("main_screen")
    object DetailsScreen : NavRoutes("details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}