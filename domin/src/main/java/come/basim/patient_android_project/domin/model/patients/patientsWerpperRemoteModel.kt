package come.basim.patient_android_project.domin.model.patients

data class patientsWrapperRemoteModel (
    val status :Int ,
    val message :String,
    val data :List<PatientsRemoteModel>

    )
