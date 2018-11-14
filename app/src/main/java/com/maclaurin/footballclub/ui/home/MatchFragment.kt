package com.maclaurin.footballclub.ui.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.maclaurin.footballclub.R
import org.jetbrains.anko.support.v4.ctx

class MatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val matchView = inflater.inflate(R.layout.fragment_match, container, false)

        val spinnerMatch = matchView.findViewById(R.id.spinner_match) as Spinner
        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(this.ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spinnerMatch.adapter = spinnerAdapter

        return matchView
    }

}
