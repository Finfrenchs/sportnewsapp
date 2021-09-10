package com.dicoding.submission.footballnews.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.submission.footballnews.R
import kotlinx.android.synthetic.main.item_list_home.*

class HomeAdapter(private val listContent: ArrayList<HomeModelData>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var contentPhoto: ImageView = itemView.findViewById(R.id.image_item_photo)
        var contentName: TextView = itemView.findViewById(R.id.tv_Content_Name)
        var contentDetail: TextView = itemView.findViewById(R.id.tv_Content_Detail)
        var buttonCV: CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val content = listContent[position]

        Glide.with(holder.itemView.context)
            .load(content.photo)
            .apply(RequestOptions().override(300,120))
            .into(holder.contentPhoto)

        holder.contentName.text = content.content
        holder.contentDetail.text = content.details
    }

    override fun getItemCount(): Int {
        return listContent.size
    }
}