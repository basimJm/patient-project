package come.basim.patient_android_project.presentation.features.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.basim.patient_android_project.domin.model.add.AddPatientRequest
import come.basim.patient_android_project.domin.model.AddPatientResponse
import come.basim.patient_android_project.domin.usecase.add.AddPatientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPatientsViewModel @Inject constructor(
    private val addPatientsUseCase: AddPatientsUseCase
) : ViewModel() {

    val _addPatientsSatteFlow: MutableStateFlow<AddPatientResponse?> =
        MutableStateFlow(null)
    val addPatientsSatteFlow = _addPatientsSatteFlow.asStateFlow()

    //Loading
    val _addPatientsLoadingSatteFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val addPatientsLoadingSatteFlow = _addPatientsLoadingSatteFlow.asStateFlow()

    //Erorr
    val _addPatientsErorrSatteFlow: MutableStateFlow<Exception?> = MutableStateFlow(null)
    val addPatientsErorrSatteFlow = _addPatientsErorrSatteFlow.asStateFlow()

fun addPatient(bodyAddingPatientsModel: AddPatientRequest){

    viewModelScope.launch {
        _addPatientsLoadingSatteFlow.emit(true)
        try {
            _addPatientsSatteFlow.emit(addPatientsUseCase(bodyAddingPatientsModel))
        } catch (e: Exception) {

            _addPatientsErorrSatteFlow.emit(e)

        }
        _addPatientsLoadingSatteFlow.emit(false)
}

}
}