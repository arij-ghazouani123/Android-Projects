package com.example.curriculumvitaev2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ExperienceFragment : Fragment() {

    private lateinit var companiesRV: RecyclerView
    private lateinit var experienceAdapter: ExperienceAdapter
    private lateinit var appDatabase: AppDataBase
    private lateinit var companiesList: MutableList<Experience>
    private lateinit var experienceDao: ExperienceDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appDatabase = AppDataBase.getDatabase(view.context)
        experienceDao = appDatabase.experienceDao()
        val dbItems = experienceDao.getAll()
        companiesList = dbItems.toMutableList()
        companiesRV = view.findViewById(R.id.companiesRV)
        experienceAdapter = ExperienceAdapter(companiesList)
        companiesRV.adapter = experienceAdapter
        companiesRV.layoutManager = LinearLayoutManager(view.context)

        if (dbItems.size > companiesList.size) {
            companiesList.add(dbItems[companiesList.size])
            experienceAdapter.notifyItemInserted(companiesList.size - 1)
        }
    }
}


