package com.example.designslidefrom23until26.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.designslidefrom23until26.R


/** Функция открывает фрагменты из фрагментов.
 */
fun Fragment.openFragmentFromFragment(fragment: Fragment) {
    (activity as AppCompatActivity).supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.fragmentHolder, fragment)
        .commit()
}


/** Функция открывает фрагменты из активити.
 */
fun AppCompatActivity.openFragmentFromActivity(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.fragmentHolder, fragment)
        .commit()
}