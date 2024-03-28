package com.example.latihan_7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihan_7.databinding.ItemUserBinding
import com.example.latihan_7.model.DataItem
import com.example.latihan_7.model.User

class UserAdapter(
    private var userList: List<DataItem>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    inner class UserViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: DataItem){
            binding.tvName.text = "${user.firstName} ${user.lastName}"
            binding.tvEmail.text = user.email
            Glide.with(binding.root)
                .load(user.avatar)
                .into(binding.ivImg)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    fun setData(newList: List<DataItem>) {
        userList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

}