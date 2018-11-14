package com.maclaurin.footballclub.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.maclaurin.footballclub.R
import com.maclaurin.footballclub.model.Team
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*

class ClubAdapter(private var teams: List<Team>, private val onClickListener: (Team) -> Unit) :
    RecyclerView.Adapter<ClubAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout_club, parent, false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], onClickListener)
    }

    inner class TeamViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private val teamBadge: ImageView = containerView.find(R.id.iv_club_list)
        private val teamName: TextView = containerView.find(R.id.tv_club_list)

        fun bindItem(teams: Team, onClickListener: (Team) -> Unit) {
            Picasso.get().load(teams.teamBadge).into(teamBadge)
            teamName.text = teams.teamName

            containerView.setOnClickListener {
                onClickListener(teams)
            }
        }
    }
}