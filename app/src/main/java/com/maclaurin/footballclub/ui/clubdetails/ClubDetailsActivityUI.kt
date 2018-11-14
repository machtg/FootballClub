package com.maclaurin.footballclub.ui.clubdetails

import android.view.Gravity
import android.widget.LinearLayout
import com.maclaurin.footballclub.model.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class ClubDetailsActivityUI(private var teams: Team) : AnkoComponent<ClubDetailsActivity> {

    override fun createView(ui: AnkoContext<ClubDetailsActivity>) = with(ui){
        linearLayout{
            orientation = LinearLayout.VERTICAL
            lparams(matchParent, matchParent)

            imageView{
                padding = dip(10)
                Picasso.get().load(teams.teamBadge).into(this)
                this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
            }.lparams{
                height = dip(100)
                width = dip(100)
            }

            textView {
                textSize = 16f
                text = teams.teamName
            }.lparams{
                margin = dip(2)
            }

            scrollView {
                textView {
                    bottomPadding = dip(15)
                    textSize = 12f
                    text = teams.teamDescription
                }.lparams {
                    margin = dip(10)
                }
            }

        }
    }
}
