package com.appclr8.colourmyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.appclr8.colourmyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                binding.boxFourText, binding.boxFiveText, binding.redButton, binding.yellowButton,
                binding.greenButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColoured(it)}
        }
    }

    private fun makeColoured(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.red)
            R.id.yellow_button -> binding.boxFourText.setBackgroundResource(R.color.yellow)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(R.color.green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}