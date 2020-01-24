package com.example.cryptocurrencykotlin.controller.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [CoinData::class], version = 1, exportSchema = false)
abstract class CoinRoomDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao

    companion object {
        private const val DATABASE_NAME = "GAME_BACKLOG_DATABASE"

        @Volatile
        private var INSTANCE: CoinRoomDatabase? = null

        fun getDatabase(context: Context): CoinRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(CoinRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            CoinRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    INSTANCE?.let { database ->
                                        CoroutineScope(Dispatchers.IO).launch {
                                            database.coinDao().getAllCoinsInPortfolio()
                                        }
                                    }
                                }
                            })
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}