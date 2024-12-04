package com.project.bonggong.model

import com.project.bonggong.api.data.CreateThreadAndRunRequest
import com.project.bonggong.api.data.CreateRunRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface GptApiService {
    // 1. 첫 번째 사용자 입력이 들어 왔을 때 (stream 방식)
    // thread 생성 및 message 추가, run 생성
    @POST("v1/threads/runs")
    fun createThreadAndRunStream(
        @Body request: CreateThreadAndRunRequest
    ): Call<ResponseBody>

    // 2. 첫 번째가 아닌 사용자 입력이 들어 왔을 때 (stream 방식)
    // run 생성 (message 추가)
    @POST("v1/threads/{thread_id}/runs")
    fun createRunStream(
        @Path("thread_id") threadId: String,
        @Body request: CreateRunRequest
    ): Call<ResponseBody>
}