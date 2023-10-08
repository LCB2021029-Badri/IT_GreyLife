package com.example.credit_risk_eval_badri_v01.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MyBlockchainApi {
    data class HelloWorldResponse(val output: String)
    data class RequestData(val newString: String)
    data class ResponseData(val newString: String)

    @POST("setString")
    fun PostData(
        @Query("kld-from") kldFrom: String,
        @Body requestData: RequestData
    ): Call<ResponseData>

    @GET("getString")
    fun getData(@Query("kld-from") kldFrom: String): Call<HelloWorldResponse>
}