package com.necomplus.demo.models

import com.google.gson.annotations.SerializedName

class TopArtist (
    @SerializedName("topartists")
    var topArtists: ArtistDetails
){
    inner class ArtistDetails{
        var artist : ArrayList<Artist>? = null
    }
}