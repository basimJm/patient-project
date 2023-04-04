package come.basim.patient_android_project.domin.usecase.details

import come.basim.patient_android_project.domin.model.patients.PatientsResponseModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class GetPatientByIdUseCase @Inject constructor(val reporsitory: PatientsReporsitory) {
    suspend operator fun invoke(id: String): PatientsResponseModel {
        return reporsitory.getPatientById(id)

    }
}
