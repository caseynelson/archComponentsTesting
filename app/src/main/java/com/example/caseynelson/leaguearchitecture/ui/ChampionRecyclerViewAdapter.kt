package com.example.caseynelson.leaguearchitecture.ui

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caseynelson.leaguearchitecture.R
import com.example.caseynelson.leaguearchitecture.model.ChampionDto
import kotlinx.android.synthetic.main.champion_item.view.*

class ChampionRecyclerViewAdapter (private var championList: List<ChampionDto>) : RecyclerView.Adapter<ChampionRecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionRecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return championList.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.champion_item
    }

    override fun onBindViewHolder(holder: ChampionRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(championList[position])
    }

    fun update(newChampionList: List<ChampionDto>) {
        championList = newChampionList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView

        fun bind(champion: ChampionDto) {
            view.tv_champion_name.text = champion.name
        }


    }

}
