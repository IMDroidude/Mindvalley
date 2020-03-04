package com.example.mindvalley.api

import com.example.mindvalley.model.Failure
import com.example.mindvalley.model.WebResponse
import com.example.mindvalley.model.categories.CategoryPayload
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

interface IRepository {
    fun categories() : CategoryPayload

    class Network @Inject constructor(private val networkHandler: NetworkHandler,
    private val apiEndPoints: ApiEndPoints) : IRepository{

        override fun categories(): CategoryPayload {

            //request(apiEndPoints.getCategories(), { it.toMovieDetails() }, CategoryPayload.empty())
            apiEndPoints.getCategories().enqueue(object : Callback<WebResponse<CategoryPayload>>{
                override fun onResponse(
                    call: Call<WebResponse<CategoryPayload>>,
                    response: Response<WebResponse<CategoryPayload>>
                ) {
                    if(response.isSuccessful && response.body() != null){
                        response.body()!!.payload
                    }
                }

                override fun onFailure(call: Call<WebResponse<CategoryPayload>>, t: Throwable) {

                }
            })

            return CategoryPayload(ArrayList());
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }

    }
}