package com.maclaurin.footballclub


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*


class ClubFragment : Fragment() {

    private var items: MutableList<Club> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val clubView = inflater.inflate(R.layout.fragment_club, container, false)

        initData()

        val rvClub = clubView.findViewById(R.id.rv_club) as RecyclerView
        rvClub.layoutManager = LinearLayoutManager(context)

        rvClub.adapter = ClubAdapter(items) {
            activity?.startActivity<ClubDetailsActivity>("club" to it)
        }

        return clubView

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val info = resources.getStringArray(R.array.club_info)

        items.clear()

        for (i in name.indices) {
            items.add(Club(name[i],
                image.getResourceId(i, 0),
                info[i]))
        }

        image.recycle()
    }

}