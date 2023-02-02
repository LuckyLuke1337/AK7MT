
/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.pocketpharma

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
val retrofit = Retrofit.Builder()
//    .baseUrl("https://api.apitalks.store/sukl.cz/")
    .baseUrl("https://36b6cdeb-55c6-47d4-b8f3-f491a3dc7f02.mock.pstmn.io")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

//val gson = GsonBuilder().create()
//val retrofit = Retrofit.Builder()
//    .baseUrl("https://api.apitalks.store/")
//    .addConverterFactory(GsonConverterFactory.create(gson))
//    .build()


interface ApiService {
    @GET("https://api.apitalks.store/sukl.cz/dlp-lecivelatky")
    @Headers("x-api-key: W8vlLUwTlK8NoSrh3voWK51oNRiKAz9r6XVMxkME")
    fun getData(@Query("filter") filter: String): Call<SUKLProperty>
//    fun getData(@QueryMap(encoded = true) filter: Map<String, String>): Call<SUKLProperty>
//    fun getData(@Query("filter")select: String): Call<SUKLProperty>
//        fun getData(@QueryMap filters: Map<String, String>): Call<SUKLProperty>
    //  fun getData(@Query("filter") queryParams: String): Call<SUKLProperty>

    //  fun getData(@Path("filter",encoded = false) filter: String): Call<SUKLProperty>

}


object SULKApi {
    val apiService = retrofit.create(ApiService::class.java)
}