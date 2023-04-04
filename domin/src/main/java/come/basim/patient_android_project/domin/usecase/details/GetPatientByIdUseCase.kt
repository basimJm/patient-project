package come.basim.patient_android_project.domin.usecase.details

import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class GetPatientByIdUseCase @Inject constructor(val reporsitory: PatientsReporsitory) {
    suspend operator fun invoke(id: String): PatientsRemoteModel {
        return reporsitory.getPatientById(id)

    }
}
