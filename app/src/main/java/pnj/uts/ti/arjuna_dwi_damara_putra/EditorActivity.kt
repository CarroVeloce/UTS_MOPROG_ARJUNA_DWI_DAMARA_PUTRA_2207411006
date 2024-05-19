package pnj.uts.ti.arjuna_dwi_damara_putra

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pnj.uts.ti.arjuna_dwi_damara_putra.data.entity.Alumni

class EditorActivity : AppCompatActivity() {
    private lateinit var editTextFullName: EditText
    private lateinit var editTextPlaceOfBirth: EditText
    private lateinit var editTextDateOfBirth: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextReligion: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEntryYear: EditText
    private lateinit var editTextGraduationYear: EditText
    private lateinit var editTextOccupation: EditText
    private lateinit var editTextPosition: EditText
    private lateinit var buttonSave: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editor)
        editTextFullName = findViewById(R.id.editTextFullName)
        editTextPlaceOfBirth = findViewById(R.id.editTextPlaceOfBirth)
        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth)
        editTextAddress = findViewById(R.id.editTextAddress)
        editTextReligion = findViewById(R.id.editTextReligion)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextEntryYear = findViewById(R.id.editTextEntryYear)
        editTextGraduationYear = findViewById(R.id.editTextGraduationYear)
        editTextOccupation = findViewById(R.id.editTextOccupation)
        editTextPosition = findViewById(R.id.editTextPosition)
        buttonSave = findViewById(R.id.buttonSave)

        // Load alumni data from intent or database
        val alumniId = intent.getIntExtra("ALUMNI_ID", -1)
        if (alumniId != -1) {
            loadAlumniData(alumniId)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonSave.setOnClickListener {
            saveAlumniData(alumniId)
        }
    }

    private fun loadAlumniData(alumniId: Int) {
        // TODO: Load alumni data from database and set to views
        // This is a placeholder for loading data logic
        val alumni = getAlumniById(alumniId) // Implement this method to fetch data from database
        editTextFullName.setText(alumni.fullname)
        editTextPlaceOfBirth.setText(alumni.tempatlahir)
        editTextDateOfBirth.setText(alumni.tanggallahir)
        editTextAddress.setText(alumni.alamat)
        editTextReligion.setText(alumni.agama)
        editTextPhone.setText(alumni.phone)
        editTextEntryYear.setText(alumni.tahunmasuk)
        editTextGraduationYear.setText(alumni.tahunlulus)
        editTextOccupation.setText(alumni.pekerjaan)
        editTextPosition.setText(alumni.jabatan)
    }

    private fun saveAlumniData(alumniId: Int) {
        // TODO: Save alumni data to database
        // This is a placeholder for saving data logic
        val alumni = Alumni(
            uid = alumniId,
            fullname = editTextFullName.text.toString(),
            tempatlahir = editTextPlaceOfBirth.text.toString(),
            tanggallahir = editTextDateOfBirth.text.toString(),
            alamat = editTextAddress.text.toString(),
            agama = editTextReligion.text.toString(),
            phone = editTextPhone.text.toString(),
            tahunmasuk = editTextEntryYear.text.toString(),
            tahunlulus = editTextGraduationYear.text.toString(),
            pekerjaan = editTextOccupation.text.toString(),
            jabatan = editTextPosition.text.toString()
        )
        updateAlumniInDatabase(alumni) // Implement this method to update data in database
        finish() // Close the activity
    }

    private fun getAlumniById(alumniId: Int): Alumni {
        return Alumni(
            uid = alumniId,
            fullname = "John Doe",
            tempatlahir = "City A",
            tanggallahir = "1990-01-01",
            alamat = "Address 1",
            agama = "Religion A",
            phone = "1234567890",
            tahunmasuk = "2008",
            tahunlulus = "2012",
            pekerjaan = "Engineer",
            jabatan = "Manager"
        )
    }

    private fun updateAlumniInDatabase(alumni: Alumni) {
        // TODO: Implement this method to update alumni data in database
    }
}
