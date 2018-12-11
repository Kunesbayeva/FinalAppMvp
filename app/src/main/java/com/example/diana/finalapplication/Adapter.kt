package com.example.diana.finalapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*


class Adapter(private val context : Context,
              private val items : ArrayList<Item>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val item = items.get(position)

        holder?.itemView?.tvName?.text = item.name
        holder?.itemView?.tvMobile?.text = item.mobile
        holder?.itemView?.tvHome?.text = item.work
        holder?.itemView?.tvWork?.text = item.home
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ItemsViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)
}