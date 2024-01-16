package com.example.designslidefrom23until26.users_and_items

import com.example.designslidefrom23until26.R


object UserGenerator {

    private val namesArray = arrayOf("Name 1", "Name 2", "Name 3", "Name 4", "Name 5", "Name 6",
        "Name 7", "Name 8", "Name 9", "Name 10", "Name 11", "Name 12", "Name 13", "Name 14",
        "Name 15", "Name 16", "Name 17", "Name 18", "Name 19", "Name 20", "Name 21", "Name 22",
        "Name 23", "Name 24", "Name 25", "Name 26", "Name 27", "Name 28", "Name 29", "Name 30")

    private val lastNamesArray = arrayOf("Last name 1", "Last name 2", "Last name 3", "Last name 4",
        "Last name 5", "Last name 6", "Last name 7", "Last name 8", "Last name 9", "Last name 10",
        "Last name 11", "Last name 12", "Last name 13", "Last name 14", "Last name 15",
        "Last name 16", "Last name 17", "Last name 18", "Last name 19", "Last name 20",
        "Last name 21", "Last name 22", "Last name 23", "Last name 24", "Last name 25",
        "Last name 26", "Last name 27", "Last name 28", "Last name 29", "Last name 30")

    private val agesArray = arrayOf("18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
        "43", "44", "45", "46", "47")

    private val gendersArray = arrayOf("male", "female")

    private val descriptionsArray = arrayOf("One line user description",
        "Multiple lines user description.\nFirst line description.\nSecond line description. ")


    fun generateUser(): User {
        val randomName = namesArray[(0..29).random()]
        val randomLastName = lastNamesArray[(0..29).random()]
        val randomAge = agesArray[(0..29).random()]
        val randomGender = gendersArray[(0..1).random()]
        val avatar = R.drawable.avatar
        val randomDescription = descriptionsArray[(0..1).random()]

        val user = User(randomName, randomLastName, randomAge, randomGender, avatar, randomDescription)

        return user
    }


}