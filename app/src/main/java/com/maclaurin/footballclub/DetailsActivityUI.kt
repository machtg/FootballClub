package com.maclaurin.footballclub

import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*

class DetailsActivityUI(private var list: Club) : AnkoComponent<DetailsActivity> {

    override fun createView(ui: AnkoContext<DetailsActivity>) = with(ui){
        linearLayout{
            orientation = LinearLayout.VERTICAL
            lparams(matchParent, matchParent)

            imageView{
                padding = dip(10)
                setImageResource(list.image)
                this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
            }.lparams{
                height = dip(100)
                width = dip(100)
            }

            textView {
                textSize = 16f
                text = list.name
            }.lparams{
                margin = dip(2)
            }

            textView {
                textSize = 12f
                text = list.info
            }.lparams{
                margin = dip(10)
            }

        }
    }
}
