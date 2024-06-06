package com.aam.applydigitaltechnicalinterview.data.mapperutils

import com.aam.applydigitaltechnicalinterview.data.model.entity.HitsEntity
import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import com.aam.applydigitaltechnicalinterview.data.model.response.Hits

class Mapper {
    fun mapperToHitEntity(response: HackerNewsResponse): List<HitsEntity> {
        val listOfHitsEntities = response.listHits.map {
            HitsEntity(
                title = (if (it.title.isNullOrEmpty()) it.storyTitle else it.title)!!,
                author = it.author,
                commentText = it.commentText,
                createdAt = it.createdAt,
                objectID = it.objectID,
                storyId = it.storyId!!,
                storyUrl = (if (it.url.isNullOrEmpty()) it.storyUrl else it.url)
            )
        }
        return listOfHitsEntities
    }

    fun hackerNewsResponseMapped(hitsList: List<HitsEntity>): HackerNewsResponse {
        val listHits = mutableListOf<Hits>()
        for (hitEntity in hitsList) {
            listHits.add(
                Hits(
                    objectID = hitEntity.objectID,
                    author = hitEntity.author,
                    commentText = hitEntity.commentText,
                    createdAt = hitEntity.createdAt,
                    parentId = hitEntity.parentId,
                    storyId = hitEntity.storyId,
                    storyUrl = hitEntity.storyUrl,
                    url = hitEntity.storyUrl,
                    title = hitEntity.title,
                    storyTitle = hitEntity.title
                )
            )
        }
        return HackerNewsResponse(listHits)
    }
}