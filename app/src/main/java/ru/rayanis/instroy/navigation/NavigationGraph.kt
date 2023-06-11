package ru.rayanis.instroy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.rayanis.instroy.holders_screen.HoldersScreen
import ru.rayanis.instroy.instruments_screen.InstrumentsScreen
import ru.rayanis.instroy.utils.Routes

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOLDERS ) {
        composable(Routes.HOLDERS) {
            HoldersScreen()
        }
        composable(Routes.INSTRUMENTS) {
            InstrumentsScreen()
        }
    }
}