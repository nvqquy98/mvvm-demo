package com.odinwar.mvvmdemoapp.data.source

import com.odinwar.mvvmdemoapp.data.model.MovieItem
import com.odinwar.mvvmdemoapp.data.model.ResponseTrending
import com.odinwar.mvvmdemoapp.data.model.TypeTrending
import io.reactivex.rxjava3.core.Observable

interface MovieDataSource {
    interface Local

    interface Remote {
        fun getDataTrending(
            typeTrending: TypeTrending,
            page: Int
        ): Observable<ResponseTrending<List<MovieItem>>>
    }
}
