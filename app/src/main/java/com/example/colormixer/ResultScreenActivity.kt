package com.example.colormixer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ResultScreenActivity : AppCompatActivity() {


    private lateinit var resView: View
    private lateinit var resImg: ImageView
    private lateinit var resText: TextView
    private lateinit var resultText: TextView
    private lateinit var quitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        val isCorrect = intent.getBooleanExtra("isCorrect", false)
        val username = intent.getStringExtra("username")

        resView = findViewById(R.id.backgroundResult)
        resImg = findViewById(R.id.imgResult)
        resText = findViewById(R.id.resText)
        resultText = findViewById(R.id.resultText)
        quitBtn = findViewById(R.id.quitBtn)



        resView.setBackgroundResource(
            when {

                isCorrect -> R.color.success
                else -> R.color.error
            }
        )

        resImg.setImageResource(
            when {
                isCorrect -> R.drawable.check_img
                else -> R.drawable.error
            }
        )

        resText.text = when {
            isCorrect -> "Congratulations $username !"
            else -> "Sorry $username !"
        }

        resultText.text = when {
            isCorrect -> "Your answer is correct!"
            else -> "Your answer is wrong!"
        }

        quitBtn.setBackgroundColor(
            resources.getColor(
                when {
                    isCorrect -> R.color.success
                    else -> R.color.error
                }
            )
        )
    }
}