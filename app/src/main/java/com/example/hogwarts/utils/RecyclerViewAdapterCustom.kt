package com.example.hogwarts.utils

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts.R
import com.example.hogwarts.network.dto.SpellDTO
import kotlinx.android.synthetic.main.item_spell.view.*

class RecyclerViewAdapterCustom(private var dataSet: ArrayList<SpellDTO>) :
    RecyclerView.Adapter<TestingViewHolder>() {

    fun updateDataSet(_dataSet: ArrayList<SpellDTO>) {
        dataSet = _dataSet
        notifyDataSetChanged()
    }

    private var checkedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestingViewHolder {
        return TestingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_spell,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: TestingViewHolder, position: Int) {
        holder.TransactingMember.text = dataSet[position].effect
        holder.TransactionHistoryAmount.text = dataSet[position].type
        holder.TransactionHistoryClassification.text = dataSet[position].spell

        holder.row.isSelected = checkedPosition == position
        if (checkedPosition == position) {
            TransitionManager.beginDelayedTransition(holder.tets, AutoTransition())
            holder.TransactionDetails.visibility = View.VISIBLE
        } else {
            holder.TransactionDetails.visibility = View.GONE
            TransitionManager.beginDelayedTransition(holder.tets, AutoTransition())
        }
        holder.row.setOnClickListener {
            it.isSelected = !it.isSelected
            if (checkedPosition == position) {
                it.isSelected = false
            }
            val previousItem = checkedPosition
            checkedPosition = position
            notifyItemChanged(previousItem)
            notifyItemChanged(position)
        }
    }
}

class TestingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var TransactionHistoryClassification: TextView = itemView.txtTransactionHistoryClassification
    var TransactionHistoryAmount: TextView = itemView.txtTransactionHistoryAmount
    var TransactingMember: TextView = itemView.txtTransactingMember
    var TransactionDetails: ViewGroup = itemView.transactionDetails
    var tets = itemView.testing
    var row = itemView
}