package com.hamoosoft.dcapv_1.test_di

import android.content.Context
import androidx.room.Room
import com.hamoosoft.dcapv_1.data.dc_db.DcDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    @Provides
    @Named("dc_db")
    fun provideTestDb(@ApplicationContext context: Context): DcDb =
        Room.inMemoryDatabaseBuilder(context, DcDb::class.java).allowMainThreadQueries().build()
}