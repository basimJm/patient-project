package come.basim.patient_android_project.domin.usecase.patients

import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class GetPatientsYseCase @Inject constructor(val reporsitory: PatientsReporsitory) {
    suspend operator fun invoke(): List<PatientsRemoteModel> {
        return reporsitory.getPatients()

    }
}