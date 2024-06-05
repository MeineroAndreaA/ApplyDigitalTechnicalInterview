package com.aam.applydigitaltechnicalinterview.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Hits")
data class HitsEntity(
    @PrimaryKey var objectID: String,
    var title: String,
    var author: String? = null,
    var commentText: String? = null,
    var createdAt: String? = null,
    var parentId: Int? = null,
    var storyId: Int? = null,
    var storyUrl: String? = null
)