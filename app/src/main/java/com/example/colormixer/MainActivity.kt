package com.example.colormixer
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var usernameEditText: EditText
    private lateinit var nextButton: Button
    private lateinit var checkedColorR: CheckBox
    private lateinit var checkedColorB: CheckBox
    private lateinit var checkedColorY: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        usernameEditText = findViewById(R.id.usernameEt)
        nextButton = findViewById(R.id.nextBtn)
        checkedColorR = findViewById(R.id.redChx)
        checkedColorB = findViewById(R.id.blueChx)
        checkedColorY = findViewById(R.id.yellowChx)

        fun showToast(context: Context, msg: String) {

            Toast.makeText(
                context,
                msg,
                Toast.LENGTH_SHORT
            ).show()
        }

        nextButton.setOnClickListener {

            var color1 = ""
            var color2 = ""

            when {
                checkedColorR.isChecked
                        && checkedColorB.isChecked
                        && checkedColorY.isChecked -> {
                    showToast(this, "Select 2 colors")
                }

                else -> {

                    when {
                        checkedColorR.isChecked && checkedColorB.isChecked -> {
                            color1 = "Red"
                            color2 = "Blue"

                        }
                        checkedColorR.isChecked && checkedColorY.isChecked -> {

                            color1 = "Red"
                            color2 = "Yellow"
                        }
                        checkedColorB.isChecked && checkedColorY.isChecked -> {
                            color1 = "Blue"
                            color2 = "Yellow"
                        }
                    }

                    if (color1.isBlank() || color2.isBlank()) {
                        showToast(this, "Two colors must be checked verify")
                    } else
                        Intent(this, ChooseScreenActivity::class.java).let {

                            it.putExtra("username", usernameEditText.text.toString())
                            it.putExtra("color1", color1)
                            it.putExtra("color2", color2)
                            startActivity(it)
                        }
                }
            }
        }

    }
}