package com.maclaurin.footballclub.ui.home

import com.maclaurin.footballclub.model.Team

interface ClubView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}