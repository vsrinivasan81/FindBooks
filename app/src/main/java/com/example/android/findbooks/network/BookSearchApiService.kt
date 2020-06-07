package com.example.android.findbooks.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BookSearchApiService {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") searchText:String,
        @Query("max_results") maxCount:String,
        @Query("maturity_rating") contentMaturity:String):
            Response<SearchResult>
}

object BookSearch {
    val retrofitService : BookSearchApiService
            by lazy{ retrofit.create(BookSearchApiService::class.java) }
}