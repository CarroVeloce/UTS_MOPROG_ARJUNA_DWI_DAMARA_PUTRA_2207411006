package pnj.uts.ti.arjuna_dwi_damara_putra.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pnj.uts.ti.arjuna_dwi_damara_putra.R
import pnj.uts.ti.arjuna_dwi_damara_putra.data.entity.Alumni

class AlumniAdapter(private val alumniList: List<Alumni>) :
    RecyclerView.Adapter<AlumniAdapter.AlumniViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumniViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alumni, parent, false)
        return AlumniViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlumniViewHolder, position: Int) {
        val alumni = alumniList[position]
        holder.bind(alumni)
    }

    override fun getItemCount() = alumniList.size

    class AlumniViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewFullName: TextView = itemView.findViewById(R.id.textViewFullName)
        private val textViewPlaceAndDateOfBirth: TextView = itemView.findViewById(R.id.textViewPlaceAndDateOfBirth)
        private val textViewAddress: TextView = itemView.findViewById(R.id.textViewAddress)
        private val textViewReligion: TextView = itemView.findViewById(R.id.textViewReligion)
        private val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)
        private val textViewEntryAndGraduationYear: TextView = itemView.findViewById(R.id.textViewEntryAndGraduationYear)
        private val textViewOccupationAndPosition: TextView = itemView.findViewById(R.id.textViewOccupationAndPosition)

        fun bind(alumni: Alumni) {
            textViewFullName.text = alumni.fullname
            textViewPlaceAndDateOfBirth.text = "${alumni.tempatlahir}, ${alumni.tanggallahir}"
            textViewAddress.text = alumni.alamat
            textViewReligion.text = alumni.agama
            textViewPhone.text = alumni.phone
            textViewEntryAndGraduationYear.text = "Entry: ${alumni.tahunmasuk}, Graduation: ${alumni.tahunlulus}"
            textViewOccupationAndPosition.text = "${alumni.pekerjaan} - ${alumni.jabatan}"
        }
    }
}
