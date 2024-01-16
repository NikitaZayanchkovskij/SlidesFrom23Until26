package com.example.designslidefrom23until26.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designslidefrom23until26.adapters.SecondScreenAdapter
import com.example.designslidefrom23until26.databinding.SecondFragmentMusicBinding
import com.example.designslidefrom23until26.users_and_items.User


class SecondFragmentMusic(private val userList: ArrayList<User>): Fragment() {
    private lateinit var binding: SecondFragmentMusicBinding
    private val adapter = SecondScreenAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = SecondFragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }


    private fun initRecyclerView() = with(binding) {
        rcViewSecondScreen.layoutManager = LinearLayoutManager(activity)
        rcViewSecondScreen.adapter = adapter
        adapter.submitList(userList)
    }



}