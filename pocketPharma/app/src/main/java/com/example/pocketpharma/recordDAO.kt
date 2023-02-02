package com.example.pocketpharma

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface recordDAO {

    @Query("SELECT * FROM record_table ORDER BY NAZEV ASC")
    fun getAlphabetizedRecords(): Flow<List<Record>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(record: Record)

    @Query("DELETE FROM record_table")
    suspend fun deleteAll()

}