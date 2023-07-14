package ru.rayanis.instroy.holders_screen

import ru.rayanis.instroy.data.holder.Holder

sealed class HoldersScreenEvent {
    data class OnShowDeleteDialog(val item: Holder) : HoldersScreenEvent()
    data class OnShowEditDialog(val item: Holder) : HoldersScreenEvent()
    data class OnHolderClick(val route: String) : HoldersScreenEvent()
    object OnHolderSave : HoldersScreenEvent()
}
