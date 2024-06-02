package com.merberk.seyirtabani.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.merberk.seyirtabani.R
import com.merberk.seyirtabani.databinding.ItemShowBinding
import com.merberk.seyirtabani.model.Show
import com.merberk.seyirtabani.view.MainActivity
import com.merberk.seyirtabani.view.home.HomeFragment

class ShowAdapter(private var showList: ArrayList<Show>, private var onClick: (position: Int)->Unit): RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    class ShowViewHolder(var view: ItemShowBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemShowBinding>(inflater, R.layout.item_show,parent,false)

        return ShowViewHolder(view)
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.view.showTitle.text = showList[position].title
        holder.view.showPopularityVal.text = showList[position].popularity.toString()
        holder.view.showStarAvg.text = String.format("%.1f", showList[position].voteAverage)

        holder.view.showStarCount.text = "(" +  showList[position].voteCount.toString() + ")"

        holder.view.cvItem.setOnClickListener {
            if(HomeFragment.interstitialAd!=null && HomeFragment.interstitialAd!!.isLoaded){
                HomeFragment.interstitialAd!!.show(MainActivity.activity)
            }else {
                Toast.makeText(holder.view.root.context, "Ad did not load", Toast.LENGTH_SHORT).show()
            }
            onClick(position)
        }
       Glide.with(holder.view.root)
            .load("https://image.tmdb.org/t/p/w500/" + showList[position].posterPath)
            .into(holder.view.showIV)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun  updateList(newList: List<Show>){
        showList = newList as ArrayList<Show>
        notifyDataSetChanged()
    }
}