package ru.rayanis.instroy.history_screen

import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.rayanis.instroy.data.HistoryItemRepository
import ru.rayanis.instroy.dialog.DeleteDialogController
import ru.rayanis.instroy.dialog.DeleteDialogEvent
import ru.rayanis.instroy.dialog.InstrumentStateChangeDialogController
import ru.rayanis.instroy.dialog.InstrumentStateChangeEvent
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val context: Application,
    private val repository: HistoryItemRepository
): ViewModel(), InstrumentStateChangeDialogController{

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

    override fun onInstrumentStateChangeDialogEvent(event: InstrumentStateChangeEvent) {
        TODO("Not yet implemented")
    }

//    fun onEvent(event: HistoryScreenEvents) {
//        when(event) {
//
//        }
//    }
}