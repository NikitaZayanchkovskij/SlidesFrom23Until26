package com.example.designslidefrom23until26.fragments


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designslidefrom23until26.adapters.FourthScreenAdapter
import com.example.designslidefrom23until26.databinding.FourthFragmentNewsBinding
import com.example.designslidefrom23until26.users_and_items.ItemForTheFourthScreen


class FourthFragmentNews: Fragment() {
    private lateinit var binding: FourthFragmentNewsBinding
    private val adapter = FourthScreenAdapter()
    private lateinit var itemsToDisplay: ArrayList<ItemForTheFourthScreen>
    private var generateFirstItem = true
    private var generateSecondItem = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FourthFragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generate20Elements()
        initRecyclerView()
    }


    /** Функция генерирует 20 элементов.
     * ВАЖНО!
     * Если за один элемент считать 4 прямоугольника (3 верхних и один нижний), то здесь написано
     * правильно.
     * Если за один элемент считать 8 прямоугольников (3 верхних + 1 ниже + ещё 3 и + ещё 1), то
     * цикл нужно запустить 20 раз, а не 10.
     * Я посчитал за один элемент 4 прямоугольника, поэтому запускаю 10 раз.
     */
    private fun generate20Elements() {
        val generatedItemsList = arrayListOf<ItemForTheFourthScreen>()

        for (i in 1..10) {

            /* Это проверка, и проверка ниже, нужны для того, чтобы в FourthScreenAdapter правильно
             * заполнить цветами прямоугольники.
             */
            if (generateFirstItem == true) {
                val item1 = ItemForTheFourthScreen(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE,
                    generateFirstItem, generateSecondItem)
                val itemToAdd = item1.copy(itemNumber = i)
                generatedItemsList.add(itemToAdd)
                generateFirstItem = false
                generateSecondItem = true
            }

            if (generateSecondItem == true) {
                val item1 = ItemForTheFourthScreen(Color.GRAY, Color.MAGENTA, Color.CYAN, Color.DKGRAY,
                    generateFirstItem, generateSecondItem)
                val itemToAdd = item1.copy(itemNumber = i)
                generatedItemsList.add(itemToAdd)
                generateFirstItem = true
                generateSecondItem = false
            }
        }

        itemsToDisplay = generatedItemsList
    }


    private fun initRecyclerView() = with(binding) {
        rcViewFourthScreen.layoutManager = LinearLayoutManager(activity)
        rcViewFourthScreen.adapter = adapter
        adapter.submitList(itemsToDisplay)
    }


}