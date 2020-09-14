package com.example.hogwarts.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

// all different types of items for the RV
enum class ViewHolderType{
    ALL_SPELLS,
    ALL_HOUSES,
    ALL_STUDENTS,
    DEFAULT
}

// base class for all VH to extend from
open class BaseViewHolder<X>(itemView: View): RecyclerView.ViewHolder(itemView){
    open fun bind(item: X){}
}