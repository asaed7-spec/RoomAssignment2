package com.example.roomassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.MyViewHolder>() {

    private var courseList = emptyList<Course>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int = courseList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = courseList[position]
        holder.itemView.findViewById<TextView>(R.id.courseName_txt).text = currentItem.courseName
        holder.itemView.findViewById<TextView>(R.id.courseCode_txt).text = currentItem.courseCode
    }

    fun setData(courses: List<Course>){
        this.courseList = courses
        notifyDataSetChanged()
    }
}