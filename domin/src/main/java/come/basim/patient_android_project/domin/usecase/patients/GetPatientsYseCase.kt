package come.basim.patient_android_project.domin.usecase.patients

import come.basim.patient_android_project.domin.model.patients.PatientsResponseModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class GetPatientsYseCase @Inject constructor(val reporsitory: PatientsReporsitory) {
    suspend operator fun invoke(): List<PatientsResponseModel> {
        return reporsitory.getPatients()

    }
}