package com.thuctran.testnavigation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thuctran.testnavigation.R
import com.thuctran.testnavigation.model.Photo

class RecyclerViewAdapter(private var context: Context, private var list:MutableList<Photo>) : RecyclerView.Adapter<RecyclerViewAdapter.ClassHolder>() {

    //từ item_view trong res/layout ta ánh xạ thành ClassHolder(inflate)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view:View =LayoutInflater.from(context).inflate(R.layout.activity_home, parent,false)
        return ClassHolder(view)
    }

    //PT định nghĩa số lượng item để đúc
    override fun getItemCount(): Int {
        return list.size
    }

    //ClassHolder lấy ở thằng class bên dưới, đây là PT đưa vào số lượng itemdata, để nhét dữ liệu tương ứng của từng data vào từng ClassHolder
    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        var data: Photo = list[position]       //thay Any bằng tên Model tương ứng
        //ta có thể lấy dữ liệu của từng Model ở vị trí position
    }

    //Holder ở đây có nghĩa là đồ đựng
    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //tại đây có thể khai báo từng ĐT View tương ứng của thằng itemView. VD: var tvStoryName:TextView = itemView.findViewById(R.id.tv_story_name)
        //muốn setOnclick cho từng ĐT View khai báo thì phải đặt trong khố init
    }

}