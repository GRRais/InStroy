package ru.rayanis.instroy.main_screen

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import ru.rayanis.instroy.R
import ru.rayanis.instroy.dialog.EditHolderDialog
import ru.rayanis.instroy.navigation.NavigationGraph
import ru.rayanis.instroy.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Add_icon",
                    tint = White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        NavigationGraph(navController)
        EditHolderDialog(viewModel)
    }
}