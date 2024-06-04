package com.aam.applydigitaltechnicalinterview.data.mapperutils

import com.aam.applydigitaltechnicalinterview.data.model.entity.HitsEntity
import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import com.aam.applydigitaltechnicalinterview.data.model.response.Hits

class Mapper {
    fun mapperToHitEntity(response: HackerNewsResponse): List<HitsEntity> {
        val listOfHitsEntities = response.listHits.map {
            HitsEntity(
                author = it.author,
                commentText = it.commentText,
                createdAt = it.createdAt,
                createdAtI = it.createdAtI,
                objectID = it.objectID,
                storyId = it.storyId,
                storyTitle = it.storyTitle,
                storyUrl = it.storyUrl,
                updatedAt = it.createdAt
            )
        }
        return listOfHitsEntities
    }

    fun hackerNewsResponseMapped(hitsList: List<HitsEntity>): HackerNewsResponse {
        val listHits = mutableListOf<Hits>()
        for (hitEntity in hitsList) {
            listHits.add(
                Hits(
                    hitEntity.author,
                    hitEntity.commentText,
                    hitEntity.createdAt,
                    hitEntity.createdAtI,
                    hitEntity.objectID,
                    hitEntity.parentId,
                    hitEntity.storyId,
                    hitEntity.storyTitle,
                    hitEntity.storyUrl,
                    hitEntity.updatedAt
                )
            )
        }
        return HackerNewsResponse(listHits)
    }
}