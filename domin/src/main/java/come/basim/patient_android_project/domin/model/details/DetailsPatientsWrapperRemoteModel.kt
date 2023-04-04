package come.basim.patient_android_project.domin.model.details

import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel

data class DetailsPatientsWrapperRemoteModel(
    val status: Int,

    val message: String,

     val data : PatientsRemoteModel

)




