package com.example.whproduct_with_recycle_view_with_ntent.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SmartPhone(
    @DrawableRes val prductPic :Int,
    @StringRes val PhoneName : Int,
    val PhonePrice :String,
    val PhoneVip :Boolean,
    val PhoneQuantity :Int

)
