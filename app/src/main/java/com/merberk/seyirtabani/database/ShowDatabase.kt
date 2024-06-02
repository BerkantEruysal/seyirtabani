package com.merberk.seyirtabani.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.merberk.seyirtabani.model.Show

@Database(entities = [Show::class], version = 1)
@TypeConverters(Converters::class)
abstract class ShowDatabase : RoomDatabase() {
    abstract fun showDao(): ShowDao

    companion object {
        @Volatile //sakladığı değerin Thread'ler tarafından okunmaya çalışıldığında hepsinde aynı değerin okunacağının garantisini verir.
        private var INSTANCE: ShowDatabase? = null

        fun getInstance(context: Context): ShowDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShowDatabase::class.java,
                    "show-db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }

}