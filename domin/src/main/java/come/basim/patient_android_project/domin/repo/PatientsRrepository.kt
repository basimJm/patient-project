package come.basim.patient_android_project.domin.repo

import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel

interface PatientsReporsitory {

    suspend fun getPatients(): List<PatientsRemoteModel>
}