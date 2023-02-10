package com.example.colormixer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ChooseScreenActivity : AppCompatActivity() {


    private lateinit var titleMsg: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var chosenColor: RadioButton
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_screen)



        titleMsg = findViewById(R.id.ChosenColorsText)
        submitBtn = findViewById(R.id.submitBtn)

        var selectedAnswer = ""
        var correctAnswer = ""

        val color1 = intent.getStringExtra("color1")
        val color2 = intent.getStringExtra("color2")
        val username = intent.getStringExtra("username")

        fun showToast(context: Context, msg: String) {

            Toast.makeText(
                context,
                msg,
                Toast.LENGTH_SHORT
            ).show()
        }

        titleMsg.text = "You chose $color1 and $color2"

        when {
            color1 == "Red" && color2 == "Blue" -> correctAnswer = "purple"
            color1 == "Red" && color2 == "Yellow" -> correctAnswer = "orange"
            color1 == "Blue" && color2 == "Yellow" -> correctAnswer = "green"
        }

        submitBtn.setOnClickListener {


            radioGroup = findViewById(R.id.radioGrp)
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId

            if (checkedRadioButtonId == -1) showToast(this, "Please select an answer")
            else {

                chosenColor = findViewById(checkedRadioButtonId)

                when (chosenColor.id) {
                    R.id.purpleRad -> selectedAnswer = "purple"
                    R.id.orangeRad -> selectedAnswer = "orange"
                    R.id.greenRad -> selectedAnswer = "green"
                }

                val isCorrect = correctAnswer == selectedAnswer

                Intent(this, ResultScreenActivity::class.java).let {

                    it.putExtra("isCorrect", isCorrect)
                    it.putExtra("username", username)
                    startActivity(it)
                }
            }
        }
    }
}