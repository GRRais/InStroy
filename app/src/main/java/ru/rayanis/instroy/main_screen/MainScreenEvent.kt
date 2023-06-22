package ru.rayanis.instroy.main_screen

sealed class MainScreenEvent {
    object OnShowEditDialog : MainScreenEvent()
    object OnHolderSave : MainScreenEvent()
}
