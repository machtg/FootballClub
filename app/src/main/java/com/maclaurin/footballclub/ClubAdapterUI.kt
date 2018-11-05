package com.maclaurin.footballclub

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ClubAdapterUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView(R.drawable.img_barca) {
                    id = R.id.club_image
                }.lparams{
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.club_name
                    textSize = 16f
                    text = ""
                }.lparams{
                    margin = dip(15)
                }

            }
        }
    }
}