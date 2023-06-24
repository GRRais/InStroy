package ru.rayanis.instroy.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.rayanis.instroy.data.history_item.HistoryItem
import ru.rayanis.instroy.data.history_item.HistoryItemDao
import ru.rayanis.instroy.data.holder.Holder
import ru.rayanis.instroy.data.holder.HolderDao
import ru.rayanis.instroy.data.instrument.Instrument
import ru.rayanis.instroy.data.instrument.InstrumentDao

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