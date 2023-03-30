package come.basim.patient_android_project.presentation.features.patients

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import come.basim.patient_android_project.presentation.databinding.FragmentPatientsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PatientsFragment : Fragment() {

    private lateinit var binding: FragmentPatientsBinding
    private val viewModel: PatientsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPatientsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {

            viewModel.patientsSatteFlow.collect{ response ->
                if (response.isNotEmpty()) {
                    binding.recycleView.adapter = PatientsAdapter(response)

                }
            }
        }

        lifecycleScope.launch {

            viewModel.patientsLoadingSatteFlow.collect() { show ->
                binding.progressLoading.isVisible = show
            }
        }


        lifecycleScope.launch {

            viewModel.patientsErorrSatteFlow.collect() { response ->
                if (response != null)
                    Log.d("TAGOO", response.toString())
            }
        }
    }
}