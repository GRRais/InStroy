package ru.rayanis.instroy.holders_screen

import ru.rayanis.instroy.data.Holder

sealed class HoldersScreenEvents {
    data class onShowDeleteDialog(val item: Holder) : HoldersScreenEvents()
    data class onEditClick(val route: String) : HoldersScreenEvents()
    data class onHolderClick(val route: String) : HoldersScreenEvents()
    object OnHolderSave : HoldersScreenEvents()
}
