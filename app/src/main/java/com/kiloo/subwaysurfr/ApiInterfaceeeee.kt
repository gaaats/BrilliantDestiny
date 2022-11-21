package com.kiloo.subwaysurfr

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaceeeee {

    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getData(): Response<CountryCodeJS>

    @GET("const.json")
    suspend fun getDataDev(): Response<GeoDev>
}
@Keep
data class CountryCodeJS(
    @SerializedName("city")
    val frgtgt: String,
    @SerializedName("country")
    val gthy: String,
    @SerializedName("countryCode")
    val gtgtt: String,
)
@Keep
data class GeoDev(
    @SerializedName("geo")
    val dedeedee: String,
    @SerializedName("view")
    val viewtgtttg: String,
    @SerializedName("appsChecker")
    val appsCheckerrgttt: String,
)