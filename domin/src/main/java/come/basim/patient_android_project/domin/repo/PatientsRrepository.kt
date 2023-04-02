package come.basim.patient_android_project.domin.repo

import come.basim.patient_android_project.domin.model.add.BodyAddingPatientsModel
import come.basim.patient_android_project.domin.model.addPatientsRemoteModel
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel

interface PatientsReporsitory {

    suspend fun getPatients(): List<PatientsRemoteModel>

    suspend fun addPatients(bodyAddingPatientsModel: BodyAddingPatientsModel): addPatientsRemoteModel
}