package com.example.spacedrepetition.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacedrepetition.R
import com.example.spacedrepetition.fragments.RecyclerViewAdapter
import com.example.spacedrepetition.data.SetsViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    private lateinit var setsViewModel: SetsViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    var recycleViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Recyclerview
        val adapter = RecyclerViewAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        setsViewModel = ViewModelProvider(this).get(SetsViewModel::class.java)
        setsViewModel.readAllData.observe(viewLifecycleOwner, Observer { sets ->
            adapter.setData(sets)
        })
        return view
    }


}

