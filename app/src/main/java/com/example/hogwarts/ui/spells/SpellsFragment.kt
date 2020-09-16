package com.example.hogwarts.ui.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts.MainActivity
import com.example.hogwarts.R
import com.example.hogwarts.network.dto.SpellDTO
import com.example.hogwarts.utils.RecyclerViewAdapter
import com.example.hogwarts.utils.RecyclerViewAdapterCustom
import com.example.hogwarts.utils.ViewHolderType
import com.example.hogwarts.utils.assignViewHolderType
import kotlinx.android.synthetic.main.fragment_hogwarts.*

class SpellsFragment : Fragment() {

    // ViewModel
    private lateinit var spellViewModel: SpellsViewModel

    // RecyclerView
    private lateinit var spellRecyclerViewAdapter: RecyclerViewAdapterCustom
    private lateinit var spellLinearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? MainActivity)?.setFragmentActionBar("Spells")
        return inflater.inflate(
            R.layout.fragment_hogwarts,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        spellViewModel = ViewModelProvider(this)[SpellsViewModel::class.java]
        spellViewModel.getAllSpells()
        spellObservers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSpellRecyclerView()
    }

    private fun spellObservers() {
        spellViewModel.getSpellResponse()
            .observe(viewLifecycleOwner, Observer { spells ->
                if (spells.isNotEmpty()) {
                    spellRecyclerViewAdapter.updateDataSet(
                        assignViewHolderType(
                            spells,
                            ViewHolderType.ALL_SPELLS
                        )
                    )
                }
            })
    }

    private fun setUpSpellRecyclerView() {
        spellRecyclerViewAdapter = RecyclerViewAdapterCustom(arrayListOf())
        spellLinearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        hogwartsRV.adapter = spellRecyclerViewAdapter
        hogwartsRV.layoutManager = spellLinearLayoutManager
    }
}