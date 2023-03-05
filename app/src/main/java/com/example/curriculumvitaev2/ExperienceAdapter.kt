package com.example.curriculumvitaev2

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class ExperienceAdapter(var ExperienceList: MutableList<Experience>) : RecyclerView.Adapter<ExperienceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_layout_experience, parent, false)
        return ExperienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val companyName = ExperienceList[position].companyName
        val companyAddress = ExperienceList[position].companyAddress
        val startDate = ExperienceList[position].startDate.toString()
        val endDate = ExperienceList[position].endDate.toString()
        val companyImage = setImageURI(ExperienceList[position].image.toUri())

        holder.btnDelete.setOnClickListener {
            AppDataBase.getDatabase(holder.itemView.context).ExperienceDao()
                .delete(ExperienceList[position])
            ExperienceList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    private fun setImageURI(toUri: Uri): Any {

    }

    override fun getItemCount() = ExperienceList.size
}
}
