package com.example.whproduct_with_recycle_view_with_ntent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.whproduct_with_recycle_view_with_ntent.conistant.SmartPhoneWebsite
import com.example.whproduct_with_recycle_view_with_ntent.conistant.productInfo
import com.example.whproduct_with_recycle_view_with_ntent.databinding.ActivitySmartPhoneBinding

class SmartPhoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySmartPhoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySmartPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.phoneNameSmartphoneActivity.text = intent.extras?.getString(productInfo.PHONE_NAME)
        println(intent.extras?.getString(productInfo.PHONE_NAME))

        binding.phoneImageSmartPhoneActivity.setImageResource(intent.extras?.getInt(productInfo.PHONE_IMAGE)!!)

        binding.phonePriceSmartPhoneActivity.text =
            intent.extras?.getString(productInfo.PHONE_PRICE)

        binding.goToPhoneWebsite.setOnClickListener {
            val url: Uri = Uri.parse(getUri(intent.extras?.getString(productInfo.PHONE_NAME)))
            val intent = Intent(Intent.ACTION_VIEW, url)
            startActivity(intent)
        }

    }

    private fun getUri(phoneName: String?): String {
        return when (phoneName) {
            getString(R.string.Iphone_12_64GB) -> SmartPhoneWebsite.Iphone_12_64GB
            getString(R.string.Samsung_Galaxy_S21_Ultra) -> SmartPhoneWebsite.Samsung_Galaxy_S21_Ultra
            getString(R.string.Xiaomi_11T_Pro) -> SmartPhoneWebsite.Xiaomi_11T_Pro
            getString(R.string.Huawei_Y6p) -> SmartPhoneWebsite.Huawei_Y6p
            getString(R.string.Samsung_Galaxy_Z_Flip3) -> SmartPhoneWebsite.Samsung_Galaxy_Z_Flip3
            getString(R.string.Iphone_13) -> SmartPhoneWebsite.Iphone_13
            else -> "https://www.google.com/"
        }
    }

}