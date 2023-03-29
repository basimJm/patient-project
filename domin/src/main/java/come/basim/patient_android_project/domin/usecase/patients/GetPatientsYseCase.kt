package come.basim.patient_android_project.domin.usecase.patients

import come.basim.patient_android_project.data.repository.PatientsReporsitory
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import javax.inject.Inject

class GetPatientsYseCase @Inject constructor(val reporsitory: PatientsReporsitory) {
    suspend fun invoke() : List<PatientsRemoteModel>{
        return reporsitory.getPatients()

    }
}