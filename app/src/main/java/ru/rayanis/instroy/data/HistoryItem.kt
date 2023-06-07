package ru.rayanis.instroy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_item")
data class HistoryItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val getTime: String,
    val getInstrumentInfo: String,
    val getQuantity: String,
    val returnTime: String,
    val returnInstrumentInfo: String,
    val returnQuantity: String,
)
