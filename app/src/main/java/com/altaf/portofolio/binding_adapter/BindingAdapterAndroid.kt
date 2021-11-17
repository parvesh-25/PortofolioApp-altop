package com.altaf.portofolio.binding_adapter



import android.widget.ImageView
import android.widget.TextView
import coil.load
import androidx.databinding.BindingAdapter
import com.altaf.portofolio.portofolio_modul.Portofolio

@BindingAdapter("androidTitle")
fun TextView.setTitleAndroid(data: Portofolio?){
    data?.let {
        text = data.title
    }
}

@BindingAdapter("androidImage")
fun ImageView.setAndroidImage(data: Portofolio){
    load(data.image){
        crossfade(1000)
    }
}