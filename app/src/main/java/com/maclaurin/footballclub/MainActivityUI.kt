package com.maclaurin.footballclub

import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainActivityUI : AnkoComponent<MainActivity> {

    lateinit var rvClubs: RecyclerView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            rvClubs = recyclerView {
                padding = dip(4)
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}