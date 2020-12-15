package com.odinwar.mvvmdemoapp.data.source.remote

import com.odinwar.mvvmdemoapp.data.source.MovieDataSource

class MovieRemoteSourceImpl private constructor() : MovieDataSource.Remote {

    companion object {
        fun newInstance() = MovieRemoteSourceImpl()
    }
}