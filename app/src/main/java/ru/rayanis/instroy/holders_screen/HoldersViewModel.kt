package ru.rayanis.instroy.holders_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.Holder
import ru.rayanis.instroy.data.HolderRepository
import ru.rayanis.instroy.dialog.EditHolderDialogController
import javax.inject.Inject

@HiltViewModel
class HoldersViewModel @Inject constructor(
    private val repository: HolderRepository
): ViewModel(), EditHolderDialogController {

    private var holderItem: Holder? = null

    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("")
        private set
    override var nameTextField = mutableStateOf("")
        private set
    override var phoneNumberTextField = mutableStateOf("")
        private set
    override var emailNumberTextField = mutableStateOf("")
        private set
    override var telegramNicknameTextField = mutableStateOf("")
        private set
    override var whatsappNumberTextField = mutableStateOf("")
        private set

    fun onEvent(event: HoldersScreenEvents) {
        when(event) {
            is HoldersScreenEvents.OnHolderSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        Holder(
                            holderItem?.id,
                            "Ильназ",
                            "+79393030000",
                            "ilnaz@mail.ru",
                            "@ilnaz99",
                            "+79393030000"
                        )
                    )
                }
            }
            is HoldersScreenEvents.onHolderClick -> {

            }
            is HoldersScreenEvents.onEditClick -> {
                holderItem = event.item
            }
            is HoldersScreenEvents.onShowDeleteDialog -> {

            }
        }
    }
}