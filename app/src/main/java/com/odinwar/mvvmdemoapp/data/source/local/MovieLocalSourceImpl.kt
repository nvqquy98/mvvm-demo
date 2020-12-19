package com.odinwar.mvvmdemoapp.data.source.local

import android.content.Context
import com.odinwar.mvvmdemoapp.data.source.MovieDataSource

class MovieLocalSourceImpl private constructor(private val context: Context?) :
    MovieDataSource.Local {

    companion object {
        fun newInstance(context: Context? = null) = MovieLocalSourceImpl(context)
    }
}
