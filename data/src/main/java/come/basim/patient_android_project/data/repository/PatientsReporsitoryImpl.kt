package come.basim.patient_android_project.data.repository

import come.basim.patient_android_project.data.dataSource.PatientsDataSource
import come.basim.patient_android_project.domin.model.add.AddPatientRequest
import come.basim.patient_android_project.domin.model.AddPatientResponse
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponse
import come.basim.patient_android_project.domin.model.patients.PatientsResponseModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class PatientsReporsitoryImpl @Inject constructor(private val patientsDataSource: PatientsDataSource) :
    PatientsReporsitory {

     override suspend fun getPatients(): List<PatientsResponseModel> {
         val list =patientsDataSource.getPatients().data.sortedBy { it.namePatients }

        return list
    }

    override suspend fun addPatients(bodyAddingPatientsModel: AddPatientRequest): AddPatientResponse {
        return patientsDataSource.addPatients(bodyAddingPatientsModel)
    }

    override suspend fun deletePatient(id: String): PatientDeleteResponse {
        return patientsDataSource.deletePatients(id)
    }

    override suspend fun getPatientById(id: String): PatientsResponseModel {
        return patientsDataSource.getPatientById(id).data
    }

}