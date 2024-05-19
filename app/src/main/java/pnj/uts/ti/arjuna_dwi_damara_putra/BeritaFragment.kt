package pnj.uts.ti.arjuna_dwi_damara_putra

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class BeritaFragment : Fragment() {

    private val newsList = listOf(
        News("Asobo Technologies Meluncurkan Simulator Penerbangan Terbaru", "Asobo Technologies baru saja meluncurkan simulator penerbangan terbaru mereka, yang menjanjikan pengalaman yang lebih realistis dan mendalam bagi para pengguna.", R.drawable.furina, "Asobo Technologies, pengembang game dan teknologi simulasi terkemuka, baru-baru ini mengumumkan peluncuran simulator penerbangan terbaru mereka. Simulator ini menawarkan grafis yang memukau dan kontrol yang canggih, memberikan pengalaman terbaik bagi pecinta penerbangan."),
        News("CEO Asobo Technologies Menjadi Pembicara Kunci di Konferensi Teknologi", "CEO Asobo Technologies, bersama dengan sejumlah pakar teknologi terkemuka lainnya, diundang sebagai pembicara kunci di konferensi teknologi terbesar tahun ini.", R.drawable.furina, "CEO Asobo Technologies telah diundang sebagai pembicara kunci di konferensi teknologi terbesar tahun ini. Dalam pidatonya, CEO tersebut berbagi wawasan tentang inovasi terbaru dalam bidang teknologi dan masa depan industri game."),
        News("Asobo Technologies Meraih Penghargaan untuk Inovasi dalam Game VR", "Asobo Technologies dianugerahi penghargaan bergengsi untuk inovasi dalam pengembangan game realitas virtual (VR). Penghargaan tersebut mengakui dedikasi perusahaan dalam menghadirkan pengalaman gaming yang luar biasa bagi pengguna VR di seluruh dunia.", R.drawable.furina, "Asobo Technologies telah meraih penghargaan prestisius untuk inovasi dalam pengembangan game realitas virtual (VR). Penghargaan ini menegaskan posisi Asobo sebagai pemimpin dalam pengembangan teknologi VR dan pengalaman gaming yang mendalam."),
        News("Asobo Technologies Membuka Pusat Penelitian Baru untuk Kecerdasan Buatan", "Asobo Technologies mengumumkan pembukaan pusat penelitian baru yang akan fokus pada pengembangan kecerdasan buatan (AI) untuk aplikasi game dan simulasi.", R.drawable.furina, "Asobo Technologies telah membuka pusat penelitian baru yang akan mengeksplorasi pengembangan kecerdasan buatan (AI) untuk aplikasi game dan simulasi. Langkah ini menunjukkan komitmen Asobo dalam menghadirkan teknologi terdepan bagi para pengguna game di seluruh dunia."),
        News("Asobo Technologies Menjadi Partner Teknologi untuk Proyek Penerbangan Terbaru", "Asobo Technologies dipilih sebagai mitra teknologi utama untuk proyek penerbangan terbaru yang bertujuan untuk mengembangkan pesawat terbang ramah lingkungan dengan teknologi canggih.", R.drawable.furina, "Asobo Technologies telah dipilih sebagai mitra teknologi utama untuk proyek penerbangan terbaru yang bertujuan untuk mengembangkan pesawat terbang ramah lingkungan. Kemitraan ini menunjukkan kepercayaan industri penerbangan terhadap kemampuan Asobo dalam mengembangkan teknologi penerbangan yang inovatif."),
        News("Asobo Technologies Meluncurkan Platform Pembelajaran Online untuk Pengembang Game", "Asobo Technologies mengumumkan peluncuran platform pembelajaran online baru yang dirancang khusus untuk pengembang game, yang akan menyediakan sumber daya dan keterampilan yang diperlukan untuk kesuksesan dalam industri game.", R.drawable.furina, "Asobo Technologies baru saja meluncurkan platform pembelajaran online baru yang bertujuan untuk mendukung pengembang game. Platform ini akan menyediakan sumber daya, tutorial, dan keterampilan yang diperlukan untuk sukses dalam industri game yang kompetitif."),
        News("Asobo Technologies Mengumumkan Rencana Ekspansi Global", "Asobo Technologies mengumumkan rencana ekspansi global yang akan melibatkan pembukaan kantor baru di berbagai negara dan peningkatan layanan untuk memenuhi kebutuhan pasar yang berkembang pesat.", R.drawable.furina, "Asobo Technologies telah mengumumkan rencana ekspansi global yang ambisius. Rencana ini mencakup pembukaan kantor baru di berbagai negara dan peningkatan layanan untuk memenuhi permintaan pasar yang terus berkembang. Langkah ini menegaskan komitmen Asobo dalam mendukung pengguna mereka di seluruh dunia."),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsListView: ListView = view.findViewById(R.id.newsListView)
        val adapter = NewsAdapter(requireContext(), newsList)
        newsListView.adapter = adapter

        newsListView.setOnItemClickListener { _, _, position, _ ->
            val news = newsList[position]
            val intent = Intent(requireContext(), NewsDetailActivity::class.java).apply {
                putExtra("title", news.title)
                putExtra("summary", news.summary)
                putExtra("content", news.content)
            }
            startActivity(intent)
        }
    }
}

data class News(val title: String, val summary: String, val imageResId: Int, val content: String)

