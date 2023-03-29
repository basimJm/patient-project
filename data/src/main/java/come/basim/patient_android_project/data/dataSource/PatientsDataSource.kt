package come.basim.patient_android_project.data.dataSource

import come.basim.patient_android_project.domin.model.patients.patientsWrapperRemoteModel
import retrofit2.http.GET

interface PatientsDataSource {
    @GET("patients")
   suspend fun getPatients(): patientsWrapperRemoteModel


}