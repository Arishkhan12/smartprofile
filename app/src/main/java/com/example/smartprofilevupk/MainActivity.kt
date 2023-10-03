package com.example.smartprofilevupk

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private lateinit var  addprofile: Button
    private lateinit var  viewProfileButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addprofile.setOnClickListener {
            replaceFragment(AddProfileFragment())
        }

        viewProfileButton.setOnClickListener {
            replaceFragment(ViewProfileFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
