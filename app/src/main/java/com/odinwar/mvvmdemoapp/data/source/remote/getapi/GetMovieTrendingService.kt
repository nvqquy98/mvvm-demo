package com.odinwar.mvvmdemoapp.data.source.remote.getapi

import com.odinwar.mvvmdemoapp.BuildConfig
import com.odinwar.mvvmdemoapp.data.model.MovieItem
import com.odinwar.mvvmdemoapp.data.model.ResponseTrending
import com.odinwar.mvvmdemoapp.utils.Constant
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface GetMovieTrendingService {
    @GET("{typeTrending}")
    fun getMovieTrending(
        @Path("typeTrending") trendingType: String,
        @QueryMap options: Map<String, String>,
        @Query(Constant.BASE_API_KEY) apiKey: String = BuildConfig.API_KEY
    ): Observable<ResponseTrending<List<MovieItem>>>
}
