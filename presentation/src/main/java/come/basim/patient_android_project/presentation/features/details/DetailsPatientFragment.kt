package come.basim.patient_android_project.presentation.features.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import come.basim.patient_android_project.presentation.databinding.FragmentDetailsPatientBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsPatientFragment:Fragment() {
    
    private lateinit var binding : FragmentDetailsPatientBinding
    private val viewModel :DetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsPatientBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {

        lifecycleScope.launch {

            viewModel.detailsPatientsSatteFlow.collect() { response ->
                if (response != null)
                    Toast.makeText(
                        requireContext(),
                        "patients details successfully",
                        Toast.LENGTH_LONG
                    ).show()

            }


        }

        lifecycleScope.launch {
            viewModel.detailsPatientsLoadingSatteFlow.collect() { show ->
                binding.progressCircular.isVisible = show
            }


        }
        lifecycleScope.launch {
            viewModel.detailsPatientsErorrSatteFlow.collect() { response ->
                if (response != null) {
                    Log.d("TAGOO", response.toString())
                }
            }

        }
    }

}