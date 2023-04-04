package come.basim.patient_android_project.domin.model.patients

import com.google.gson.annotations.SerializedName

data class PatientsResponseModel(
    val condition: String,

    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val namePatients: String,

    val address: String,

    val mobile: String,

    val email: String,

    val birthdate: String,

    val gender: String,

    val photo: String,



    //loacalVar
    var selected :Boolean= false




)
{

    fun getPatientInfo():String{
        return "Lives on $address , Email $email ,  Born on $birthdate"
    }
}


