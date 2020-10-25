package com.necomplus.demo.models


import java.io.Serializable


data class Artist (
    var name : String,
    var listeners : String,
    var url : String,
    var mbid : String
):Serializable


