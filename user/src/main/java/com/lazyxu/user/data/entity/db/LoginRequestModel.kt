package com.lazyxu.user.data.entity.db

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
        @SerializedName("sign")
        val sign: String,
        @SerializedName("mobile")
        val mobile: String
)
