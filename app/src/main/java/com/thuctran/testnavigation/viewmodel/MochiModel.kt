package com.thuctran.testnavigation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.thuctran.testnavigation.model.Photo
import com.thuctran.testnavigation.model.Topic
import com.thuctran.testnavigation.model.Vocab
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.w3c.dom.Document
import org.w3c.dom.Element

class MochiModel : BaseViewModel() {

    private val TAG: String = MochiModel::class.java.name
    private val LINK: String = "https://learn.mochidemy.com/user/1/2/learn"
    private var thread:Thread? = null
    private var banner:Topic? = null      //danh sách banners
     var loadBannerEvent:MutableLiveData<Boolean> = MutableLiveData(false)      //tạo ra thằng này để thông báo load ảnh xong rồi

    val BANNER:Topic?
        get() = banner

    fun parseHTTPMochi(){
        if(thread==null || !thread!!.isAlive){
            try {
                thread = Thread {
                    var doc:org.jsoup.nodes.Document = Jsoup.connect(LINK).get()    //đọc tài liệu theo link, sử dụng thằng Jsoup
                    var items:Elements = doc.getElementsByTag("body")     //lấy dữ liệu/yêu tố (Elements) theo tên thẻ tag "figure"
                    var vocab:MutableList<Vocab> = mutableListOf()      //danh sách ảnh (Photo)

                    for (item in items){
                        //lây ảnh theo thẻ tag
                        var vob:String = item.getElementsByTag("audio").attr("src")      //attr: Giá trị của thuộc tính từ phần tử được khớp đầu tiên có thuộc tính. Nếu không có phần tử nào được khớp (isEmpty() == true) hoặc nếu không có phần tử nào có thuộc tính, thì trả về chuỗi trống.
                        // src = link ảnh (trên web)
                        //if (vob.contains("profile")) continue           //trong vòng lặp, nếu img chứa "profile" thì bỏ qua vì đây là ảnh lỗi
                        Log.i(TAG, "từ vựng: $vob")

                    }
                    loadBannerEvent.postValue(true)
                }
            }catch (e:Exception){
                loadBannerEvent.postValue(false)
                e.printStackTrace()         //khai báo try catch trể tránh ngoại lệ khi chơi Thread
            }
            thread?.isDaemon = true     //chương trình kết thúc thì thread kết thúc theo
            thread?.start()
        }
    }
}