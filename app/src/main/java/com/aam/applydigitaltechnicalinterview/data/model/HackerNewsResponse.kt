package com.aam.applydigitaltechnicalinterview.data.model

import com.google.gson.annotations.SerializedName

data class HackerNewsResponse(

    @SerializedName("hitsPerPage") var hitsPerPage: Int,
    @SerializedName("hits") var listHits: List<Hits>
)
