package ru.rayanis.instroy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instrument_table")
data class Instrument(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val instrumentInfo: String,
    val freeAmount: String,
    val maxAmount: String,
    val brokenAmount: Int,
    val decommissionAmount: Int
)