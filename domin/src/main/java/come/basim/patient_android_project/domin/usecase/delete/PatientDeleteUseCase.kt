package come.basim.patient_android_project.domin.usecase.delete

import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponseModel
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject


class PatientDeleteUseCase @Inject constructor(val reporsitory: PatientsReporsitory) {
    suspend operator fun invoke(id: String): PatientDeleteResponseModel {
        return reporsitory.deletePatient(id)

    }
}