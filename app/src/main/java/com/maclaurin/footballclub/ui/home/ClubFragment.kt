package com.maclaurin.footballclub.ui.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.gson.Gson
import com.maclaurin.footballclub.R
import com.maclaurin.footballclub.R.array.league
import com.maclaurin.footballclub.api.ApiRepository
import com.maclaurin.footballclub.model.Team
import com.maclaurin.footballclub.ui.clubdetails.ClubDetailsActivity
import com.maclaurin.footballclub.util.invisible
import com.maclaurin.footballclub.util.visible
import com.maclaurin.footballclub.util.VerticalLineDecoration
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh


class ClubFragment : Fragment(), ClubView {
    private var teams: MutableList<Team> = mutableListOf()
    private lateinit var presenter: ClubPresenter
    private lateinit var adapter: ClubAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var leagueName: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val clubView = inflater.inflate(R.layout.fragment_club, container, false)

        progressBar = clubView.findViewById(R.id.progressBar_club)

        swipeRefresh = clubView.findViewById(R.id.swipeRefresh_club)

        val spinnerClub = clubView.findViewById(R.id.spinner_club) as Spinner
        val spinnerItems = resources.getStringArray(league)
        val spinnerAdapter = ArrayAdapter(this.ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spinnerClub.adapter = spinnerAdapter

        val rvClub = clubView.findViewById(R.id.rv_club) as RecyclerView
        rvClub.layoutManager = LinearLayoutManager(context)
        adapter = ClubAdapter(teams) {
            activity?.startActivity<ClubDetailsActivity>("teams" to it)
        }
        rvClub.adapter = adapter
        rvClub.addItemDecoration(VerticalLineDecoration(10))

        val request = ApiRepository()
        val gson = Gson()
        presenter = ClubPresenter(this, request, gson)

        spinnerClub.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                leagueName = spinnerClub.selectedItem.toString()
                presenter.getTeamList(leagueName)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        swipeRefresh.onRefresh {
            presenter.getTeamList(leagueName)
        }

        return clubView
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showTeamList(data: List<Team>) {
        swipeRefresh.isRefreshing = false
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }

}