package come.basim.patient_android_project.data.dataSource

import come.basim.patient_android_project.domin.model.BaseWrapper
import come.basim.patient_android_project.domin.model.add.AddPatientRequest
import come.basim.patient_android_project.domin.model.AddPatientResponse
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponse
import come.basim.patient_android_project.domin.model.patients.PatientsResponseModel
import retrofit2.http.*

interface PatientsDataSource {
    @GET("patients")
    suspend fun getPatients(): BaseWrapper<List<PatientsResponseModel>>


    @POST("patients")
    suspend fun addPatients(@Body addPatientRequest: AddPatientRequest): AddPatientResponse

    @DELETE("patients/{id}")
    suspend fun deletePatients(@Path("id") id: String): PatientDeleteResponse

    @GET("patients/{id}")
    suspend fun getPatientById(@Path("id") id: String): BaseWrapper<PatientsResponseModel>
}