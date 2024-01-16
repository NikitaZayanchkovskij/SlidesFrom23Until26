package com.example.designslidefrom23until26.users_and_items


data class User (

    val firstName: String,
    val lastName: String,
    val age: String,
    val gender: String,
    val squareAvatarUrl: Int,
    val description: String,
    val userNumber: Int = 0

)
