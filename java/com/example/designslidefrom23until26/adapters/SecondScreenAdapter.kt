package com.example.designslidefrom23until26.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.designslidefrom23until26.R
import com.example.designslidefrom23until26.databinding.ItemForTheSecondScreenBinding
import com.example.designslidefrom23until26.users_and_items.User

class SecondScreenAdapter:
    ListAdapter<User, SecondScreenAdapter.UserHolder>(AllUsersComparator()) {


    class UserHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemForTheSecondScreenBinding.bind(view)

        fun setData(user: User) = with(binding) {

            imAvatar.setImageResource(user.squareAvatarUrl)

            if (user.gender == "male") imGender.setImageResource(R.drawable.ic_male)
            else imGender.setImageResource(R.drawable.ic_female)

            val firstAndLastName = "${user.firstName} ${user.lastName}"

            tvFirstLastName.text = firstAndLastName
            tvAge.text = user.age
            tvDescription.text = user.description
        }
    }


    class AllUsersComparator: DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.userNumber == newItem.userNumber
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_for_the_second_screen, parent, false)

        return UserHolder(view)
    }


    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.setData(getItem(position))
    }
}