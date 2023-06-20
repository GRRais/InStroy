package ru.rayanis.instroy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "holder_table")
data class Holder(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val telegramNickname: String,
    val whatsappNumber: String
)
