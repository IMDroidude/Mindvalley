package com.example.mindvalley.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.mindvalley.api.ApiEndPoints
import com.example.mindvalley.api.IRepository
import com.example.mindvalley.api.NetworkHandler
import com.example.mindvalley.common.ApiHandler
import com.example.mindvalley.common.BaseViewModel
import com.example.mindvalley.model.categories.CategoryBO
import com.example.mindvalley.model.categories.CategoryPayload
import com.example.mindvalley.model.WebResponse
import com.example.mindvalley.model.channels.ChannelPayload
import com.example.mindvalley.model.episode.EpisodePayload
import com.example.mindvalley.utils.prefs.Prefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(val apiEndPoints: ApiEndPoints, val prefs: Prefs,
                                                private val networkHandler: NetworkHandler
,val iRepository: IRepository)
    :BaseViewModel(){

    var movieDetails: MutableLiveData<List<CategoryBO>> = MutableLiveData()

    fun fetchCategories(){

        //iRepository.categories()

        when(networkHandler.isConnected){
            true -> {
                val apiHandler = ApiHandler<CategoryPayload>()
                apiHandler.callGenericHit(apiEndPoints.getCategories()){
                    movieDetails.postValue(it.categories)
                }
            }
            false,null -> {

            }
        }



        /*apiEndPoints.getCategories().enqueue(object : Callback<WebResponse<CategoryPayload>>{
            override fun onResponse(
                call: Call<WebResponse<CategoryPayload>>,
                response: Response<WebResponse<CategoryPayload>>
            ) {
                if(response.isSuccessful && response.body() != null){
                    //FIXME
                    val categoryList = response.body()!!.payload.categories
                    movieDetails.postValue(categoryList)
                }
            }

            override fun onFailure(call: Call<WebResponse<CategoryPayload>>, t: Throwable) {
                if(call.isCanceled){

                }
            }
        })*/
    }

    fun fetchEpisode(){
        apiEndPoints.getNewEpisodes().enqueue(object : Callback<WebResponse<EpisodePayload>>{
            override fun onResponse(
                call: Call<WebResponse<EpisodePayload>>,
                response: Response<WebResponse<EpisodePayload>>
            ) {
                if(response.isSuccessful){

                }
            }

            override fun onFailure(call: Call<WebResponse<EpisodePayload>>, t: Throwable) {
                if(call.isCanceled){

                }
            }
        })
    }

    fun fetchChannels(){
        apiEndPoints.getChannels().enqueue(object :Callback<WebResponse<ChannelPayload>>{
            override fun onResponse(
                call: Call<WebResponse<ChannelPayload>>,
                response: Response<WebResponse<ChannelPayload>>
            ) {
                if(response.isSuccessful){

                }
            }

            override fun onFailure(call: Call<WebResponse<ChannelPayload>>, t: Throwable) {
                if(call.isCanceled){

                }
            }
        })
    }
}