package com.hoomanholding.jpamanager.model.data.request

import com.hoomanholding.jpamanager.model.data.enums.SystemTypeEnum

/**
 * Created by m-latifi on 11/9/2022.
 */

data class LoginRequestModel(
    val userName : String,
    val password : String,
    val SystemType: SystemTypeEnum,
    val AndroidId: String
)
