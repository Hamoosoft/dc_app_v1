package com.hamoosoft.dcapv_1.data.dc_db

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hamoosoft.dcapv_1.domain.repository.DcRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class DcDbTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("dc_db")
    lateinit var db: DcDb
    private lateinit var dao: DcDao
    private lateinit var dcRepository: DcRepository

    @Before
    fun setUp() {
        hiltRule.inject()
        dao = db.dcDao()
        dcRepository = FakeDcRepository(dao)
    }

    @After
    fun closeDb() {
        if (db.isOpen)
            db.close()
    }

    @Test
    fun insert_objectIntoDc_with_the_assertion_true() {
        runBlocking {
            dcRepository.insertIntoDc(FakeData.dcObject1)
            val result = dcRepository.retrieveAllFromDc()
            assertEquals(FakeData.dcObject1, result.first().first())
        }


    }

    @Test
    fun delete_objectFromDc_with_the_assertion_true() {
        runBlocking {
            dcRepository.insertIntoDc(FakeData.dcObject1)
            dcRepository.deleteFromDc(FakeData.dcObject1)
            val result = dcRepository.retrieveAllFromDc()
            assert(result.first().isEmpty())
        }


    }

    @Test
    fun update_objectInToDc_with_the_assertion_true() {
        runBlocking {
            dcRepository.insertIntoDc(FakeData.dcObject1)
            dcRepository.insertIntoDc(FakeData.dcObject1)
            val result = dcRepository.retrieveAllFromDc()
            assertEquals(FakeData.dcObject1, result.first().first())
        }


    }

    @Test
    fun retrieve_allObjects_with_the_assertion_true() {
        runBlocking {
            dcRepository.insertIntoDc(FakeData.dcObject1)
            dcRepository.insertIntoDc(FakeData.dcObject2)
            dcRepository.insertIntoDc(FakeData.dcObject3)
            val result = dcRepository.retrieveAllFromDc()
            assertEquals(FakeData.data, result.first())
        }


    }

    @Test
    fun retrieve_objectsWithCondition_with_the_assertion_true() {
        runBlocking {
            dcRepository.insertIntoDc(FakeData.dcObject1)
            dcRepository.insertIntoDc(FakeData.dcObject2)
            dcRepository.insertIntoDc(FakeData.dcObject3)
            val result = dcRepository.retrieveAllFromDcByCondition("10")
            assertEquals(FakeData.data, result.first())
        }


    }


}