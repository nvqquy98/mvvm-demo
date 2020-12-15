package com.odinwar.mvvmdemoapp.utils

import com.odinwar.mvvmdemoapp.BuildConfig

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500"
    const val DEFAULT_PAGE = 1
    const val BASE_PAGE = "&page="
    const val BASE_LANGUAGE = "&language=en-US"
    const val BASE_API_KEY = "?api_key=" + BuildConfig.API_KEY
    const val NULL_STRING = "null"
    const val NUMBER_0 = 0
    const val NUMBER_10 = 10
    const val DO_SOME_THING = -1
    const val VISIBLE_THRESHOLD = 5
}