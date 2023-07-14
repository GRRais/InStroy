package ru.rayanis.instroy.instruments_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.rayanis.instroy.dialog.edit_instrument_amount_dialog.ChangeInstrumentAmountStatusDialog
import ru.rayanis.instroy.dialog.edit_instrument_dialog.EditInstrumentDialog
import ru.rayanis.instroy.holders_screen.HoldersViewModel


@Composable
fun InstrumentsScreen(
    viewModel: InstrumentsViewModel = hiltViewModel()
) {
    Text(
        text = "Instruments screen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .wrapContentHeight()
    )

    EditInstrumentDialog(viewModel)
    ChangeInstrumentAmountStatusDialog(viewModel)
}