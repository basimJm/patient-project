package come.basim.patient_android_project.domin.usecase.add

import come.basim.patient_android_project.domin.model.add.AddPatientRequest
import come.basim.patient_android_project.domin.model.AddPatientResponse
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class AddPatientsUseCase @Inject constructor(private val reporsitory: PatientsReporsitory){

    suspend operator fun invoke(bodyAddingPatientsModel: AddPatientRequest): AddPatientResponse {
        return reporsitory.addPatients(bodyAddingPatientsModel)

    }

}