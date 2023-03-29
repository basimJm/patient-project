package come.basim.patient_android_project.data.repository

import come.basim.patient_android_project.data.dataSource.PatientsDataSource
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import javax.inject.Inject

class PatientsReporsitory @Inject constructor(private val patientsDataSource: PatientsDataSource) {

     suspend fun getPatients(): List<PatientsRemoteModel> {
         val list =patientsDataSource.getPatients().data.sortedBy { it.namePatients }

        return list
    }
}