package com.jestaykin.anyclock.clockdata

import androidx.room.*
import com.jestaykin.anyclock.clock.Clock
import kotlinx.coroutines.flow.Flow

@Dao
interface ClockDAO {

    @Query("SELECT * FROM clock_table_data ORDER BY id ASC")
    fun getAllClock(): Flow<List<Clock>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertClock(clock: Clock)

    @Delete
    suspend fun deleteClock(clock: Clock)

    @Query("DELETE FROM clock_table_data")
    suspend fun deleteAll()
}