package com.aam.applydigitaltechnicalinterview.data

import com.google.gson.annotations.SerializedName


data class CommentText(

    @SerializedName("fullyHighlighted") var fullyHighlighted: Boolean? = null,
    @SerializedName("matchLevel") var matchLevel: String? = null,
    @SerializedName("matchedWords") var matchedWords: ArrayList<String> = arrayListOf(),
    @SerializedName("value") var value: String? = null

)