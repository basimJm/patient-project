package come.basim.patient_android_project.presentation.features.patients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponseModel
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import come.basim.patient_android_project.domin.usecase.delete.PatientDeleteUseCase
import come.basim.patient_android_project.domin.usecase.patients.GetPatientsYseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PatientsViewModel @Inject constructor(
    private val getPatientsYseCase: GetPatientsYseCase,
    private val deleteUseCase: PatientDeleteUseCase
) :
    ViewModel() {

    val _patientsSatteFlow: MutableStateFlow<List<PatientsRemoteModel>> =
        MutableStateFlow(emptyList())
    val patientsSatteFlow: StateFlow<List<PatientsRemoteModel>> = _patientsSatteFlow


    //delete
    val _deletePatientsSatteFlow: MutableStateFlow<PatientDeleteResponseModel?> =
        MutableStateFlow(null)
    val deletePatientsSatteFlow = _deletePatientsSatteFlow.asStateFlow()


    //Loading
    val _patientsLoadingSatteFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val patientsLoadingSatteFlow = _patientsLoadingSatteFlow.asStateFlow()

    //Erorr
    val _patientsErorrSatteFlow: MutableStateFlow<Exception?> = MutableStateFlow(null)
    val patientsErorrSatteFlow = _patientsErorrSatteFlow.asStateFlow()

    init {
        getPatients()
    }

    fun getPatients() {

        viewModelScope.launch {
            _patientsLoadingSatteFlow.emit(true)
            try {
                _patientsSatteFlow.emit(getPatientsYseCase())
            } catch (e: Exception) {

                _patientsErorrSatteFlow.emit(e)

            }
            _patientsLoadingSatteFlow.emit(false)


        }
    }

    fun deletePatients(id: String) {

        viewModelScope.launch {
            _patientsLoadingSatteFlow.emit(true)
            try {
                _deletePatientsSatteFlow.emit(deleteUseCase(id))
            } catch (e: Exception) {

                _patientsErorrSatteFlow.emit(e)

            }
            _patientsLoadingSatteFlow.emit(false)


        }
    }
}

