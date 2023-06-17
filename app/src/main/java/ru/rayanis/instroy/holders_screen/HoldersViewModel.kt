package ru.rayanis.instroy.holders_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.Holder
import ru.rayanis.instroy.data.HolderRepository
import javax.inject.Inject

@HiltViewModel
class HoldersViewModel @Inject constructor(
    private val repository: HolderRepository
): ViewModel() {

    private var holderItem: Holder? = null

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