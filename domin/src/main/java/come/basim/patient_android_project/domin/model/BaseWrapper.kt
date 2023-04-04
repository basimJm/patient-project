package come.basim.patient_android_project.domin.model

data class BaseWrapper<T>(
    val status: Int,

    val message: String,

    val data : T

)
