package ru.rayanis.instroy.history_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ru.rayanis.instroy.dialog.HistoryDialogController

class HistoryViewModel: ViewModel(), HistoryDialogController {

    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("")
        private set
    override var quantityText = mutableStateOf(0)
        private set
    override var freeAmountRadioButton = mutableStateOf(true)
        private set
    override var maxAmountRadioButton = mutableStateOf(false)
        private set
    override var brokenAmountRadioButton = mutableStateOf(false)
        private set
    override var decommissionAmountRadioButton = mutableStateOf(false)
        private set
    override var getAdditionalInfoText = mutableStateOf("")
        private set
    override var returnAdditionalInfoText = mutableStateOf("")
        private set
    override var showBrokenLine = mutableStateOf(false)
        private set
    override var showInstrumentStateBlock = mutableStateOf(false)
        private set
    override var showAdditionalInfoBlock = mutableStateOf(false)
        private set

    fun onEvent(event: HistoryScreenEvents) {
        when(event) {

        }
    }
}