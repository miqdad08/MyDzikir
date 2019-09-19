package id.com.miqdad.mydzikir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private DzikirAdapter dzikirAdapter;
    RecyclerView rvMain;
    ArrayList<ModelDzikir> arrayList;
    int count = 0;
    String idDzikir;


    private String[] nopagi = {
            "Dzikir yang dibaca di Waktu Pagi",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "",
            ""};

    private String[] idpagi = {
            "Taawuds",
            "Ayatkursi",
            "AlIklash",
            "AlFalaq",
            "AnNas",
            "doa5",
            "doa6",
            "doa7",
            "doa8",
            "doa9",
            "doa10",
            "doa11",
            "doa12",
            "doa13",
            "doa14",
            "Doa15",
            "doa16",
            "doa17",
            "doa18",
            "doa19",
            "doa20"};

    private String[] judulPagi = {
            "أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ",
            "اللَّهُ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ، لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ، لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ، مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلاَّ بِإِذْنِهِ، يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ، وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلاَّ بِمَا شَاءَ، وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ، وَلَا يَئُودُهُ حِفْظُهُمَا، وَهُوَ الْعَلِيُّ الْعَظِيم ",
            "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\n" + "قُلْ هُوَ اللَّهُ أَحَدٌ اللَّهُ الصَّمَدُ لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ",
            "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\n" + "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ مِن شَرِّ مَا خَلَقَ وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ  وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ",
            "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\n" + "قُلْ أَعُوذُ بِرَبِّ النَّاسِ مَلِكِ النَّاسِ إِلَهِ النَّاسِ مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ مِنَ الْجِنَّةِ وَ النَّاسِ",
            "أَصْبَحْنَا وَأَصْبَحَ الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ، لاَ إِلَـهَ إِلاَّ اللهُ وَحْدَهُ لاَ شَرِيْكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيْرُ. رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا الْيَوْمِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِيْ هَذَا الْيَوْمِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ وَسُوْءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِي النَّارِ وَعَذَابٍ فِي الْقَبْرََِ",
            "اَللَّهُمَّ بِكَ أَصْبَحْنَا، وَبِكَ أَمْسَيْنَا، وَبِكَ نَحْيَا، وَبِكَ نَمُوْتُ وَإِلَيْكَ النُّشُوْرُ",
            "أَصْبَحْنَا عَلَى فِطْرَةِ اْلإِسْلاَمِ وَعَلَى كَلِمَةِ اْلإِخْلاَصِ، وَعَلَى دِيْنِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ، وَعَلَى مِلَّةِ أَبِيْنَا إِبْرَاهِيْمَ، حَنِيْفًا مُسْلِمًا وَمَا كَانَ مِنَ الْمُشْرِكِيْنَ",
            "اَللَّهُمَّ أَنْتَ رَبِّيْ لاَ إِلَـهَ إِلاَّ أَنْتَ، خَلَقْتَنِيْ وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوْذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوْءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوْءُ بِذَنْبِيْ فَاغْفِرْ لِيْ فَإِنَّهُ لاَ يَغْفِرُ الذُّنُوْبَ إِلاَّ أَنْتَ",
            "اَللَّهُمَّ إِنِّيْ أَصْبَحْتُ أُشْهِدُكَ وَأُشْهِدُ حَمَلَةَ عَرْشِكَ، وَمَلاَئِكَتَكَ وَجَمِيْعَ خَلْقِكَ، أَنَّكَ أَنْتَ اللهُ لاَ إِلَـهَ إِلاَّ أَنْتَ وَحْدَكَ لاَ شَرِيْكَ لَكَ، وَأَنَّ مُحَمَّدًا عَبْدُكَ وَرَسُوْلُكَ",
            "اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ الْعَفْوَ وَالْعَافِيَةَ فِي الدُّنْيَا وَاْلآخِرَةِ، اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ الْعَفْوَ وَالْعَافِيَةَ فِي دِيْنِيْ وَدُنْيَايَ وَأَهْلِيْ وَمَالِيْ اللَّهُمَّ اسْتُرْ عَوْرَاتِى وَآمِنْ رَوْعَاتِى. اَللَّهُمَّ احْفَظْنِيْ مِنْ بَيْنِ يَدَيَّ، وَمِنْ خَلْفِيْ، وَعَنْ يَمِيْنِيْ وَعَنْ شِمَالِيْ، وَمِنْ فَوْقِيْ، وَأَعُوْذُ بِعَظَمَتِكَ أَنْ أُغْتَالَ مِنْ تَحْتِيْ",
            "اَللَّهُمَّ عَالِمَ الْغَيْبِ وَالشَّهَادَةِ فَاطِرَ السَّمَاوَاتِ وَاْلأَرْضِ، رَبَّ كُلِّ شَيْءٍ وَمَلِيْكَهُ، أَشْهَدُ أَنْ لاَ إِلَـهَ إِلاَّ أَنْتَ، أَعُوْذُ بِكَ مِنْ شَرِّ نَفْسِيْ، وَمِنْ شَرِّ الشَّيْطَانِ وَشِرْكِهِ، وَأَنْ أَقْتَرِفَ عَلَى نَفْسِيْ سُوْءًا أَوْ أَجُرُّهُ إِلَى مُسْلِمٍ",
            "بِسْمِ اللَّهِ الَّذِى لاَ يَضُرُّ مَعَ اسْمِهِ شَىْءٌ فِى الأَرْضِ وَلاَ فِى السَّمَاءِ وَهُوَ السَّمِيعُ الْعَلِيمُُ",
            "رَضِيْتُ بِاللهِ رَبًّا، وَبِاْلإِسْلاَمِ دِيْنًا، وَبِمُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ نَبِيًّا"
            , "يَا حَيُّ يَا قَيُّوْمُ بِرَحْمَتِكَ أَسْتَغِيْثُ، وَأَصْلِحْ لِيْ شَأْنِيْ كُلَّهُ وَلاَ تَكِلْنِيْ إِلَى نَفْسِيْ طَرْفَةَ عَيْنٍ أَبَدً",
            "أَصْبَحْنَا عَلَى فِطْرَةِ اْلإِسْلاَمِ وَعَلَى كَلِمَةِ اْلإِخْلاَصِ، وَعَلَى دِيْنِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ، وَعَلَى مِلَّةِ أَبِيْنَا إِبْرَاهِيْمَ، حَنِيْفًا مُسْلِمًا وَمَا كَانَ مِنَ الْمُشْرِكِيْنَ",
            "لاَ إِلَـهَ إِلاَّ اللهُ وَحْدَهُ لاَ شَرِيْكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيْرُ",
            "سُبْحَانَ اللهِ وَبِحَمْدِهِ: عَدَدَ خَلْقِهِ، وَرِضَا نَفْسِهِ، وَزِنَةَ عَرْشِهِ وَمِدَادَ كَلِمَاتِهِ",
            "اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ عِلْمًا نَافِعًا، وَرِزْقًا طَيِّبًا، وَعَمَلاً مُتَقَبَّلاً",
            "سُبْحَانَ اللهِ وَبِحَمْدِهِ",
            "أَسْتَغْفِرُ اللهَ وَأَتُوْبُ إِلَيْهِ"};


    private String[] subJudulPagi = {"“Aku berlindung kepada Allah dari godaan syaitan yang terkutuk.”,",
            "“Allah, tidak ada ilah (yang berhak disembah) melainkan Dia, yang hidup kekal lagi terus menerus mengurus (makhluk-Nya). Dia tidak mengantuk dan tidak tidur. Kepunyaan-Nya apa yang di langit dan di bumi. Tiada yang dapat memberi syafa’at di sisi-Nya tanpa seizin-Nya. Dia mengetahui apa-apa yang di hadapan mereka dan di belakang mereka. Mereka tidak mengetahui apa-apa dari ilmu Allah melainkan apa yang dikehendaki-Nya. Kursi Allah meliputi langit dan bumi. Dia tidak merasa berat memelihara keduanya. Dan Dia Maha Tinggi lagi Maha besar.” (QS. Al Baqarah: 255) (Dibaca 1 x),",
            "“Dengan menyebut nama Allah Yang Maha Pengasih lagi Maha Penyayang. Katakanlah: Dialah Allah, Yang Maha Esa. Allah adalah ilah yang bergantung kepada-Nya segala urusan. Dia tidak beranak dan tiada pula diperanakkan, dan tidak ada seorang pun yang setara dengan Dia.” (QS. Al Ikhlas: 1-4) (Dibaca 3 x),",
            "“Dengan menyebut nama Allah Yang Maha Pengasih lagi Maha Penyayang. Katakanlah: Aku berlindung kepada Rabb yang menguasai Shubuh, dari kejahatan makhluk-Nya, dan dari kejahatan malam apabila telah gelap gulita, dan dari kejahatan-kejahatan wanita tukang sihir yang menghembus pada buhul-buhul, dan dari kejahatan orang yang dengki apabila ia dengki”. (QS. Al Falaq: 1-5) (Dibaca 3 x),",
            "“Dengan menyebut nama Allah Yang Maha Pengasih lagi Maha Penyayang. Katakanlah: Aku berlindung kepada Rabb manusia. Raja manusia. Sembahan manusia, dari kejahatan (bisikan) syaitan yang biasa bersembunyi, yang membisikkan (kejahatan) ke dalam dada manusia, dari jin dan manusia.” (QS. An Naas: 1-6) (Dibaca 3 x),",
            "“Kami telah memasuki waktu sore dan kerajaan hanya milik Allah, segala puji hanya milik Allah. Tidak ada Ilah yang berhak diibadahi dengan benar kecuali Allah Yang Maha Esa, tiada sekutu bagi-Nya. Bagi-Nya kerajaan dan bagi-Nya pujian. Dia-lah Yang Mahakuasa atas segala sesuatu. Wahai Rabb, aku mohon kepada-Mu kebaikan di malam ini dan kebaikan sesudahnya. Aku berlindung kepada-Mu dari kejahatan malam ini dan kejahatan sesudahnya. Wahai Rabb, aku berlindung kepada-Mu dari kemalasan dan kejelekan di hari tua. Wahai Rabb, aku berlindung kepada-Mu dari siksaan di Neraka dan siksaan di kubur.”(Dibaca 1x),",
            "“Ya Allah, dengan rahmat dan pertolongan-Mu kami memasuki waktu sore dan dengan rahmat dan pertolongan-Mu kami memasuki waktu pagi. Dengan rahmat dan kehendak-Mu kami hidup dan dengan rahmat dan kehendak-Mu kami mati. Dan kepada-Mu tempat kembali (bagi semua makhluk).” (Dibaca 1x),",
            "“Di waktu sore kami berada diatas fitrah agama Islam, kalimat ikhlas, agama Nabi kita Muhammad صلي الله عليه وسلم dan agama ayah kami, Ibrahim, yang berdiri di atas jalan yang lurus, muslim dan tidak tergolong orang-orang yang musyrik.” (Dibaca 1x),",
            "“Ya Allah, Engkau adalah Rabbku, tidak ada ilah yang berhak disembah kecuali Engkau, Engkaulah yang menciptakanku. Aku adalah hamba-Mu. Aku akan setia pada perjanjianku pada-Mu (yaitu aku akan mentauhidkan-Mu) semampuku dan aku yakin akan janji-Mu (berupa surga untukku). Aku berlindung kepada-Mu dari kejelekan yang kuperbuat. Aku mengakui nikmat-Mu kepadaku dan aku mengakui dosaku. Oleh karena itu, ampunilah aku. Sesungguhnya tiada yang mengampuni dosa kecuali Engkau.” (Dibaca 1 x),",
            "“Ya Allah, selamatkanlah tubuhku (dari penyakit dan dari apa yang tidak aku inginkan). Ya Allah, selamatkanlah pendengaranku (dari penyakit dan maksiat atau dari apa yang tidak aku inginkan). Ya Allah, selamatkanlah penglihatanku, tidak ada Ilah yang berhak diibadahi dengan benar kecuali Engkau. Ya Allah, sesungguhnya aku berlindung kepada-Mu dari kekufuran dan kefakiran. Aku berlindung kepada-Mu dari siksa kubur, tidak ada Ilah yang berhak diibadahi dengan benar kecuali Engkau.” (Dibaca 3x),",
            "“Ya Allah, sesungguhnya aku memohon kebajikan dan keselamatan di dunia dan akhirat. Ya Allah, sesungguhnya aku memohon kebajikan dan keselamatan dalam agama, dunia, keluarga dan hartaku. Ya Allah, tutupilah auratku (aib dan sesuatu yang tidak layak dilihat orang) dan tentramkan-lah aku dari rasa takut. Ya Allah, peliharalah aku dari depan, belakang, kanan, kiri dan dari atasku. Aku berlindung dengan kebesaran-Mu, agar aku tidak disambar dari bawahku (aku berlindung dari dibenamkan ke dalam bumi).”(Dibaca 1x),",
            "“Ya Allah Yang Mahamengetahui yang ghaib dan yang nyata, wahai Rabb Pencipta langit dan bumi, Rabb atas segala sesuatu dan Yang Merajainya. Aku bersaksi bahwa tidak ada Ilah yang berhak diibadahi dengan benar kecuali Engkau. Aku berlindung kepada-Mu dari kejahatan diriku, syaitan dan ajakannya menyekutukan Allah (aku berlindung kepada-Mu) dari berbuat kejelekan atas diriku atau mendorong seorang muslim kepadanya.” (Dibaca 1x)",
            "“Dengan Menyebut Nama Allah, yang dengan Nama-Nya tidak ada satupun yang membahayakan, baik di bumi maupun dilangit. Dia-lah Yang Mahamendengar dan Maha mengetahui.” (Dibaca 3x),",
            "“Aku rela (ridha) Allah sebagai Rabb-ku (untukku dan orang lain), Islam sebagai agamaku dan Muhammad صلي الله عليه وسلم sebagai Nabiku (yang diutus oleh Allah).” (Dibaca pagi dan sore 3x),",
            "“Wahai Rabb Yang Maha hidup, Wahai Rabb Yang Maha berdiri sendiri (tidak butuh segala sesuatu) dengan rahmat-Mu aku meminta pertolongan, perbaikilah segala urusanku dan jangan diserahkan (urusanku) kepada diriku sendiri meskipun hanya sekejap mata (tanpa mendapat pertolongan dari-Mu).” (Dibaca pagi dan sore 1x),",
            "“Tidak ada Ilah yang berhak diibadahi dengan benar selain Allah Yang Maha Esa, tidak ada sekutu bagi-Nya. Bagi-Nya kerajaan dan bagi-Nya segala puji. Dan Dia Mahakuasa atas segala sesuatu.” (Dibaca 1x, 10x atau, 100x),",
            "“Aku berlindung dengan kalimat-kalimat Allah yang sempurna, dari kejahatan sesuatu yang diciptakan-Nya.” (Dibaca 3x)",
            "“Maha Suci Allah, aku memujiNya sebanyak makhluk-Nya, sejauh kerelaan-Nya, seberat timbangan ‘Arsy-Nya dan sebanyak tinta tulisan kalimat-Nya.” (Dibaca 3 x di waktu pagi saja)",
            "“Ya Allah, sungguh aku memohon kepada-Mu ilmu yang bermanfaat (bagi diriku dan orang lain), rizki yang halal dan amal yang diterima (di sisi-Mu dan mendapatkan ganjaran yang baik).” (Dibaca 1 x setelah salam dari shalat Shubuh)[ ",
            "“Maha suci Allah, aku memuji-Nya.” (Dibaca 100 x)",
            "“Aku memohon ampun kepada Allah dan bertobat kepada-Nya.” (Dibaca 100 x dalam sehari)"};

    private String[] idpetang = {"Taawudz",
            "Ayat Kursi",
            "An-Ikhlas",
            "Al-Falaq",
            "An-Naas",
            "doa5",
            "doa6",
            "doa7",
            "doa8",
            "doa9",
            "doa10",
            "doa11",
            "doa12",
            "doa13",
            "doa14",
            "doa15",
            "doa16",
            "doa17"};


    private String[] nopetang = {"Doa yang dibaca Petang hari",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20"};

    private String[] judulpetang = {"أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيم",
            "اللَّهُ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ، لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ، لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ، مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلاَّ بِإِذْنِهِ، يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ، وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلاَّ بِمَا شَاءَ، وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ، وَلَا يَئُودُهُ حِفْظُهُمَا، وَهُوَ الْعَلِيُّ الْعَظِيمُ",
            "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\n" + "قُلْ هُوَ اللَّهُ أَحَدٌ (١) للَّهُ الصَّمَدُ (٢) لَمْ يَلِدْ وَلَمْ يُولَدْ (٣) وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ (٤)",
            "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\n" + "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ (١) مِن شَرِّ مَا خَلَقَ (٢) وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ (٣) وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ (٤) وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ (٥)",
            "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\n" + "قُلْ أَعُوذُ بِرَبِّ النَّاسِ (١) مَلِكِ النَّاسِ (٢) إِلَهِ النَّاسِ (٣) مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ (٤) الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ (٥) مِنَ الْجِنَّةِ وَ النَّاسِ (٦)",
            "أَمْسَيْنَا وَأَمْسَى الْمُلْكُ للهِ، وَالْحَمْدُ للهِ، لَا إِلَهَ إِلاَّ اللهُ وَحْدَهُ لاَ شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِي هَذِهِ اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهَا، وَأَعُوذُبِكَ مِنْ شَرِّ مَا فِي هَذِهِ اللَّيْلَةِ وَشَرِّ مَا بَعْدَهَا، رَبِّ أَعُوذُبِكَ مِنَ الْكَسَلِ وَسُوءِ الْكِبَرِ، رَبِّ أَعُوذُبِكَ مِنْ عَذَابٍ فِي النَّارِ وَعَذَابٍ فِي الْقَبْرِ",
            "اللَّهُمَّ بِكَ أَمْسَيْنَا، وَبِكَ أَصْبَحْنَا،وَبِكَ نَحْيَا، وَبِكَ نَمُوتُ، وَإِلَيْكَ الْمَصِيْرُ",
            "أَمْسَيْنَا عَلَى فِطْرَةِ اْلإِسْلاَمِ وَعَلَى كَلِمَةِ اْلإِخْلاَصِ، وَعَلَى دِيْنِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ، وَعَلَى مِلَّةِ أَبِيْنَا إِبْرَاهِيْمَ، حَنِيْفًا مُسْلِمًا وَمَا كَانَ مِنَ الْمُشْرِكِيْنَ",
            "اَللَّهُمَّ أَنْتَ رَبِّيْ لاَ إِلَـهَ إِلاَّ أَنْتَ، خَلَقْتَنِيْ وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوْذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوْءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوْءُ بِذَنْبِيْ فَاغْفِرْ لِيْ فَإِنَّهُ لاَ يَغْفِرُ الذُّنُوْبَ إِلاَّ أَنْتَ",
            "اَللَّهُمَّ عَافِنِيْ فِيْ بَدَنِيْ، اَللَّهُمَّ عَافِنِيْ فِيْ سَمْعِيْ، اَللَّهُمَّ عَافِنِيْ فِيْ بَصَرِيْ، لاَ إِلَـهَ إِلاَّ أَنْتَ. اَللَّهُمَّ إِنِّي أَعُوْذُ بِكَ مِنَ الْكُفْرِ وَالْفَقْرِ، وَأَعُوْذُ بِكَ مِنْ عَذَابِ الْقَبْرِ، لاَ إِلَـهَ إِلاَّ أَنْتَ",
            "اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ الْعَفْوَ وَالْعَافِيَةَ فِي الدُّنْيَا وَاْلآخِرَةِ، اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ الْعَفْوَ وَالْعَافِيَةَ فِي دِيْنِيْ وَدُنْيَايَ وَأَهْلِيْ وَمَالِيْ اللَّهُمَّ اسْتُرْ عَوْرَاتِى وَآمِنْ رَوْعَاتِى. اَللَّهُمَّ احْفَظْنِيْ مِنْ بَيْنِ يَدَيَّ، وَمِنْ خَلْفِيْ، وَعَنْ يَمِيْنِيْ وَعَنْ شِمَالِيْ، وَمِنْ فَوْقِيْ، وَأَعُوْذُ بِعَظَمَتِكَ أَنْ أُغْتَالَ مِنْ تَحْتِيْ",
            "اَللَّهُمَّ عَالِمَ الْغَيْبِ وَالشَّهَادَةِ فَاطِرَ السَّمَاوَاتِ وَاْلأَرْضِ، رَبَّ كُلِّ شَيْءٍ وَمَلِيْكَهُ، أَشْهَدُ أَنْ لاَ إِلَـهَ إِلاَّ أَنْتَ، أَعُوْذُ بِكَ مِنْ شَرِّ نَفْسِيْ، وَمِنْ شَرِّ الشَّيْطَانِ وَشِرْكِهِ، وَأَنْ أَقْتَرِفَ عَلَى نَفْسِيْ سُوْءًا أَوْ أَجُرُّهُ إِلَى مُسْلِمٍ",
            "بِسْمِ اللهِ الَّذِي لاَ يَضُرُّ مَعَ اسْمِهِ شَيْءٌ فِي اْلأَرْضِ وَلاَ فِي السَّمَاءِ وَهُوَ السَّمِيْعُ الْعَلِيْمُ",
            "رَضِيْتُ بِاللهِ رَبًّا، وَبِاْلإِسْلاَمِ دِيْنًا، وَبِمُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ نَبِيًّا",
            "يَا حَيُّ يَا قَيُّوْمُ بِرَحْمَتِكَ أَسْتَغِيْثُ، أَصْلِحْ لِيْ شَأْنِيْ كُلَّهُ وَلاَ تَكِلْنِيْ إِلَى نَفْسِيْ طَرْفَةَ عَيْنٍ",
            "لاَ إِلَـهَ إِلاَّ اللهُ وَحْدَهُ لاَ شَرِيْكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيْرُ",
            "سُبْحَانَ اللهِ وَبِحَمْدِهِ",
            "أَعُوْذُ بِكَلِمَاتِ اللهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ"};

    private String[] subjudulpetang = {"“Aku berlindung kepada Allah dari godaan syaitan yang terkutuk.”",
            "“Allah, tidak ada ilah (yang berhak disembah) melainkan Dia, yang hidup kekal lagi terus menerus mengurus (makhluk-Nya). Dia tidak mengantuk dan tidak tidur. Kepunyaan-Nya apa yang di langit dan di bumi. Tiada yang dapat memberi syafa’at di sisi-Nya tanpa seizin-Nya. Dia mengetahui apa-apa yang di hadapan mereka dan di belakang mereka. Mereka tidak mengetahui apa-apa dari ilmu Allah melainkan apa yang dikehendaki-Nya. Kursi Allah meliputi langit dan bumi. Dia tidak merasa berat memelihara keduanya. Dan Dia Maha Tinggi lagi Maha besar.” (QS. Al Baqarah: 255) (Dibaca 1 x)",
            "“Dengan menyebut nama Allah Yang Maha Pengasih lagi Maha Penyayang. Katakanlah: Dialah Allah, Yang Maha Esa. Allah adalah ilah yang bergantung kepada-Nya segala urusan. Dia tidak beranak dan tiada pula diperanakkan, dan tidak ada seorang pun yang setara dengan Dia.” (QS. Al Ikhlas: 1-4) (Dibaca 3 x)",
            "“Dengan menyebut nama Allah Yang Maha Pengasih lagi Maha Penyayang. Katakanlah: Aku berlindung kepada Rabb yang menguasai Shubuh, dari kejahatan makhluk-Nya, dan dari kejahatan malam apabila telah gelap gulita, dan dari kejahatan-kejahatan wanita tukang sihir yang menghembus pada buhul-buhul, dan dari kejahatan orang yang dengki apabila ia dengki”. (QS. Al Falaq: 1-5) (Dibaca 3 x)",
            "“Dengan menyebut nama Allah Yang Maha Pengasih lagi Maha Penyayang. Katakanlah: Aku berlindung kepada Rabb manusia. Raja manusia. Sembahan manusia, dari kejahatan (bisikan) syaitan yang biasa bersembunyi, yang membisikkan (kejahatan) ke dalam dada manusia, dari jin dan manusia.” (QS. An Naas: 1-6) (Dibaca 3 x)",
            "“Kami telah memasuki waktu sore dan kerajaan hanya milik Allah, segala puji hanya milik Allah. Tidak ada Ilah yang berhak diibadahi dengan benar kecuali Allah Yang Maha Esa, tiada sekutu bagi-Nya. Bagi-Nya kerajaan dan bagi-Nya pujian. Dia-lah Yang Mahakuasa atas segala sesuatu. Wahai Rabb, aku mohon kepada-Mu kebaikan di malam ini dan kebaikan sesudahnya. Aku berlindung kepada-Mu dari kejahatan malam ini dan kejahatan sesudahnya. Wahai Rabb, aku berlindung kepada-Mu dari kemalasan dan kejelekan di hari tua. Wahai Rabb, aku berlindung kepada-Mu dari siksaan di Neraka dan siksaan di kubur.”(Dibaca 1x)",
            "“Ya Allah, dengan rahmat dan pertolongan-Mu kami memasuki waktu sore dan dengan rahmat dan pertolongan-Mu kami memasuki waktu pagi. Dengan rahmat dan kehendak-Mu kami hidup dan dengan rahmat dan kehendak-Mu kami mati. Dan kepada-Mu tempat kembali (bagi semua makhluk).” (Dibaca 1x)",
            "“Di waktu sore kami berada diatas fitrah agama Islam, kalimat ikhlas, agama Nabi kita Muhammad صلي الله عليه وسلم dan agama ayah kami, Ibrahim, yang berdiri di atas jalan yang lurus, muslim dan tidak tergolong orang-orang yang musyrik.” (Dibaca 1x)",
            "“Ya Allah, Engkau adalah Rabbku, tidak ada ilah yang berhak disembah kecuali Engkau, Engkaulah yang menciptakanku. Aku adalah hamba-Mu. Aku akan setia pada perjanjianku pada-Mu (yaitu aku akan mentauhidkan-Mu) semampuku dan aku yakin akan janji-Mu (berupa surga untukku). Aku berlindung kepada-Mu dari kejelekan yang kuperbuat. Aku mengakui nikmat-Mu kepadaku dan aku mengakui dosaku. Oleh karena itu, ampunilah aku. Sesungguhnya tiada yang mengampuni dosa kecuali Engkau.” (Dibaca 1 x)",
            "“Ya Allah, selamatkanlah tubuhku (dari penyakit dan dari apa yang tidak aku inginkan). Ya Allah, selamatkanlah pendengaranku (dari penyakit dan maksiat atau dari apa yang tidak aku inginkan). Ya Allah, selamatkanlah penglihatanku, tidak ada Ilah yang berhak diibadahi dengan benar kecuali Engkau. Ya Allah, sesungguhnya aku berlindung kepada-Mu dari kekufuran dan kefakiran. Aku berlindung kepada-Mu dari siksa kubur, tidak ada Ilah yang berhak diibadahi dengan benar kecuali Engkau.” (Dibaca 3x)",
            "“Ya Allah, sesungguhnya aku memohon kebajikan dan keselamatan di dunia dan akhirat. Ya Allah, sesungguhnya aku memohon kebajikan dan keselamatan dalam agama, dunia, keluarga dan hartaku. Ya Allah, tutupilah auratku (aib dan sesuatu yang tidak layak dilihat orang) dan tentramkan-lah aku dari rasa takut. Ya Allah, peliharalah aku dari depan, belakang, kanan, kiri dan dari atasku. Aku berlindung dengan kebesaran-Mu, agar aku tidak disambar dari bawahku (aku berlindung dari dibenamkan ke dalam bumi).”(Dibaca 1x)",
            "“Ya Allah Yang Mahamengetahui yang ghaib dan yang nyata, wahai Rabb Pencipta langit dan bumi, Rabb atas segala sesuatu dan Yang Merajainya. Aku bersaksi bahwa tidak ada Ilah yang berhak diibadahi dengan benar kecuali Engkau. Aku berlindung kepada-Mu dari kejahatan diriku, syaitan dan ajakannya menyekutukan Allah (aku berlindung kepada-Mu) dari berbuat kejelekan atas diriku atau mendorong seorang muslim kepadanya.” (Dibaca 1x)",
            "“Dengan Menyebut Nama Allah, yang dengan Nama-Nya tidak ada satupun yang membahayakan, baik di bumi maupun dilangit. Dia-lah Yang Mahamendengar dan Maha mengetahui.” (Dibaca 3x)",
            "“Aku rela (ridha) Allah sebagai Rabb-ku (untukku dan orang lain), Islam sebagai agamaku dan Muhammad صلي الله عليه وسلم sebagai Nabiku (yang diutus oleh Allah).” (Dibaca pagi dan sore 3x)",
            "“Wahai Rabb Yang Maha hidup, Wahai Rabb Yang Maha berdiri sendiri (tidak butuh segala sesuatu) dengan rahmat-Mu aku meminta pertolongan, perbaikilah segala urusanku dan jangan diserahkan (urusanku) kepada diriku sendiri meskipun hanya sekejap mata (tanpa mendapat pertolongan dari-Mu).” (Dibaca pagi dan sore 1x)",
            "“Tidak ada Ilah yang berhak diibadahi dengan benar selain Allah Yang Maha Esa, tidak ada sekutu bagi-Nya. Bagi-Nya kerajaan dan bagi-Nya segala puji. Dan Dia Mahakuasa atas segala sesuatu.” (Dibaca 1x, 10x atau, 100x)",
            "“Mahasuci Allah, aku memuji-Nya.” (Dibaca 100x)",
            "“Aku berlindung dengan kalimat-kalimat Allah yang sempurna, dari kejahatan sesuatu yang diciptakan-Nya.” (Dibaca 3x)"};



    private String[] idDoa = {
            "doa1",
            "doa2",
            "doa3",
            "doa4",
            "doa5",
            "doa6",
            "doa7",
            "doa8",
            "doa9",
            "doa10",
            "doa11",
            "doa12",
            "doa13",
            "doa14",
            "doa15"};


    private String[] noDoa = {
            "1. Do’a Bangun Tidur",
            "2. Do’a Menjelang Tidur",
            "3. Do’a Masuk Kamar Mandi",
            "4. Do’a Keluar Kamar Mandi",
            "5. Do’a Ketika Bersiwak",
            "6. Do’a Memakai Baju/Pakaian",
            "7. Do’a ketika Melepas Baju",
            "8. Dzikir Sebelum Wudhu",
            "9. Dzikir Setelah Selesai Wudhu",
            "10. Do’a Masuk Masjid",
            "11. Do’a Keluar dari Masjid",
            "12. Dzikir Keluar dari Rumah",
            "13. Dzikir Masuk Rumah",
            "14. Doa Kepada Orang Sakit",
            "15. Do'a Apabila Hujan Turun"};

    private String[] judulDoa = {
            "الْحَمْدُ لِلَّهِ الَّذِي أَحْيَاناَ بَعْـدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُوْرِ",
            "بِسْمِكَ اللّهُمَّ اَحْيَا وَاَمُوْتُ",
            "اَللهُمَّ اِنّىْ اَعُوْذُبِكَ مِنَ الْخُبُثِ وَالْخَبَآئِثِ",
            "غُفْرَانَكَ",
            "اَللَّهُمَّ بَيِّضْ بِهِ أَسْنَانِيْ وَشُدَّ بِهِ لِثَّتِيْ وَثَبِّتْ بِهِ لَهَاتِي وَأَفْصِحْ بِهِ لِسَانِيْ وَبَارِكْ لِيْ فِيْهِ وَأَثِبْنِيْ عَلَيْهِ يَآ أَرْحَمَ الرَّاحِمِيْنَ",
            "الْحَمْدُ لِلَّهِ الَّذِيْ كَسَانِيْ هَذَا (الثَّوْبَ) وَرَزَقَنِيْهِ مِنْ غَيْرِ حَوْلٍ مِنِّيْ وَلاَ قُوَّةٍ",
            "بِسْمِ اللهِ",
            "بِسْمِ اللهِ",
            "أَشْهَدُ أَنْ لاَّ إِلَهَ إِلاَّ اللهُ وَحْدَهُ لاَ شَرِيْكَ لَهُ وَأَشْهَدُ أَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُوْلُهُ",
            "للَّهُمَّ افْتَحْ لِيْ أَبْوَابَ رَحْمَتِكَِ",
            " اللَّهُمَّ إِنِّيْ أَسْأَلُكَ مِنْ فَضْلِكَِ",
            "بِسْمِ اللهِ تَوَكَّلْتُ عَلَى اللهِ، وَلاَ حَوْلَ وَلاَ قُوَّةَ إِلاَّ بِاللهِ",
            "فَإِذَا دَخَلْتُمْ بُيُوتًا فَسَلِّمُوا عَلَى أَنْفُسِكُمْ تَحِيَّةً مِنْ عِنْدِ اللَّهِ مُبَارَكَةً طَيِّبَةً",
            "اَ بَأْسَ طَهُوْرٌ إِنْ شَاءَ اللهُ",
            "للَّهُمَّ صَيِّبًا نَافِعًا"};


    private String [] subJudulDoa = {
            "Artinya : “Segala puji bagi Allah Yang membangunkan kami setelah ditidurkan-Nya dan kepada-Nya kami dibangkitkan”. (HR. Bukhari dan Muslim)”",
            "Artinya : “Dengan nama-Mu ya Allah aku hidup dan aku mati”",
            "Artinya : “Ya Allah, aku berlindung dari godaan syetan laki-laki dan syetan perempuan”",
            "Artinya : “Dengan mengharap ampunanMu",
            "Artinya : “Ya Allah putihkan gigiku dan kuatkan gusiku, serta kuatkan lahatku (daging yang tumbuh di atas langit-langit mulut) dan fasihkan lidahku dengan siwak itu serta berkatilah siwak tersebut dan berilah pahala aku karenanya wahai Dzat paling mengasihi diantara para pengasih”",
            "Artinya : “Segala puji bagi Allah yang telah memakaikan kepadaku pakaian ini dan yang telah memberikan rizki pakaian ini kepadaku tanpa ada daya dan kekuatan dariku.” (HR. Abu Dawud, At-Tirmidziy dan Ibnu Majah, lihat Irwaa`ul Ghaliil",
            "Artinya : “Dengan nama Allah.” (HR. At-Tirmidziy 2/505 dan lainnya, lihat Irwaa`ul Ghaliil no.49 dan Shahiihul Jaami’ 3/203)",
            "Artinya : “Dengan nama Allah.” (HR. Abu Dawud, Ibnu Majah dan Ahmad, lihat Irwaa`ul Ghaliil 1/122)",
            "Artinya : “Aku bersaksi bahwasanya tidak ada tuhan yang berhak diibadahi kecuali Allah satu-satu-Nya, tidak ada sekutu bagi-Nya. Dan aku bersaksi bahwasanya Muhammad adalah hamba dan utusan-Nya.” (HR. Muslim 1/209)",
            "Artinya : “ Ya Allah, bukakanlah untukku pintu-pintu rahmat-Mu.” ",
            "Artinya : “Ya Allah, sesungguhnya aku memohon kepada-Mu akan karunia-Mu",
            "Artinya : “Dengan nama Allah, aku hanya bertawakkal kepada Allah. Dan tidak ada daya dan kekuatan kecuali dengan pertolongan Allah.” (HR. Abu Dawud 4/325 dan At-Tirmidziy 5/490, lihat Shahih At-Tirmidziy 3/151)",
            "Artinya : “Maka apabila kalian memasuki (suatu rumah dari) rumah-rumah (ini), hendaklah kalian memberi salam kepada (penghuninya yang berarti memberi salam) kepada diri kalian sendiri, salam yang ditetapkan dari sisi Allah, yang diberi berkah lagi baik.” (An-Nuur:61)",
            "Artinya : “Tidak mengapa, semoga sakitmu ini membuat dosamu bersih, Insya Allah“. (HR. Bukhari)",
            "Artinya : “Ya Allah! Turunkanlah hujan yang bermanfaat” (HR. Bukhari)"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        idDzikir = getIntent().getStringExtra("KEY");
        rvMain = findViewById(R.id.rvMain);
        arrayList = new ArrayList<>();
        if (idDzikir.equals("pagi")) {
            setDataPagi();
        } else if (idDzikir.equals("petang")){
            setDataPetang();
        }else
            setDoaHarian();

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setHasFixedSize(true);
        dzikirAdapter = new DzikirAdapter(arrayList);
        rvMain.setAdapter(dzikirAdapter);


    }

    private void setDataPagi() {
        for (String idpagi : idpagi) {
            arrayList.add(new ModelDzikir(idpagi, nopagi[count], judulPagi[count], subJudulPagi[count]));
            count++;
        }

    }


    private void setDataPetang() {
        for (String idpetang : idpetang) {
            arrayList.add(new ModelDzikir(idpetang, nopetang[count], judulpetang[count], subjudulpetang[count]));
            count++;
        }
    }


    private void setDoaHarian() {
        for (String idDoa : idDoa) {
            arrayList.add(new ModelDzikir(idDoa, noDoa[count], judulDoa[count], subJudulDoa[count]));
            count++;
        }
    }


}
