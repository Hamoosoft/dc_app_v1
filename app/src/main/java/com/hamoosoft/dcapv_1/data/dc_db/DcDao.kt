package com.hamoosoft.dcapv_1.data.dc_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hamoosoft.dcapv_1.domain.model.Dc
import kotlinx.coroutines.flow.Flow

@Dao
interface DcDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoDc(dc: Dc)

    @Delete
    suspend fun deleteFromDc(dc: Dc)

    @Query(value = "delete from dc")
    suspend fun deleteDc()

    @Query(value = "select * from dc")
    fun retrieveAllFromDc(): Flow<List<Dc>>

    @Query(value = "select * from dc where f02 =:condition ")
    fun retrieveAllFromDcByCondition(condition: String): Flow<List<Dc>>


}