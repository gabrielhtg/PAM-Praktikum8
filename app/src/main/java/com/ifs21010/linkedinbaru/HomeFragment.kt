package com.ifs21010.linkedinbaru

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listDataPostingan : ArrayList<DataPostingan> = ArrayList()

        val recyclerView : RecyclerView = view.findViewById(R.id.home_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val data1 = DataPostingan(
            R.drawable.profile,
            "Gabriel Cesar Hutagalung",
            resources.getString(R.string.caption_1),
            R.drawable.semat
        )

        val data2 = DataPostingan(
            R.drawable.poltak,
            "Ruhut Poltak Sitompul",
            resources.getString(R.string.caption_2),
            R.drawable.caption_ruhut
        )

        listDataPostingan.add(data1)
        listDataPostingan.add(data2)

        val adapter = MyAdapter(listDataPostingan)
        recyclerView.adapter = adapter
    }
}