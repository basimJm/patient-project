package come.basim.patient_android_project.domin.repo

import come.basim.patient_android_project.domin.model.add.BodyAddingPatientsModel
import come.basim.patient_android_project.domin.model.addPatientsRemoteModel
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponseModel
import come.basim.patient_android_project.domin.model.details.DetailsPatientsWrapperRemoteModel
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel

interface PatientsReporsitory {

    suspend fun getPatients(): List<PatientsRemoteModel>

    suspend fun addPatients(bodyAddingPatientsModel: BodyAddingPatientsModel): addPatientsRemoteModel

    suspend fun deletePatient(id: String): PatientDeleteResponseModel

    suspend fun getPatientById(id: String): PatientsRemoteModel
}