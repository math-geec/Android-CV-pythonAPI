package com.example.androidcv

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitAPI {

    @Multipart
    @POST("Api.php?apicall=upload")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("desc") desc: RequestBody
    ): Call<UploadResponse>

    companion object {
        operator fun invoke(): RetrofitAPI {
            return Retrofit.Builder()
                .baseUrl("http://10.10.10.118/ImageUploader/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitAPI::class.java)
        }
    }
}

/*********************************/
// // test api connection python model
// class APIKindaStuff {
//
//     interface APIService {
//         @GET("/users/{user}")
//         fun greetUser(@Path("user") user: String): Call<ResponseBody>
//
//         @Headers("Content-type: application/json")
//         @POST("/api/post_some_data")
//         fun getVectors(@Body body: JsonObject): Call<ResponseBody>
//     }
//
//     companion object {
//         private val retrofit = Retrofit.Builder()
//             .baseUrl("http://<local ip>:5000")
//             .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//             .build()
//
//         var service = retrofit.create(APIService::class.java)
//     }
// }
/*********************************/