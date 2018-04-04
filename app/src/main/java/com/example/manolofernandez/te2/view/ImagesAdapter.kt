package com.example.manolofernandez.te2.view

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.manolofernandez.te2.R
import com.example.manolofernandez.te2.model.Item
import com.squareup.picasso.Picasso

/**
 * Created by manolofernandez on 4/1/18.
 */

class ImagesAdapter(context: Activity, private val itemList: List<Item>) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    private val context: Context

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.images_adapter, parent, false)
        return ImagesAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var textItemTitle: TextView
        internal var imageItemView: ImageView

        init {
            textItemTitle = v.findViewById<TextView>(R.id.textItemTitle)
            imageItemView = v.findViewById<ImageView>(R.id.imageItemView)
        }

        fun bind(item: Item, context: Context) {
            textItemTitle.text = item.title
            Picasso.with(context).load(item.media!!.m).resize(100, 100).into(imageItemView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}
