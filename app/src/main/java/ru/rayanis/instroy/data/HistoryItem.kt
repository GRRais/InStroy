package ru.rayanis.instroy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_item_table")
data class HistoryItem(
    @PrimaryKey
    val id: Int? = null,
    val holderName: String,
    val holderId: Int,
    val instrumentName: String,
    val instrumentId: Int,
    val getTime: String,
    val getInstrumentInfo: String,
    val getQuantity: String,
    val returnTime: String,
    val returnInstrumentInfo: String,
    val returnQuantity: String,
)
