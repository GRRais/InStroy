package ru.rayanis.instroy.add_instruments_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun AddInstrumentsScreen() {
    Text(
        text = "Add instruments screen",
        modifier = Modifier.fillMaxSize()
            .wrapContentWidth()
            .wrapContentHeight()
    )
}