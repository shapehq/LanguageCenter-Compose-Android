package com.novasa.languagecenter.languagecenterliabary_features.data.remote


import com.novasa.languagecenter.languagecenterliabary_features.domain.api_models.AccountInfoModel
import com.novasa.languagecenter.languagecenterliabary_features.domain.api_models.LanguageModel
import com.novasa.languagecenter.languagecenterliabary_features.domain.api_models.PostStringModel
import com.novasa.languagecenter.languagecenterliabary_features.domain.api_models.StringModel
import okhttp3.ResponseBody
import retrofit2.http.*

interface Api {

    @GET("info")
    suspend fun accountInfo(): AccountInfoModel

    @GET("language/da?timestamp=on")
    suspend fun specificLanguage(): LanguageModel

    @GET("languages?timestamp=on")
    suspend fun listLanguages(): List<LanguageModel>

    @GET("strings?platform=android&indexing=off&timestamp=on&html=off")
    suspend fun listStrings(@Query("language") language: String): List<StringModel>

    @POST("string")
    suspend fun postString(@Body requestBody: PostStringModel): ResponseBody

}