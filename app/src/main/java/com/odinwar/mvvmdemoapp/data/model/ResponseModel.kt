package com.odinwar.mvvmdemoapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseTrending<T>(
    @SerializedName("page")
    @Expose
    val pageCurrent: Int? = null,
    @SerializedName("total_pages")
    @Expose
    val totalPages: Int? = null,
    @SerializedName("results")
    @Expose
    val data: T? = null
)
