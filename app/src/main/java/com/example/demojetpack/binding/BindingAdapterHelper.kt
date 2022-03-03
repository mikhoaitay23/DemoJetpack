package com.example.demojetpack.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.demojetpack.R
import com.example.demojetpack.data.model.UnplashPhoto

@BindingAdapter("android:setImage")
fun setImage(imageView: ImageView, photo: UnplashPhoto?) {
    if (photo == null)
        imageView.setImageResource(R.drawable.ic_launcher_background)
    else
        Glide.with(imageView.context).load(photo.urls.regular)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
}