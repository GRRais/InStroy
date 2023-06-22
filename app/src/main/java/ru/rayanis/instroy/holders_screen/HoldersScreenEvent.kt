package ru.rayanis.instroy.holders_screen

import ru.rayanis.instroy.data.Holder

sealed class HoldersScreenEvent {
    data class onShowDeleteDialog(val item: Holder) : HoldersScreenEvent()
    data class onShowEditDialog(val item: Holder) : HoldersScreenEvent()
    data class onHolderClick(val route: String) : HoldersScreenEvent()
    object OnHolderSave : HoldersScreenEvent()
}
