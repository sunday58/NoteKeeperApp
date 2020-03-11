package com.notekeeping.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notekeeping.*

class CourseFragment : Fragment() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var listItem : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_course, container, false)
       listItem = root.findViewById(R.id.listItems)

        displayCourses()
        return root
    }

    private fun displayCourses() {
        listItem.layoutManager = GridLayoutManager(parentFragment?.context, 2)
        listItem.adapter = CourseRecyclerAdapter(requireContext(), DataManager.courses.values.toList())
    }
}
