package com.hamoosoft.dcapv_1.data.repository_imp

import com.hamoosoft.dcapv_1.data.dc_db.DcDao
import com.hamoosoft.dcapv_1.domain.model.Dc
import com.hamoosoft.dcapv_1.domain.repository.DcRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DcRepositoryImp @Inject constructor(private val dcDao: DcDao) : DcRepository {
    override suspend fun insertIntoDc(dc: Dc) {
        dcDao.insertIntoDc(dc)
    }

    override suspend fun deleteFromDc(dc: Dc) {
        dcDao.deleteFromDc(dc)
    }

    override suspend fun deleteDc() {
        dcDao.deleteDc()
    }

    override fun retrieveAllFromDc(): Flow<List<Dc>> {
        return dcDao.retrieveAllFromDc()
    }

    override fun retrieveAllFromDcByCondition(condition: String): Flow<List<Dc>> {
        return dcDao.retrieveAllFromDcByCondition(condition)
    }
}