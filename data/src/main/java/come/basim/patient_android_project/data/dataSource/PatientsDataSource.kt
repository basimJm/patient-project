package come.basim.patient_android_project.data.dataSource

import come.basim.patient_android_project.domin.model.add.BodyAddingPatientsModel
import come.basim.patient_android_project.domin.model.addPatientsRemoteModel
import come.basim.patient_android_project.domin.model.patients.patientsWrapperRemoteModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PatientsDataSource {
    @GET("patients")
   suspend fun getPatients(): patientsWrapperRemoteModel


    @POST("patients")
    suspend fun addPatients( @Body bodyAddingPatientsModel : BodyAddingPatientsModel): addPatientsRemoteModel
}