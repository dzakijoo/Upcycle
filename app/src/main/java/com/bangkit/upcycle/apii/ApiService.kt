package com.bangkit.upcycle.apii

import com.bangkit.upcycle.response.AddToRecycleBagResponse
import com.bangkit.upcycle.response.LoginResponse
import com.bangkit.upcycle.response.RegisterResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiService {
    @POST("register")
    suspend fun register(@Body requestBody: JsonObject): Response<RegisterResponse>

    @POST("login")
    fun login(
        @Body requestBody: JsonObject
    ): Call<LoginResponse>

    @GET("stories")
    fun getRecycleBag(): Call<AddToRecycleBagResponse>

    @POST("api/recycle")
    fun uploadRecycle(
        @Body requestBody: RequestBody
    ): Call<AddToRecycleBagResponse>
    @Multipart
    @POST("api/recycle")
    fun uploadImage(
        @Part file: MultipartBody.Part,
        @Part("recycledProduct") description: RequestBody,
    ): Call<AddToRecycleBagResponse>
}