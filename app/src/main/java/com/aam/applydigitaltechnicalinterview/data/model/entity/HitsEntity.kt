package com.aam.applydigitaltechnicalinterview.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Hits")
data class HitsEntity(
    @PrimaryKey(autoGenerate = true) val hitId: Int = 0,
    var entries : Int? = null,
    var author: String? = null,
    var commentText: String? = null,
    var createdAt: String? = null,
    var createdAtI: Int? = null,
    var objectID: String? = null,
    var parentId: Int? = null,
    var storyId: Int? = null,
    var storyTitle: String? = null,
    var storyUrl: String? = null,
    var updatedAt: String? = null
)