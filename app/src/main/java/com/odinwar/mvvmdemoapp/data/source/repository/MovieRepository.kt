package com.odinwar.mvvmdemoapp.data.source.repository

import com.odinwar.mvvmdemoapp.data.model.MovieItem
import com.odinwar.mvvmdemoapp.data.model.ResponseTrending
import com.odinwar.mvvmdemoapp.data.model.TypeTrending
import com.odinwar.mvvmdemoapp.data.source.MovieDataSource
import com.odinwar.mvvmdemoapp.data.source.local.MovieLocalSourceImpl
import com.odinwar.mvvmdemoapp.data.source.remote.MovieRemoteSourceImpl
import io.reactivex.rxjava3.core.Observable

class MovieRepository private constructor(
    private val local: MovieDataSource.Local,
    private val remote: MovieDataSource.Remote
) {

    companion object {
        fun newInstance() =
            MovieRepository(MovieLocalSourceImpl.newInstance(), MovieRemoteSourceImpl.newInstance())
    }

    fun getMovieTrending(
        typeTrending: TypeTrending,
        page: Int,
    ): Observable<ResponseTrending<List<MovieItem>>> {
        return remote.getDataTrending(typeTrending, page)
    }
}
