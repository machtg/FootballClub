package com.maclaurin.footballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*

class ClubAdapter(private var items: List<Club>, private val clickListener: (Club) -> Unit) :
    RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(ClubAdapterUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(items[position], clickListener)
    }

    inner class ClubViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private val ivClubImage: ImageView = containerView.find(R.id.club_image)
        private val tvClubName: TextView = containerView.find(R.id.club_name)

        fun bindItem(club: Club, clickListener: (Club) -> Unit) {
            tvClubName.text = club.name
            ivClubImage.setImageResource(club.image)

            containerView.setOnClickListener {
                clickListener(club)
            }
        }
    }
}