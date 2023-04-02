package come.basim.patient_android_project.presentation.features.add

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import come.basim.patient_android_project.domin.model.add.BodyAddingPatientsModel
import come.basim.patient_android_project.presentation.databinding.FragmentAddPatientsBinding
import come.basim.patient_android_project.presentation.features.patients.PatientsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddPatientsFragment:Fragment() {
    private lateinit var binding: FragmentAddPatientsBinding
    private val viewModel: AddPatientsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPatientsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserve()
        initListener()
    }

    private fun initListener() {
        binding.buttonAdd.setOnClickListener {
            if (infoIsValid()){
                val body =getInfoPatient()

                viewModel.addPatient(
                    body
                )
            }


        }
    }

    private fun getInfoPatient(): BodyAddingPatientsModel {

        return BodyAddingPatientsModel(
            binding.editTextFullName.text.toString(),
            binding.editTextFullEmail.text.toString(),
            binding.editTextFullAddress.text.toString(),
            binding.editTextFullGender.text.toString(),
            binding.editTextFullBirthdate.text.toString(),
            binding.editTextFullMobile.text.toString(),
        )

    }

    private fun infoIsValid(): Boolean {
        var isValid = true


        if (binding.editTextFullName.text?.isEmpty() == true) {
            isValid = false
            binding.textFullName.error = "Name is Empty"
        }else {
            binding.textFullName.error = ""

        }

        if (binding.editTextFullEmail.text?.isEmpty() == true) {
            isValid = false
            binding.textFullEmail.error = "Email is Empty"

        }
        else {
            binding.textFullEmail.error = ""

        }

        if (binding.editTextFullAddress.text?.isEmpty() == true) {
            isValid = false
            binding.textFullAddress.error = "Address is Empty"

        }
        else {
            binding.textFullAddress.error = ""

        }

        if (binding.editTextFullGender.text?.isEmpty() == true) {
            isValid = false
            binding.textFullGender.error = "Gender is Empty"

        }
        else {
            binding.textFullGender.error = ""

        }

        if (binding.editTextFullMobile.text?.isEmpty() == true) {
            isValid = false
            binding.textFullMobile.error = "Mobile is Empty"

        }
        else {
            binding.textFullMobile.error = ""

        }
        return isValid
    }






        private fun initObserve() {

            lifecycleScope.launch {

                viewModel.addPatientsSatteFlow.collect() { response ->
                    if (response != null)
                        Toast.makeText(
                            requireContext(),
                            "patients add successfully",
                            Toast.LENGTH_LONG
                        ).show()

                }


            }

            lifecycleScope.launch {
                viewModel.addPatientsLoadingSatteFlow.collect() { show ->
                    binding.progressCircular.isVisible = show
                }


            }
            lifecycleScope.launch {
                viewModel.addPatientsErorrSatteFlow.collect() { response ->
                    if (response != null) {
                        Log.d("TAGOO", response.toString())
                    }
                }

            }

        }
    }



