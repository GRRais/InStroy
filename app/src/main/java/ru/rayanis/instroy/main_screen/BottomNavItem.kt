package ru.rayanis.instroy.main_screen

import ru.rayanis.instroy.R
import ru.rayanis.instroy.utils.Routes

sealed class BottomNavItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    object InstrumentsItem : BottomNavItem(
        "Инструменты",
        R.drawable.instrument_icon,
        Routes.INSTRUMENTS
    )

    object HoldersItem : BottomNavItem(
        "Ответственные",
        R.drawable.holder_icon,
        Routes.HOLDERS
    )
}
