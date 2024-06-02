package com.merberk.seyirtabani.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.merberk.seyirtabani.model.Show
@Dao
interface ShowDao {
    @Query("SELECT * FROM countries")
    suspend fun getAll(): List<Show>

    @Query("SELECT * FROM countries WHERE title = :showName")
    suspend fun findByName(showName: String): Show

    @Query("SELECT * FROM countries WHERE title = :id")
    suspend fun findById(id : Int): Show

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(list: List<Show>)

}