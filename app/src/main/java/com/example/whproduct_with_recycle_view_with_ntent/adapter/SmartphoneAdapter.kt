package com.example.whproduct_with_recycle_view_with_ntent.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whproduct_with_recycle_view_with_ntent.R
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.whproduct_with_recycle_view_with_ntent.SmartPhoneActivity
import com.example.whproduct_with_recycle_view_with_ntent.conistant.productInfo
import com.example.whproduct_with_recycle_view_with_ntent.data.DataSourse


class SmartphoneAdapter (private val context : Context?) :
 RecyclerView.Adapter<SmartphoneAdapter.SmartPhoneViewHolder>() {

   private val dataSource= DataSourse.smartPhone

 class SmartPhoneViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
  val productImage: ImageView? = view?.findViewById(R.id.product_image)
  val productName: TextView? = view?.findViewById(R.id.product_name)
  val productPrice: TextView? = view?.findViewById(R.id.product_price)
  val productIsVip: ImageView? = view?.findViewById(R.id.isVip_icon)
  val addToCart: ImageButton? = view?.findViewById(R.id.add_to_cart)
 }

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmartPhoneViewHolder {
        return SmartPhoneViewHolder(LayoutInflater.from(parent.context)
         .inflate(R.layout.vertical_list_item,parent,false)
        )
 }

 @SuppressLint("ResourceAsColor")
 override fun onBindViewHolder(holder: SmartPhoneViewHolder, position: Int) {
     val item= dataSource[position]
     holder.productImage?.setImageResource(item.prductPic)
     holder.productName?.text= context?.getString(item.PhoneName)
     holder.productPrice?.text= item.PhonePrice

  if (item.PhoneVip){
   holder.productIsVip?.visibility= View.VISIBLE
  }

  holder.addToCart?.setOnClickListener{
   if (item.PhoneQuantity > 0 ){
    Toast.makeText(context,"add to cart" ,Toast.LENGTH_SHORT).show()
   }else{
    Toast.makeText(context,"out of stock" ,Toast.LENGTH_SHORT).show()

   }
  }
  holder.productImage?.setOnClickListener {
   val intent = Intent (context,SmartPhoneActivity::class.java)
   intent.putExtra(productInfo.PHONE_NAME,context?.getString(item.PhoneName))
   intent.putExtra(productInfo.PHONE_IMAGE,item.prductPic)
           intent.putExtra(productInfo.PHONE_PRICE, item.PhonePrice)
           it?.context?.startActivity(intent)

  }

 }

 override fun getItemCount(): Int = dataSource.size
}
