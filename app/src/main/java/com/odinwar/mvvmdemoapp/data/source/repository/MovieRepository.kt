package com.odinwar.mvvmdemoapp.data.source.repository

import com.odinwar.mvvmdemoapp.data.source.MovieDataSource
import com.odinwar.mvvmdemoapp.data.source.local.MovieLocalSourceImpl
import com.odinwar.mvvmdemoapp.data.source.remote.MovieRemoteSourceImpl

class MovieRepository private constructor(
    private val local: MovieDataSource.Local,
    private val remote: MovieDataSource.Remote
) {

    companion object {
        fun newInstance() =
            MovieRepository(MovieLocalSourceImpl.newInstance(), MovieRemoteSourceImpl.newInstance())
    }
}