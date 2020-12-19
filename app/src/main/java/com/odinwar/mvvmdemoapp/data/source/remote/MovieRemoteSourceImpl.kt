package com.odinwar.mvvmdemoapp.data.source.remote

import com.odinwar.mvvmdemoapp.data.model.MovieItem
import com.odinwar.mvvmdemoapp.data.model.ResponseTrending
import com.odinwar.mvvmdemoapp.data.model.TypeTrending
import com.odinwar.mvvmdemoapp.data.source.MovieDataSource
import com.odinwar.mvvmdemoapp.data.source.remote.getapi.GetDataFromApi
import com.odinwar.mvvmdemoapp.data.source.remote.getapi.GetMovieTrendingService
import com.odinwar.mvvmdemoapp.utils.Constant
import io.reactivex.rxjava3.core.Observable

class MovieRemoteSourceImpl private constructor() : MovieDataSource.Remote {

    override fun getDataTrending(
        typeTrending: TypeTrending,
        page: Int
    ): Observable<ResponseTrending<List<MovieItem>>> {
        val stringURL = Constant.BASE_URL + "movie/"
        return GetDataFromApi.loadDataFromApi(stringURL, GetMovieTrendingService::class.java)
            .getMovieTrending(
                typeTrending.path, mapOf(Constant.ARG_PAGE to page.toString())
            )
    }

    companion object {
        fun newInstance() = MovieRemoteSourceImpl()
    }
}
