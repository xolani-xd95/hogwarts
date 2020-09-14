package com.example.hogwarts.ui.houses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts.MainActivity
import com.example.hogwarts.R
import com.example.hogwarts.network.dto.SpellDTO
import com.example.hogwarts.utils.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_hogwarts.*

class HousesFragment : Fragment() {

    // ViewModel
    private lateinit var houseViewModel: HousesViewModel

    // RecyclerView
    private lateinit var houseRecyclerViewAdapter: RecyclerViewAdapter<SpellDTO>
    private lateinit var houseLinearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? MainActivity)?.setFragmentActionBar("Houses")
        return inflater.inflate(
            R.layout.fragment_hogwarts,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        houseViewModel = ViewModelProvider(this)[HousesViewModel::class.java]
        houseViewModel.getAllHouses()
        houseObservables()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSpellRecyclerView()
    }

    private fun houseObservables() {
//        houseViewModel.getAllHouseResponse()
//            .observe(viewLifecycleOwner, Observer { houses ->
//                if (houses.isNotEmpty()) {
//                    houseRecyclerViewAdapter.updateRecyclerViewData(
//                        assignViewHolderType(
//                            houses,
//                            ViewHolderType.ALL_HOUSES
//                        )
//                    )
//                }
//            })
    }

    private fun setUpSpellRecyclerView() {
        houseRecyclerViewAdapter = RecyclerViewAdapter(arrayListOf())
        houseLinearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        hogwartsRV.adapter = houseRecyclerViewAdapter
        hogwartsRV.layoutManager = houseLinearLayoutManager
    }
}