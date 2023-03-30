package come.basim.patient_android_project.presentation.features.patients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.presentation.databinding.RowPatientsBinding

class PatientsAdapter(private val patients: List<PatientsRemoteModel>) :
    RecyclerView.Adapter<PatientsAdapter.patientsViewHolder>() {

    var lastSelected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): patientsViewHolder {
        val binding = RowPatientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return patientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: patientsViewHolder, position: Int) {
        val model = patients[position]
        holder.bind(model, position)
    }

    override fun getItemCount(): Int {
        return patients.size
    }

    inner class patientsViewHolder(private val binding: RowPatientsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PatientsRemoteModel, position: Int) {
            binding.model = model



            binding.cardView.setOnClickListener {
                if (position != lastSelected) {

                    if (lastSelected != -1) {
                        patients[lastSelected].selected = false
                        notifyItemChanged(lastSelected)
                    }

                        lastSelected = position
                        patients[position].selected = true
                        notifyItemChanged(position)

                }
            }

        }
    }
}