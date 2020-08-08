package com.example.onbid.data

import java.io.Serializable

data class LoginData(
    val email:String,
    val password:String,
    val name:String?=null
):Serializable