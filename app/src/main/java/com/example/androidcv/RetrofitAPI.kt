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

// interface that defines how Retrofit talks to the web server using HTTP requests
interface RetrofitAPI {

    @Multipart
    // Retrofit appends the endpoint "generate" to the base URL (defined in the Retrofit builder),
    // and creates a Call object
    @POST("/generate")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("desc") desc: RequestBody
    ): Call<UploadResponse>

    companion object {
        operator fun invoke(): RetrofitAPI {
            return Retrofit.Builder()
                // the base URI for the web service
                .baseUrl("http://localhost:5000")
                // add converter factory to deal with the data gets back from web service
                .addConverterFactory(GsonConverterFactory.create())
                // create the Retrofit object
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