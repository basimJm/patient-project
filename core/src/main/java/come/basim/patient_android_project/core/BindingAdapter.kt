package come.basim.patient_android_project.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String) {
   load(url)
}