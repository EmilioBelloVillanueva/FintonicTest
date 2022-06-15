package com.fintonic.beers.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fintonic.beers.databinding.ItemBeerBinding
import com.fintonic.beers.model.data.entitiesVO.BeerVo

class BeersAdapter(
    private var items: List<BeerVo>
) : RecyclerView.Adapter<BeersAdapter.BeerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BeerViewHolder(
        ItemBeerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        with(items[position]) {
            holder.apply {
                itemView.setOnClickListener {
                    //onItemSelected.invoke(BeerActionView.BeerItemClick(this@with))
                }

                binding.tvName.text = name
                binding.tvDescription.text = description

                Glide.with(itemView).load(imgUrl).into(binding.ivBeer)
            }
        }
    }

    fun updateItems(newItems: List<BeerVo>) {
        items = newItems
        notifyDataSetChanged()
    }



    inner class BeerViewHolder(val binding: ItemBeerBinding) : RecyclerView.ViewHolder(binding.root)

}