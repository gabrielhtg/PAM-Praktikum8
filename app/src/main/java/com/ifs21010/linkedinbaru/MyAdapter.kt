package com.ifs21010.linkedinbaru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (val listPostingan : ArrayList<DataPostingan>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    inner class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var namaPemosting : TextView
        var fotoProfilPemosting : ImageView
        var captionPemosting :TextView
        var gambarPostingan : ImageView

        init {
            namaPemosting = itemView.findViewById(R.id.nama_pemosting)
            fotoProfilPemosting = itemView.findViewById(R.id.foto_profil)
            captionPemosting = itemView.findViewById(R.id.caption_pemosting)
            gambarPostingan = itemView.findViewById(R.id.gambar_postingan)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.postingan_item, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listPostingan.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.namaPemosting.text = listPostingan[position].namaPemosting
        holder.gambarPostingan.setImageResource(listPostingan[position].gambarPostingan)
        holder.captionPemosting.text = listPostingan[position].captionPostingan
        holder.fotoProfilPemosting.setImageResource(listPostingan[position].fotoProfilPemosting)
    }
}