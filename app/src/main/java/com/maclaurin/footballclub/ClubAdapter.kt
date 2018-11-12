package com.maclaurin.footballclub

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*

class ClubAdapter(private var items: List<Club>, private val onClickListener: (Club) -> Unit) :
    RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout_club, parent, false)
        return ClubViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(items[position], onClickListener)
    }

    inner class ClubViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private val ivClubImage: ImageView = containerView.find(R.id.iv_club_list)
        private val tvClubName: TextView = containerView.find(R.id.tv_club_list)

        fun bindItem(club: Club, onClickListener: (Club) -> Unit) {
            tvClubName.text = club.name
            ivClubImage.setImageResource(club.image)

            containerView.setOnClickListener {
                onClickListener(club)
            }
        }
    }
}