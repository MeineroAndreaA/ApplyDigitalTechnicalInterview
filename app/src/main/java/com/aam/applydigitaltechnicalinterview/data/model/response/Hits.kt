package com.aam.applydigitaltechnicalinterview.data.model.response

import com.google.gson.annotations.SerializedName


data class Hits(
    @SerializedName("author") var author: String?,
    @SerializedName("comment_text") var commentText: String?,
    @SerializedName("created_at") var createdAt: String?,
    @SerializedName("objectID") var objectID: String?,
    @SerializedName("parent_id") var parentId: Int?,
    @SerializedName("story_id") var storyId: Int?,
    @SerializedName("story_url") var storyUrl: String?,
    @SerializedName("url") var url: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("story_title") var storyTitle: String?
)