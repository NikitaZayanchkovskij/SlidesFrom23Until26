package com.example.designslidefrom23until26.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.designslidefrom23until26.R
import com.example.designslidefrom23until26.databinding.ItemForTheThirdScreenBinding
import com.example.designslidefrom23until26.users_and_items.ItemForTheThirdScreen


private val iconArray = arrayOf(R.drawable.ic_my_doctor, R.drawable.ic_my_caremanager,
    R.drawable.ic_my_diagnosis, R.drawable.ic_therapy_plan, R.drawable.ic_remaining_pills,
    R.drawable.ic_my_orders)

private val textArray = arrayListOf("MY DOCTOR", "MY CARE-MANAGER", "MY DIAGNOSIS",
    "THERAPY PLAN", "REMAINING PILLS", "MY ORDERS")

private val colorArray = arrayListOf(
    Color.GRAY, Color.BLUE, Color.GREEN, Color.CYAN, Color.YELLOW, Color.MAGENTA)


class ThirdScreenAdapter:
    ListAdapter<ItemForTheThirdScreen, ThirdScreenAdapter.ItemHolder>(AllItemsComparator()) {


    class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemForTheThirdScreenBinding.bind(view)


        /** Цвет, текст и фон карточки находим по условию: остатком от деления позиции ячейки
         * на размер массива.
         */
        fun setData() = with(binding) {
            val iconPosition = adapterPosition % 6
            val icon = iconArray[iconPosition]
            imIcon.setImageResource(icon)

            val backgroundPosition = adapterPosition % 6
            val background = colorArray[backgroundPosition]
            cardView.setCardBackgroundColor(background)

            val textPosition = adapterPosition % 6
            val text = textArray[textPosition]
            tvText.text = text
        }
    }


    class AllItemsComparator: DiffUtil.ItemCallback<ItemForTheThirdScreen>() {

        override fun areItemsTheSame(oldItem: ItemForTheThirdScreen, newItem: ItemForTheThirdScreen): Boolean {
            return oldItem.itemNumber == newItem.itemNumber
        }

        override fun areContentsTheSame(oldItem: ItemForTheThirdScreen, newItem: ItemForTheThirdScreen): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_for_the_third_screen, parent, false)

        return ItemHolder(view)
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData()
    }
}