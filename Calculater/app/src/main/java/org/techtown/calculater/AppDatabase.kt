package org.techtown.calculater

import androidx.room.Database
import androidx.room.RoomDatabase
import org.techtown.calculater.dao.HistoryDao
import org.techtown.calculater.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao():HistoryDao
}