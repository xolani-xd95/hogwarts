package com.example.hogwarts.ui.spells

import android.view.View
import com.example.hogwarts.network.dto.SpellDTO
import com.example.hogwarts.utils.BaseViewHolder
import kotlinx.android.synthetic.main.item_spell.view.*

class AllSpellsViewHolder<X>(itemView: View) : BaseViewHolder<X>(itemView) {
    override fun bind(item: X) {
        super.bind(item)
        val spell = (item as? SpellDTO)
        val typeName = "Type: ${spell?.type}"
        val spellEffect = "Effect: ${spell?.effect}"

        itemView.txtSpellName.text = spell?.spell
        itemView.txtTypeName.text = typeName
        itemView.txtSpellEffect.text = spellEffect
    }
}