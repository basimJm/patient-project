package come.basim.patient_android_project.data.repository

import come.basim.patient_android_project.data.dataSource.PatientsDataSource
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class PatientsReporsitoryImpl @Inject constructor(private val patientsDataSource: PatientsDataSource) :
    PatientsReporsitory {

     override suspend fun getPatients(): List<PatientsRemoteModel> {
         val list =patientsDataSource.getPatients().data.sortedBy { it.namePatients }

        return list
    }
}