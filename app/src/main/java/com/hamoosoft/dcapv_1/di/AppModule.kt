package com.hamoosoft.dcapv_1.di

import android.content.Context
import androidx.room.Room
import com.hamoosoft.dcapv_1.data.dc_db.DcDao
import com.hamoosoft.dcapv_1.data.dc_db.DcDb
import com.hamoosoft.dcapv_1.data.repository_imp.DcRepositoryImp
import com.hamoosoft.dcapv_1.domain.repository.DcRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDcDb(@ApplicationContext context: Context): DcDb =
        Room.databaseBuilder(context = context, klass = DcDb::class.java, name = "dc_db")
            .allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideDcDao(dcDb: DcDb): DcDao = dcDb.dcDao()

    @Provides
    @Singleton
    fun provideDcRepository(dcDao: DcDao): DcRepository = DcRepositoryImp(dcDao)
}