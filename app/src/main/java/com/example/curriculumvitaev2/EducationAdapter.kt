package com.example.curriculumvitaev2

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class EducationAdapter(var EducationList: MutableList<Education>) : RecyclerView.Adapter<EducationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_layout_education, parent, false)
    return EducationViewHolder(view)
}

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val cName = EducationList[position].universityName
        val cAddr = EducationList[position].universityAddress
        val startDate = EducationList[position].startDate.toString()
        val finalDate = EducationList[position].endDate.toString()
        val schoolImage = setImageURI(EducationList[position].image.toUri())

      holder.btnDelete.setOnClickListener {
            AppDataBase.getDatabase(holder.itemView.context).EducationDao()
                .delete(EducationList[position])
            EducationList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    private fun setImageURI(toUri: Uri): Any {

    }

    override fun getItemCount() = EducationList.size
    }
}
