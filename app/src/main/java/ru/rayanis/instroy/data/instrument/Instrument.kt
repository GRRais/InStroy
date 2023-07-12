package ru.rayanis.instroy.data.instrument

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instrument_table")
data class Instrument(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val additionalInfo: String,
    val freeAmount: Int,
    val maxAmount: Int,
    val brokenAmount: Int,
    val decommissionAmount: Int
)