package com.example.designslidefrom23until26.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designslidefrom23until26.adapters.FirstAndFifthScreenAdapter
import com.example.designslidefrom23until26.databinding.FirstFragmentFavouritesBinding
import com.example.designslidefrom23until26.users_and_items.User


class FirstFragmentFavourites(private val userList: ArrayList<User>): Fragment() {
    private lateinit var binding: FirstFragmentFavouritesBinding
    private val adapter = FirstAndFifthScreenAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FirstFragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }


    private fun initRecyclerView() = with(binding) {
        rcViewFirstScreen.layoutManager = LinearLayoutManager(activity)
        rcViewFirstScreen.adapter = adapter
        adapter.submitList(userList)
    }


}