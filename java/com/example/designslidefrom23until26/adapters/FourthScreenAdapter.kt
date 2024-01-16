package com.example.designslidefrom23until26.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.designslidefrom23until26.R
import com.example.designslidefrom23until26.databinding.ItemForTheFourthScreenBinding
import com.example.designslidefrom23until26.users_and_items.ItemForTheFourthScreen


class FourthScreenAdapter:
    ListAdapter<ItemForTheFourthScreen, FourthScreenAdapter.ItemHolder>(ItemsComparator()) {


    class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemForTheFourthScreenBinding.bind(view)


        /** Проверяем, если это 1ый элемент (с 2мя маленькими прямоугольниками справа), то заполняем
         * его цветами.
         * Если это 2ой элемент (с 2мя маленькими прямоугольниками слева) - то заполняем его цветами.
         * И используем соответствующую разметку, а ненужую прячем.
         */
        fun setData(item: ItemForTheFourthScreen) = with(binding) {

            if (item.firstItem == true) {
                constrLayFirstItem.visibility = View.VISIBLE
                constrLaySecondItem.visibility = View.GONE
                linearLayFirstColor.setBackgroundColor(item.color1)
                linearLaySecondColor.setBackgroundColor(item.color2)
                linearLayThirdColor.setBackgroundColor(item.color3)
                linearLayFourthColor.setBackgroundColor(item.color4)
            }

            if (item.secondItem == true) {
                constrLayFirstItem.visibility = View.GONE
                constrLaySecondItem.visibility = View.VISIBLE
                linearLay5Color.setBackgroundColor(item.color1)
                linearLay6Color.setBackgroundColor(item.color2)
                linearLay7Color.setBackgroundColor(item.color3)
                linearLay8Color.setBackgroundColor(item.color4)
            }
        }
    }


    class ItemsComparator: DiffUtil.ItemCallback<ItemForTheFourthScreen>() {

        override fun areItemsTheSame(oldItem: ItemForTheFourthScreen, newItem: ItemForTheFourthScreen): Boolean {
            return oldItem.itemNumber == newItem.itemNumber
        }

        override fun areContentsTheSame(oldItem: ItemForTheFourthScreen, newItem: ItemForTheFourthScreen): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_for_the_fourth_screen, parent, false)

        return ItemHolder(view)
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }
}