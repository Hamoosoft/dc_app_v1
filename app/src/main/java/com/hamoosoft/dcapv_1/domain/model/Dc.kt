package com.hamoosoft.dcapv_1.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dc")
data class Dc(
    @PrimaryKey
    val f01: Int,
    val f02: Int,
    val f03: Int
)
