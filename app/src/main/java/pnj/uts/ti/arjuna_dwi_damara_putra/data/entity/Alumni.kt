package pnj.uts.ti.arjuna_dwi_damara_putra.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alumni(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "full_name") var fullname: String?,
    @ColumnInfo(name = "tempat_lahir") var tempatlahir: String?,
    @ColumnInfo(name = "tanggal_lahir") var tanggallahir: String?,
    @ColumnInfo(name = "alamat") var alamat: String?,
    @ColumnInfo(name = "agama") var agama: String?,
    @ColumnInfo(name = "phone") var phone: String?,
    @ColumnInfo(name = "tahun_masuk") var tahunmasuk: String?,
    @ColumnInfo(name = "tahun_lulus") var tahunlulus: String?,
    @ColumnInfo(name = "pekerjaan") var pekerjaan: String?,
    @ColumnInfo(name = "jabatan") var jabatan: String?,
)