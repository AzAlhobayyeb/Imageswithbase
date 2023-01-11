package com.example.images.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://picsum.photos/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ImageApiService {
    @GET("v2/list")
    suspend fun getImages(): NetworkImageContainer
}

object ImageApiNet {

    val retrofitService= retrofit.create(ImageApiService::class.java)
}








/*\  private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        
 */