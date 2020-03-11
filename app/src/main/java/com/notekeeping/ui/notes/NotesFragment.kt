package com.notekeeping.ui.notes

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notekeeping.DataManager
import com.notekeeping.ItemsActivity
import com.notekeeping.NoteRecyclerAdapter
import com.notekeeping.R
import kotlinx.android.synthetic.main.content_items.*
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment() {

    private lateinit var notesViewMobile: NotesViewMobile
    private lateinit var listItems : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notes, container, false)

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
}
