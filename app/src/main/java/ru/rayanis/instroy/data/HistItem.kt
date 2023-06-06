package ru.rayanis.instroy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hist_item")
data class HistItem(
    @PrimaryKey
    val id: String? = null,
    val name: String,
    val getTime: String,
    val getInstrInfo: String,
    val getQuantity: String,
    val returnTime: String,
    val returnInstrInfo: String,
    val returnQuantity: String,
)
