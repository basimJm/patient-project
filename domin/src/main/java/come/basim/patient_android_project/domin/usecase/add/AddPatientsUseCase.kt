package come.basim.patient_android_project.domin.usecase.add

import come.basim.patient_android_project.domin.model.add.BodyAddingPatientsModel
import come.basim.patient_android_project.domin.model.addPatientsRemoteModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import javax.inject.Inject

class AddPatientsUseCase @Inject constructor(private val reporsitory: PatientsReporsitory){

    suspend operator fun invoke(bodyAddingPatientsModel: BodyAddingPatientsModel): addPatientsRemoteModel {
        return reporsitory.addPatients(bodyAddingPatientsModel)

    }

}