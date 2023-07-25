package com.hamoosoft.dcapv_1.data.dc_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hamoosoft.dcapv_1.domain.model.Dc

@Database(entities = [Dc::class], version = 1, exportSchema = true)
abstract class DcDb : RoomDatabase() {
    abstract fun dcDao(): DcDao
}