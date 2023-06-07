package ru.rayanis.instroy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "holder")
data class Holder(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val telegram: String,
    val whatsapp: String,
    val instrumentsOfHolder: ArrayList<String?> = arrayListOf(),
    val holderHistory: MutableList<HistoryItem> = mutableListOf()
)
