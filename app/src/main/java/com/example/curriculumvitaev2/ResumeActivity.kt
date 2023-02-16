package com.example.curriculumvitaev2


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class ResumeActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var email: TextView



    private lateinit var toolbar: Toolbar



    private lateinit var basicInfoFragment: BasicInfoFragment

    private var cvObject: CvObject? = null

    private lateinit var sharedPrefs: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)



        sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)



        println("CV: $cvObject")



        setSupportActionBar(toolbar)

        name.text = cvObject!!.fullName
        email.text = cvObject!!.email




        basicInfoFragment = BasicInfoFragment.new(
            cvObject!!.fullName!!, cvObject!!.gender!!, cvObject!!.age!!, cvObject!!.email!!
        )








    }
}
