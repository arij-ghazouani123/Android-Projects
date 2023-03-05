package com.example.curriculumvitaev2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class EducationFragment : Fragment() {

    private lateinit var schoolsRV: RecyclerView
    private lateinit var educationAdapter: EducationAdapter
    private lateinit var appDatabase: AppDataBase
    private lateinit var schoolsList: MutableList<Education>
    private lateinit var educationDao: EducationDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_fragment_education, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appDatabase = AppDataBase.getDatabase(view.context)
        educationDao = appDatabase.educationDao()
        val dbItems = educationDao.getAll()
        schoolsList = dbItems.toMutableList()
        schoolsRV = view.findViewById(R.id.schoolsRV)
        schoolsRV.adapter = educationAdapter
        schoolsRV.layoutManager = LinearLayoutManager(view.context)

        if (dbItems.size > schoolsList.size) {
            schoolsList.add(dbItems[schoolsList.size])
            educationAdapter.notifyItemInserted(schoolsList.size - 1)
        }
    }
}