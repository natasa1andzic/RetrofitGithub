package com.natasaandzic.retrofit.model

import com.google.gson.annotations.SerializedName

class Repo(
        @SerializedName("name")
        val name:String,
        @SerializedName("description")
        val description: String,
        @SerializedName("language")
        val language: String
) {

}
