package come.basim.patient_android_project.data.dataSource

import come.basim.patient_android_project.domin.model.add.BodyAddingPatientsModel
import come.basim.patient_android_project.domin.model.addPatientsRemoteModel
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponseModel
import come.basim.patient_android_project.domin.model.details.DetailsPatientsWrapperRemoteModel
import come.basim.patient_android_project.domin.model.patients.patientsWrapperRemoteModel
import retrofit2.http.*

interface PatientsDataSource {
    @GET("patients")
   suspend fun getPatients(): patientsWrapperRemoteModel


    @POST("patients")
    suspend fun addPatients( @Body bodyAddingPatientsModel : BodyAddingPatientsModel): addPatientsRemoteModel

    @DELETE("patients/{id}")
    suspend fun deletePatients(@Path("id")  id :String): PatientDeleteResponseModel

    @GET("patients/{id}")
    suspend fun getPatientById(@Path("id")  id :String): DetailsPatientsWrapperRemoteModel
}