package com.notekeeping.ui.notes

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelProviders.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notekeeping.DataManager
import com.notekeeping.ItemsActivity
import com.notekeeping.NoteRecyclerAdapter
import com.notekeeping.R
import kotlinx.android.synthetic.main.content_items.*
import kotlinx.android.synthetic.main.fragment_notes.*
import java.util.EnumSet.of
import java.util.Optional.of

class NotesFragment : Fragment() {

    private lateinit var notesViewMobile: NotesViewMobile
    private lateinit var listItems : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        notesViewMobile = activity?.run {
//            ViewModelProviders.of(this).get(NotesViewMobile::class.java)
//        } ?: throw Exception("Invalid Activity")
        val root = inflater.inflate(R.layout.fragment_notes, container, false)

//        notesViewMobile.text.observe(viewLifecycleOwner, Observer {
//            notesViewMobile.text
//        })

         listItems = root.findViewById(R.id.listItems)
        displayNotes()

        return root
    }

   private fun displayNotes() {
        listItems.layoutManager = LinearLayoutManager(parentFragment?.context)
        listItems.adapter = NoteRecyclerAdapter(requireContext(), DataManager.notes)
   }

    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}
