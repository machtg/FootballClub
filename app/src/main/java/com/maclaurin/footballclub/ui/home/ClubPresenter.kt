package com.maclaurin.footballclub.ui.home

import com.google.gson.Gson
import com.maclaurin.footballclub.api.ApiRepository
import com.maclaurin.footballclub.api.TheSportsDBApi
import com.maclaurin.footballclub.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ClubPresenter (
    private val view: ClubView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(
                TheSportsDBApi.getTeams(league)),
            TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

}