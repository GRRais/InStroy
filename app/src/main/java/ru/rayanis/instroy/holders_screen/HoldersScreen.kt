package ru.rayanis.instroy.holders_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.rayanis.instroy.data.Holder
import ru.rayanis.instroy.ui.theme.GrayLight


@Composable
fun HoldersScreen(
    viewModel: HoldersViewModel = hiltViewModel()
) {
    val holdersList = viewModel.holdersList.collectAsState(initial = emptyList())
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        items(holdersList.value) {item: Holder ->
            UiHolderItem(item) {event ->
                viewModel.onEvent(event)
            }
        }
    }

}