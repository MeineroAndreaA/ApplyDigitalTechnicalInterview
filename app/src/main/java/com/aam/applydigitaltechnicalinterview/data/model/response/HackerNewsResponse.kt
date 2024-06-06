package com.aam.applydigitaltechnicalinterview.data.model.response

import com.google.gson.annotations.SerializedName

data class HackerNewsResponse(
    @SerializedName("hits") var listHits: List<Hits>
)
