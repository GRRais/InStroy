package ru.rayanis.instroy.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Holder::class,
        Instrument::class,
        HistoryItem::class
    ],
    version = 1,
    exportSchema = true
)

abstract class MainDb : RoomDatabase() {
    abstract val historyItemDao: HistoryItemDao
    abstract val holderDao: HolderDao
    abstract val instrumentDao: InstrumentDao
}