package com.hamoosoft.dcapv_1.domain.repository

import com.hamoosoft.dcapv_1.domain.model.Dc
import kotlinx.coroutines.flow.Flow

interface DcRepository {

    suspend fun insertIntoDc(dc: Dc)

    suspend fun deleteFromDc(dc: Dc)

    suspend fun deleteDc()

    fun retrieveAllFromDc(): Flow<List<Dc>>

    fun retrieveAllFromDcByCondition(condition: String): Flow<List<Dc>>
}