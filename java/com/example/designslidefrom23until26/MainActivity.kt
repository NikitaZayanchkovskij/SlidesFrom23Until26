package com.example.designslidefrom23until26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designslidefrom23until26.databinding.ActivityMainBinding
import com.example.designslidefrom23until26.fragments.FifthFragmentHome
import com.example.designslidefrom23until26.fragments.FirstFragmentFavourites
import com.example.designslidefrom23until26.fragments.FourthFragmentNews
import com.example.designslidefrom23until26.fragments.SecondFragmentMusic
import com.example.designslidefrom23until26.fragments.ThirdFragmentPlaces
import com.example.designslidefrom23until26.users_and_items.User
import com.example.designslidefrom23until26.users_and_items.UserGenerator
import com.example.designslidefrom23until26.utils.openFragmentFromActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userList: ArrayList<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* При открытии приложения генерируем 30 пользователей, которые будет использовать на первом,
         * втором и пятом экране/фрагменте.
         */
        generate30Users()

        bottomMenuButtons()

        /* Extension функция. */
        openFragmentFromActivity(FirstFragmentFavourites(userList))
    }


    /** Слушатели нажатий на кнопки нижнего меню.
     */
    private fun bottomMenuButtons() {

        binding.bottomNavView.setOnItemSelectedListener { menuButton ->

            when (menuButton.itemId) {
                R.id.favourites -> {
                    openFragmentFromActivity(FirstFragmentFavourites(userList))
                }
                R.id.music -> {
                    openFragmentFromActivity(SecondFragmentMusic(userList))
                }
                R.id.places -> {
                    openFragmentFromActivity(ThirdFragmentPlaces())
                }
                R.id.news -> {
                    openFragmentFromActivity(FourthFragmentNews())
                }
                R.id.home -> {
                    openFragmentFromActivity(FifthFragmentHome(userList))
                }
            }

            true
        }
    }


    /** Функция генерирует и возвращает 30 рандомных пользователей.
     */
    private fun generate30Users() {
        val generatedUserList = arrayListOf<User>()

        for (i in 1..30) {
            val user = UserGenerator.generateUser()
            val userToAdd = user.copy(userNumber = i)
            generatedUserList.add(userToAdd)
        }

        userList = generatedUserList
    }


}