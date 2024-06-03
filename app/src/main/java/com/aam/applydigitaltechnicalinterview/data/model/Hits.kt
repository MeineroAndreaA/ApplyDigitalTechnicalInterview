package com.aam.applydigitaltechnicalinterview.data.model

import com.google.gson.annotations.SerializedName


data class Hits (

    @SerializedName("_highlightResult" ) var HighlightResult : HighlightResult?  = HighlightResult(),
    @SerializedName("_tags"            ) var Tags            : ArrayList<String> = arrayListOf(),
    @SerializedName("author"           ) var author          : String?           = null,
    @SerializedName("comment_text"     ) var commentText     : String?           = null,
    @SerializedName("created_at"       ) var createdAt       : String?           = null,
    @SerializedName("created_at_i"     ) var createdAtI      : Int?              = null,
    @SerializedName("objectID"         ) var objectID        : String?           = null,
    @SerializedName("parent_id"        ) var parentId        : Int?              = null,
    @SerializedName("story_id"         ) var storyId         : Int?              = null,
    @SerializedName("story_title"      ) var storyTitle      : String?           = null,
    @SerializedName("story_url"        ) var storyUrl        : String?           = null,
    @SerializedName("updated_at"       ) var updatedAt       : String?           = null

)