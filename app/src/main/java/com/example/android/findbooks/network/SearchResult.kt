package com.example.android.findbooks.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResult (
    @Json(name = "items") val items: List<ResultItem>)

@JsonClass(generateAdapter = true)
data class ResultItem (
    @Json(name = "id") val id: String,
    @Json(name = "volumeInfo") val volumeInfo : VolumeInfo)

@JsonClass(generateAdapter = true)
data class VolumeInfo (
    @Json(name = "title") val title: String,
    @Json(name = "publisher") val publisher: String,
    @Json(name = "publishedDate") val publishedDate: String,
    @Json(name = "description") val description: String,
    @Json(name = "pageCount") val pageCount: Int,
    @Json(name = "averageRating") val averageRating: Int,
    @Json(name = "ratingsCount") val ratingsCount: Int,
    @Json(name = "language") val language: String,
    @Json(name = "infoLink") val infoLink: String,
    @Json(name = "authors") val authors: Array<Author>,
    @Json(name = "imageLinks") val imageLinks: List<ImageLink>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VolumeInfo

        if (title != other.title) return false
        if (publisher != other.publisher) return false
        if (publishedDate != other.publishedDate) return false
        if (description != other.description) return false
        if (pageCount != other.pageCount) return false
        if (averageRating != other.averageRating) return false
        if (ratingsCount != other.ratingsCount) return false
        if (language != other.language) return false
        if (infoLink != other.infoLink) return false
        if (!authors.contentEquals(other.authors)) return false
        if (imageLinks != other.imageLinks) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publisher.hashCode()
        result = 31 * result + publishedDate.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + pageCount
        result = 31 * result + averageRating
        result = 31 * result + ratingsCount
        result = 31 * result + language.hashCode()
        result = 31 * result + infoLink.hashCode()
        result = 31 * result + authors.contentHashCode()
        result = 31 * result + imageLinks.hashCode()
        return result
    }
}

data class Author (val author: String)

@JsonClass(generateAdapter = true)
data class ImageLink (@Json(name = "thumbnail") val imageSrc:String)