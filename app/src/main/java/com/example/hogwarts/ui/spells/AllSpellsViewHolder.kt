package com.example.hogwarts.ui.spells

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.Toast
import com.example.hogwarts.network.dto.SpellDTO
import com.example.hogwarts.utils.BaseViewHolder
import kotlinx.android.synthetic.main.item_spell.view.*

class AllSpellsViewHolder<X>(itemView: View) : BaseViewHolder<X>(itemView) {
    override fun bind(item: X) {
        super.bind(item)
        val spell = (item as? SpellDTO)

        itemView.txtTransactionHistoryClassification.text = spell?.spell
        itemView.txtTransactionHistoryAmount.text = spell?.type
        itemView.txtTransactingMember.text = spell?.effect

        itemView.setOnClickListener {
            itemView.requestFocus(adapterPosition)
            it.setSelected(!it.isSelected())
            Toast.makeText(itemView.context, "$adapterPosition", Toast.LENGTH_SHORT).show()
            if (it.isSelected) {
                TransitionManager.beginDelayedTransition(itemView.testing, AutoTransition())
                itemView.transactionDetails.visibility = View.VISIBLE
            } else {
                itemView.transactionDetails.visibility = View.GONE
                TransitionManager.beginDelayedTransition(itemView.testing, AutoTransition())
            }

        }
        itemView.setOnFocusChangeListener { v, hasFocus ->
            v.focusSearch(adapterPosition)
            if (hasFocus) {
                v.isSelected = false
                TransitionManager.beginDelayedTransition(itemView.testing, AutoTransition())
                itemView.transactionDetails.visibility = View.GONE
            }
        }
    }
}