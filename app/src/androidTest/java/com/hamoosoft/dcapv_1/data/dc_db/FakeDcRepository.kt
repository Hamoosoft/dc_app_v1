package com.hamoosoft.dcapv_1.data.dc_db

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.hamoosoft.dcapv_1.domain.model.Dc
import com.hamoosoft.dcapv_1.domain.repository.DcRepository
import kotlinx.coroutines.flow.Flow
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class FakeDcRepository(private val dao: DcDao) : DcRepository {


    override suspend fun insertIntoDc(dc: Dc) {
        dao.insertIntoDc(dc)
    }

    override suspend fun deleteFromDc(dc: Dc) {
        dao.deleteFromDc(dc)
    }

    override suspend fun deleteDc() {
        dao.deleteDc()
    }

    override fun retrieveAllFromDc(): Flow<List<Dc>> {
        return dao.retrieveAllFromDc()
    }

    override fun retrieveAllFromDcByCondition(condition: String): Flow<List<Dc>> {
        return dao.retrieveAllFromDcByCondition(condition)
    }

}