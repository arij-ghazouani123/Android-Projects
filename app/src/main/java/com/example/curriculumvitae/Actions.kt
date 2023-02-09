package com.example.curriculumvitae

import android.content.Context
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import android.util.Patterns.EMAIL_ADDRESS
import androidx.core.content.ContextCompat

fun clearForm(ctx: Context, gender: RadioGroup, inputs: List<EditText>, skills: List<SeekBar>) {

    gender.check(R.id.radHomme)

    inputs
        .forEach {
            it.clearFocus()
            it.setText("")
        }

    skills
        .forEach {
            with(it) {
                progress = 0
                progressDrawable.setTint(ContextCompat.getColor(ctx, R.color.resetSeekBar))
                thumb.setTint(ContextCompat.getColor(ctx, R.color.colorSecondary))
            }
        }
}

fun nextAction(ctx: Context, inputs: List<EditText>, skills: List<SeekBar>) {

    if (!verifyInputs(inputs))
        makeToast(ctx, "Check your input!")
    else
        checkSkills(ctx, skills)

}

fun verifyInputs(inputs: List<EditText>): Boolean {
    val empty = inputs.all { it.text.isBlank() }
    val emailInput = inputs.find { it.id == R.id.emailInput }
    return !empty && EMAIL_ADDRESS.matcher(emailInput!!.text.toString()).matches()
}

fun makeToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun checkSkills(context: Context, skills: List<SeekBar>) {

    val maxedSkill = skills.maxBy { it.progress }

    var maxedSkillName = ""

    when (maxedSkill.id) {
        R.id.andrSkBar -> maxedSkillName = "Android"
        R.id.iosSkBar -> maxedSkillName = "iOS"
        R.id.flutterSkBar -> maxedSkillName = "Flutter"
    }

    when {

        skills.all {it.progress == 100} -> makeToast(context, "Vous avez d'excellent skills!")

        maxedSkill.progress > 80 -> makeToast(context, "Vous êtes excellent en $maxedSkillName")

        skills.all { it.progress <= 30 } ->
            makeToast(context, "work for your skills")

        else ->
            makeToast(context, "Vous avez de bons skills !")
    }
}
