package pnj.uts.ti.arjuna_dwi_damara_putra.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pnj.uts.ti.arjuna_dwi_damara_putra.data.entity.Alumni

@Dao
interface AlumniDao {
    @Query("SELECT * FROM Alumni")
    fun getAll(): List<Alumni>

    @Query("SELECT * FROM Alumni WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Alumni>

    @Insert
    fun insertAll(vararg alumni: Alumni)

    @Delete
    fun delete(alumni: Alumni)
}