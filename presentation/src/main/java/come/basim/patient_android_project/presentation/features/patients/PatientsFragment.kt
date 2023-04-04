package come.basim.patient_android_project.presentation.features.patients

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import come.basim.patient_android_project.core.BaseFragment
import come.basim.patient_android_project.domin.model.delete.PatientDeleteResponse
import come.basim.patient_android_project.domin.model.patients.PatientsResponseModel
import come.basim.patient_android_project.presentation.R
import come.basim.patient_android_project.presentation.databinding.FragmentPatientsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PatientsFragment : BaseFragment<FragmentPatientsBinding>(R.layout.fragment_patients) {


    private val viewModel: PatientsViewModel by viewModels()

    private lateinit var adapter: PatientsAdapter

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
        initAdapter()
        initeObserver()
        initLesitener()

    }

    private fun initAdapter() {
        adapter = PatientsAdapter(::deletePatient, ::onClickItem)
        binding.recycleView.adapter = adapter
    }

    private fun initLesitener() {

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.addPatientsFragment)
        }
        binding.swipRefresh.setOnRefreshListener {
            viewModel.getPatients()
            lifecycleScope.launch {
                delay(3000)
                binding.swipRefresh.isRefreshing = false
            }
        }
    }

    private fun initeObserver() {
        lifecycleScope.launch {

            viewModel.patientsSatteFlow.collect(::onSuccessPatient)
            }


        lifecycleScope.launch {

            viewModel.patientsLoadingSatteFlow.collect() { show ->
                binding.progressLoading.isVisible = show
            }
        }


        lifecycleScope.launch {

            viewModel.patientsErorrSatteFlow.collect() { response ->
                if (response != null) {
                    Log.d("TAGOO", response.toString())
                }
            }
        }
        lifecycleScope.launch {
            viewModel.deletePatientsSatteFlow.observe(viewLifecycleOwner,::onPatientDeletedSuccess)
        }


    }
    private fun onPatientDeletedSuccess(response: PatientDeleteResponse?){
        if (response != null){
            Toast.makeText(requireContext(),response.message,Toast.LENGTH_LONG).show()
            viewModel.getPatients()
        }

    }

    private fun onSuccessPatient(response:List<PatientsResponseModel>?){


            if (response?.isNotEmpty() == true) {
                adapter.submitList(response)

            }

    }



    private fun deletePatient(id: String) {
        MaterialAlertDialogBuilder(requireContext()).setMessage("Are you sure delte this patient")
            .setNegativeButton("no") { dialog, _ ->
                dialog.dismiss()

            }.setPositiveButton("yes") { dialog, _ ->
                viewModel.deletePatients(id)
                dialog.dismiss()
            }.show()

    }
    private fun onClickItem(id:String){
        findNavController().navigate(R.id.detailsPatientFragment, bundleOf("id" to id))
    }

}