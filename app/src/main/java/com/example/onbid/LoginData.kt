package com.example.onbid

import java.io.Serializable

data class LoginData(
    val email:String,
    val password:String,
    val name:String
):Serializable