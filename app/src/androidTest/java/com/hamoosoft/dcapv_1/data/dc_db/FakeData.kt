package com.hamoosoft.dcapv_1.data.dc_db

import com.hamoosoft.dcapv_1.domain.model.Dc

object FakeData {
    val dcObject1 = Dc(f01 = 1, f02 = 10, f03 = 3)
    val dcObject2 = Dc(f01 = 2, f02 = 10, f03 = 30)
    val dcObject3 = Dc(f01 = 3, f02 = 10, f03 = 40)
    val data = mutableListOf(dcObject1, dcObject2, dcObject3)
}
