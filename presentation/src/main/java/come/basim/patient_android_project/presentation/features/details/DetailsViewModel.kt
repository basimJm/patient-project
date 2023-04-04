package come.basim.patient_android_project.presentation.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.domin.usecase.details.GetPatientByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getPatientByIdUseCase: GetPatientByIdUseCase,
    state: SavedStateHandle
) : ViewModel() {

    private val _detailsPatientsSatteFlow: MutableStateFlow<PatientsRemoteModel?> =
        MutableStateFlow(null)
    val detailsPatientsSatteFlow = _detailsPatientsSatteFlow.asStateFlow()

    //Loading
    private val _detailsPatientsLoadingSatteFlow: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val detailsPatientsLoadingSatteFlow = _detailsPatientsLoadingSatteFlow.asStateFlow()

    //Erorr
    private val _detailsPatientsErorrSatteFlow: MutableStateFlow<Exception?> =
        MutableStateFlow(null)
    val detailsPatientsErorrSatteFlow = _detailsPatientsErorrSatteFlow.asStateFlow()


    private val savedStateHundle = state

    init {
        details()
    }

    fun details() {

        val id = savedStateHundle.get<String>("id") ?: "-1"

        viewModelScope.launch {
            _detailsPatientsLoadingSatteFlow.emit(true)
            try {
                _detailsPatientsSatteFlow.emit(getPatientByIdUseCase(id))
            } catch (e: Exception) {

                _detailsPatientsErorrSatteFlow.emit(e)

            }
            _detailsPatientsLoadingSatteFlow.emit(false)
        }


    }

}