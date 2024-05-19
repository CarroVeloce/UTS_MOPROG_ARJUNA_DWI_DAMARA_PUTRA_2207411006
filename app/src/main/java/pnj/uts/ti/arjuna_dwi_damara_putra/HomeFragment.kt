package pnj.uts.ti.arjuna_dwi_damara_putra

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Set up button click listener
        val buttonToDataAlumni = view.findViewById<Button>(R.id.buttonToDataAlumni)
        buttonToDataAlumni.setOnClickListener {
            val intent = Intent(activity, DataAlumni::class.java)
            startActivity(intent)
        }

        return view
    }
}
