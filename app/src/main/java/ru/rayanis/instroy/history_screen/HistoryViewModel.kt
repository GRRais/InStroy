package ru.rayanis.instroy.history_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.rayanis.instroy.data.history_item.HistoryItemRepository
import ru.rayanis.instroy.dialog.change_history_item_dialog.ChangeHistoryItemDialogController
import ru.rayanis.instroy.dialog.change_history_item_dialog.ChangeHistoryItemDialogEvent
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: HistoryItemRepository
) : ViewModel(), ChangeHistoryItemDialogController {

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

    override fun onChangeHistoryItemDialogEvent(event: ChangeHistoryItemDialogEvent) {
        TODO("Not yet implemented")
    }

//    fun onEvent(event: HistoryScreenEvents) {
//        when(event) {
//
//        }
//    }
}