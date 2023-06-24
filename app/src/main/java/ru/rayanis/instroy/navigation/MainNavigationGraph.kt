package ru.rayanis.instroy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.rayanis.instroy.add_instruments_screen.AddInstrumentsScreen
import ru.rayanis.instroy.history_screen.HistoryScreen
import ru.rayanis.instroy.holders_screen.HoldersScreen
import ru.rayanis.instroy.instruments_screen.InstrumentsScreen
import ru.rayanis.instroy.main_screen.MainScreen
import ru.rayanis.instroy.utils.Routes

@Composable
fun MainNavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }
        composable(Routes.ADD_INSTRUMENTS) {
            AddInstrumentsScreen()
        }
        composable(Routes.HISTORY) {
            HistoryScreen()
        }
    }
}