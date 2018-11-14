package com.maclaurin.footballclub.ui.clubdetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.maclaurin.footballclub.model.Team
import org.jetbrains.anko.*

class ClubDetailsActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(16)
            nameTextView = textView()
        }

        val list = intent.getParcelableExtra<Team>("teams")

        ClubDetailsActivityUI(list).setContentView(this)
    }
}