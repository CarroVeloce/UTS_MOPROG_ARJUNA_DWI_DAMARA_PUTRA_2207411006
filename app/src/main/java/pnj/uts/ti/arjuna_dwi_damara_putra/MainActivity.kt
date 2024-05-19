package pnj.uts.ti.arjuna_dwi_damara_putra;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val HARDCODED_EMAIL = "arjuna"
        private const val HARDCODED_PASSWORD = "furina"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun signIn(view: View) {
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (HARDCODED_EMAIL == email && HARDCODED_PASSWORD == password) {

            val sharedPref = getSharedPreferences("arjuna", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("Email", email)
                putString("Nim", "2207411006")
                putString("Nama", "Arjuna Dwi Damara Putra")
                putString("Kelas", "TI-1A")
                apply()
            }
            // Navigate to HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }
}
