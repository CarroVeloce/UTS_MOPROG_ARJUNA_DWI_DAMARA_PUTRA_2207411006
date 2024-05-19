package pnj.uts.ti.arjuna_dwi_damara_putra.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pnj.uts.ti.arjuna_dwi_damara_putra.data.dao.AlumniDao
import pnj.uts.ti.arjuna_dwi_damara_putra.data.entity.Alumni

@Database(entities = [Alumni::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alumniDao(): AlumniDao

    companion object{
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}