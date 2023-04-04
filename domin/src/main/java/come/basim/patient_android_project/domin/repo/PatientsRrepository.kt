package come.basim.patient_android_project.domin.repo

import come.basim.patient_android_project.domin.model.add.AddPatientRequest
import come.basim.patient_android_project.domin.model.AddPatientResponse
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponse
import come.basim.patient_android_project.domin.model.patients.PatientsResponseModel

interface PatientsReporsitory {

    suspend fun getPatients(): List<PatientsResponseModel>

    suspend fun addPatients(bodyAddingPatientsModel: AddPatientRequest): AddPatientResponse

    suspend fun deletePatient(id: String): PatientDeleteResponse

    suspend fun getPatientById(id: String): PatientsResponseModel
}