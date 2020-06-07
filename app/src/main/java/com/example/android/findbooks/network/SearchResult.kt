package com.example.android.findbooks.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResult(
    @Json(name = "items")
    val items: List<Book>?,
    @Json(name = "kind")
    val kind: String?,
    @Json(name = "totalItems")
    val totalItems: Int?) : Parcelable

@Parcelize
data class Book(
    @Json(name = "accessInfo")
    val accessInfo: AccessInfo?,
    @Json(name = "etag")
    val etag: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "kind")
    val kind: String?,
    @Json(name = "saleInfo")
    val saleInfo: SaleInfo?,
    @Json(name = "searchInfo")
    val searchInfo: SearchInfo?,
    @Json(name = "selfLink")
    val selfLink: String?,
    @Json(name = "volumeInfo")
    val volumeInfo: VolumeInfo?
) : Parcelable

@Parcelize
data class AccessInfo(
    @Json(name = "accessViewStatus")
    val accessViewStatus: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "embeddable")
    val embeddable: Boolean?,
    @Json(name = "epub")
    val epub: Epub?,
    @Json(name = "pdf")
    val pdf: Pdf?,
    @Json(name = "publicDomain")
    val publicDomain: Boolean?,
    @Json(name = "quoteSharingAllowed")
    val quoteSharingAllowed: Boolean?,
    @Json(name = "textToSpeechPermission")
    val textToSpeechPermission: String?,
    @Json(name = "viewability")
    val viewability: String?,
    @Json(name = "webReaderLink")
    val webReaderLink: String?
) : Parcelable

@Parcelize
data class SaleInfo(
    @Json(name = "buyLink")
    val buyLink: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "isEbook")
    val isEbook: Boolean?,
    @Json(name = "listPrice")
    val listPrice: ListPrice?,
    @Json(name = "offers")
    val offers: List<Offer>?,
    @Json(name = "retailPrice")
    val retailPrice: RetailPriceX?,
    @Json(name = "saleability")
    val saleability: String?
) : Parcelable

@Parcelize
data class SearchInfo(
    @Json(name = "textSnippet")
    val textSnippet: String?
) : Parcelable

@Parcelize
data class VolumeInfo(
    @Json(name = "allowAnonLogging")
    val allowAnonLogging: Boolean?,
    @Json(name = "authors")
    val authors: List<String>?,
    @Json(name = "averageRating")
    val averageRating: Double?,
    @Json(name = "canonicalVolumeLink")
    val canonicalVolumeLink: String?,
    @Json(name = "categories")
    val categories: List<String>?,
    @Json(name = "contentVersion")
    val contentVersion: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "imageLinks")
    val imageLinks: ImageLinks?,
    @Json(name = "industryIdentifiers")
    val industryIdentifiers: List<IndustryIdentifier>?,
    @Json(name = "infoLink")
    val infoLink: String?,
    @Json(name = "language")
    val language: String?,
    @Json(name = "maturityRating")
    val maturityRating: String?,
    @Json(name = "pageCount")
    val pageCount: Int?,
    @Json(name = "panelizationSummary")
    val panelizationSummary: PanelizationSummary?,
    @Json(name = "previewLink")
    val previewLink: String?,
    @Json(name = "printType")
    val printType: String?,
    @Json(name = "publishedDate")
    val publishedDate: String?,
    @Json(name = "publisher")
    val publisher: String?,
    @Json(name = "ratingsCount")
    val ratingsCount: Int?,
    @Json(name = "readingModes")
    val readingModes: ReadingModes?,
    @Json(name = "subtitle")
    val subtitle: String?,
    @Json(name = "title")
    val title: String?
) : Parcelable

@Parcelize
data class Epub(
    @Json(name = "acsTokenLink")
    val acsTokenLink: String?,
    @Json(name = "isAvailable")
    val isAvailable: Boolean?
) : Parcelable

@Parcelize
data class Pdf(
    @Json(name = "acsTokenLink")
    val acsTokenLink: String?,
    @Json(name = "isAvailable")
    val isAvailable: Boolean?
) : Parcelable

@Parcelize
data class ListPrice(
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "currencyCode")
    val currencyCode: String?
) : Parcelable

@Parcelize
data class Offer(
    @Json(name = "finskyOfferType")
    val finskyOfferType: Int?,
    @Json(name = "listPrice")
    val listPrice: ListPriceX?,
    @Json(name = "retailPrice")
    val retailPrice: RetailPrice?
) : Parcelable

@Parcelize
data class RetailPriceX(
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "currencyCode")
    val currencyCode: String?
) : Parcelable

@Parcelize
data class ListPriceX(
    @Json(name = "amountInMicros")
    val amountInMicros: Double?,
    @Json(name = "currencyCode")
    val currencyCode: String?
) : Parcelable

@Parcelize
data class RetailPrice(
    @Json(name = "amountInMicros")
    val amountInMicros: Double?,
    @Json(name = "currencyCode")
    val currencyCode: String?
) : Parcelable

@Parcelize
data class ImageLinks(
    @Json(name = "smallThumbnail")
    val smallThumbnail: String?,
    @Json(name = "thumbnail")
    val thumbnail: String?
) : Parcelable

@Parcelize
data class IndustryIdentifier(
    @Json(name = "identifier")
    val identifier: String?,
    @Json(name = "type")
    val type: String?
) : Parcelable

@Parcelize
data class PanelizationSummary(
    @Json(name = "containsEpubBubbles")
    val containsEpubBubbles: Boolean?,
    @Json(name = "containsImageBubbles")
    val containsImageBubbles: Boolean?
) : Parcelable

@Parcelize
data class ReadingModes(
    @Json(name = "image")
    val image: Boolean?,
    @Json(name = "text")
    val text: Boolean?
) : Parcelable