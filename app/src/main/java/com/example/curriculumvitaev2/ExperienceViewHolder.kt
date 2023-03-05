package com.example.curriculumvitaev2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val companyName : TextView = itemView.findViewById<TextView>(R.id.companyName)
    val companyAddress : TextView = itemView.findViewById<TextView>(R.id.companyAddress)
    val startDate : TextView = itemView.findViewById<TextView>(R.id.startDate)
    val finalDate : TextView = itemView.findViewById<TextView>(R.id.finalDate)
    val schoolImage : ImageView = itemView.findViewById<ImageView>(R.id.schoolImage)
    val btnDelete : ImageView = itemView.findViewById(R.id.btnDelete)
}