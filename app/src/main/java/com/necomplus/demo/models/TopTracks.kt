package com.necomplus.demo.models

import com.google.gson.annotations.SerializedName

class TopTracks(
    @SerializedName("toptracks")
    var topTracks : Tracks
)
{ inner class Tracks{
        var track : ArrayList<Track>? = null
    }
}