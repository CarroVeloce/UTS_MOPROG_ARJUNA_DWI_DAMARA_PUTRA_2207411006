package pnj.uts.ti.arjuna_dwi_damara_putra

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.google.android.material.floatingactionbutton.FloatingActionButton
import pnj.uts.ti.arjuna_dwi_damara_putra.adapter.AlumniAdapter
import pnj.uts.ti.arjuna_dwi_damara_putra.data.AppDatabase
import pnj.uts.ti.arjuna_dwi_damara_putra.data.entity.Alumni

class DataAlumni : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<Alumni>()
    private lateinit var adapter: AlumniAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_alumni)
        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.fab_add)

        database = AppDatabase.getInstance(applicationContext)
        adapter = AlumniAdapter(list)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))

        fab.setOnClickListener{
            startActivity(Intent(this,EditorActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        getdata()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getdata(){
        list.clear()
        list.addAll(database.alumniDao().getAll())
        adapter.notifyDataSetChanged()
    }
}
