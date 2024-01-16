package com.example.designslidefrom23until26.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.designslidefrom23until26.adapters.ThirdScreenAdapter
import com.example.designslidefrom23until26.databinding.ThirdFragmentPlacesBinding
import com.example.designslidefrom23until26.users_and_items.ItemForTheThirdScreen


class ThirdFragmentPlaces: Fragment() {
    private lateinit var binding: ThirdFragmentPlacesBinding
    private val adapter = ThirdScreenAdapter()
    private lateinit var itemsToDisplay: ArrayList<ItemForTheThirdScreen>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ThirdFragmentPlacesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generate20Elements()
        initRecyclerView()
    }


    /** Функция генерирует 20 item-ов, для отображения на экране.
     */
    private fun generate20Elements() {
        val generatedItemsList = arrayListOf<ItemForTheThirdScreen>()

        for (i in 1..20) {
            val item = ItemForTheThirdScreen()
            val itemToAdd = item.copy(itemNumber = i)
            generatedItemsList.add(itemToAdd)
        }

        itemsToDisplay = generatedItemsList
    }


    private fun initRecyclerView() = with(binding) {
        rcViewThirdScreen.layoutManager = GridLayoutManager(activity, 2)
        rcViewThirdScreen.adapter = adapter
        adapter.submitList(itemsToDisplay)
    }


}