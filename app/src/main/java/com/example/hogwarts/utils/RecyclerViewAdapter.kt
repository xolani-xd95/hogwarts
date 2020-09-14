package com.example.hogwarts.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts.R
import com.example.hogwarts.ui.spells.AllSpellsViewHolder

class RecyclerViewAdapter<X>(
    private var dataSet: ArrayList<X>
) : RecyclerView.Adapter<BaseViewHolder<X>>() {

    // simply call this function in whatever fragment to populate your RV
    fun updateRecyclerViewData(_dataSet: ArrayList<X>) {
        dataSet = _dataSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<X> {
        val inflater = LayoutInflater.from(parent.context)
        return getBaseViewHolder(viewType, inflater, parent)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<X>, position: Int) {
        holder.bind(dataSet[position])
    }

    // Switch out different view holders according to type assigned to model
    private fun getBaseViewHolder(
        viewType: Int,
        inflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<X> {
        return when (viewType) {
            ViewHolderType.ALL_SPELLS.ordinal -> AllSpellsViewHolder(
                inflater.inflate(
                    R.layout.item_spell,
                    parent,
                    false
                )
            )
            else -> AllSpellsViewHolder(
                inflater.inflate(
                    R.layout.item_spell,
                    parent,
                    false
                )
            )
        }
    }
}
