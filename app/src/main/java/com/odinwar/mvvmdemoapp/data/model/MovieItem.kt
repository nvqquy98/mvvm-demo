package com.odinwar.mvvmdemoapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("overview")
    @Expose
    val overview: String? = null,
    @SerializedName("poster_path")
    @Expose
    val imageUrl: String? = null,
    @SerializedName("vote_average")
    @Expose
    val rate: Double? = null
)
