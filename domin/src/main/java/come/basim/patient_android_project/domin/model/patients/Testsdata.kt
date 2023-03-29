package come.basim.patient_android_project.domin.model.patients

import com.google.gson.annotations.SerializedName

data class Testsdata (
     @SerializedName("_id")
    val id:String,

    val type:String,

    val reading:String,

    val date:String
        )


