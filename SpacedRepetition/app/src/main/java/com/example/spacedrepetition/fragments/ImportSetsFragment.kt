package com.example.spacedrepetition.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.spacedrepetition.R
import com.example.spacedrepetition.data.Sets
import com.example.spacedrepetition.data.SetsViewModel
import kotlinx.android.synthetic.main.fragment_import_sets.*
import kotlinx.android.synthetic.main.fragment_import_sets.view.*


class ImportSetsFragment : Fragment() {
    private lateinit var mSetsViewModel: SetsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_import_sets, container, false)

        mSetsViewModel = ViewModelProvider(this).get(SetsViewModel::class.java)

        view.button_save.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }
    private fun insertDataToDatabase() {
        val title = editTextFile.text.toString()
        val setDetails = editTextData.text.toString()


        if(inputCheck(title, setDetails)){
            // Create User Object
            val sets = Sets(0, title, setDetails)
            // Add Data to Database
            mSetsViewModel.addSets(sets)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(title: String, setDetails: String): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(setDetails))
    }
}