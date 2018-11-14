package com.maclaurin.footballclub.util

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

class VerticalLineDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = space

        outRect.bottom = space
        outRect.left = space
        outRect.right = space
    }
}