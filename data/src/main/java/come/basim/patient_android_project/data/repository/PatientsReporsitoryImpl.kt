package come.basim.patient_android_project.data.repository

import come.basim.patient_android_project.data.dataSource.PatientsDataSource
import come.basim.patient_android_project.domin.model.add.BodyAddingPatientsModel
import come.basim.patient_android_project.domin.model.addPatientsRemoteModel
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponseModel
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class PatientsReporsitoryImpl @Inject constructor(private val patientsDataSource: PatientsDataSource) :
    PatientsReporsitory {

     override suspend fun getPatients(): List<PatientsRemoteModel> {
         val list =patientsDataSource.getPatients().data.sortedBy { it.namePatients }

        return list
    }

    override suspend fun addPatients(bodyAddingPatientsModel: BodyAddingPatientsModel): addPatientsRemoteModel {
        return patientsDataSource.addPatients(bodyAddingPatientsModel)
    }

    override suspend fun deletePatient(id: String): PatientDeleteResponseModel {
        return patientsDataSource.deletePatients(id)
    }

    override suspend fun getPatientById(id: String): PatientsRemoteModel {
        return patientsDataSource.getPatientById(id).data
    }

}