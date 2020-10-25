package com.necomplus.demo.retrofit

import com.necomplus.demo.main.views.TracksActivity
import com.necomplus.demo.models.Artist
import com.necomplus.demo.models.TopArtist
import com.necomplus.demo.models.TopTracks
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitApi {

/* TOP Artistas por Pais, consumiendo
la API KEY suministrada y limitado a
una vista de 10 Artistas en formato JSON.
* */
@GET("/2.0/?method=geo.gettopartists&country=Colombia&api_key=cf2894b9c73a323e24f5c6a9aab1eb85&limit=10&format=json")
fun getTop10Artist() : Observable<TopArtist>


    /* TOP 5 de Canciones, consumiendo
    la API KEY suministrada en formato JSON.
    * */
@GET("/2.0/?method=artist.gettoptracks&api_key=cf2894b9c73a323e24f5c6a9aab1eb85&format=json&limit=5")
fun getTop5TracktByArtist(@Query("mbid") mbid:String) : Observable<TopTracks>

}