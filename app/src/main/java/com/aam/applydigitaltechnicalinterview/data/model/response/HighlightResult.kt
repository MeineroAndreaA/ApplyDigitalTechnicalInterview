package com.aam.applydigitaltechnicalinterview.data.model.response

import com.google.gson.annotations.SerializedName

data class HighlightResult(
    @SerializedName("author") var author: Author?,
    @SerializedName("title") var title: Title?,
    @SerializedName("url") var url: Url?,
    @SerializedName("story_title") var storyTitle: StoryTitle?,
    @SerializedName("story_url") var storyUrl: StoryUrl?
)