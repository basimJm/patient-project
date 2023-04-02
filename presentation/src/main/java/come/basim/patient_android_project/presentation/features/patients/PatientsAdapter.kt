package come.basim.patient_android_project.presentation.features.patients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import come.basim.patient_android_project.domin.model.patients.PatientsRemoteModel
import come.basim.patient_android_project.presentation.databinding.RowPatientsBinding

class PatientsAdapter(private val onDeletePatient : (id:String)->Unit) :
    ListAdapter<PatientsRemoteModel,PatientsAdapter.patientsViewHolder>(DiffCallBack) {

    var lastSelected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): patientsViewHolder {
        val binding = RowPatientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return patientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: patientsViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model, position)
    }



    inner class patientsViewHolder(private val binding: RowPatientsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PatientsRemoteModel, position: Int) {
            binding.model = model



            binding.cardView.setOnClickListener {
                if (position != lastSelected) {

                    if (lastSelected != -1) {
                        getItem(lastSelected).selected = false
                        notifyItemChanged(lastSelected)
                    }

                        lastSelected = position
                        getItem(position).selected = true
                        notifyItemChanged(position)

                }
            }
            binding.imageDelete.setOnClickListener {
                onDeletePatient(model.id)
            }

        }


    }
    private  object DiffCallBack :DiffUtil.ItemCallback<PatientsRemoteModel>(){

        override fun areItemsTheSame(
            oldItem: PatientsRemoteModel,
            newItem: PatientsRemoteModel
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PatientsRemoteModel,
            newItem: PatientsRemoteModel
        ): Boolean {
            return oldItem== newItem
        }
    }

}