package com.mobile.customprogress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.customprogress.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = GroupAdapter<GroupieViewHolder>()

        adapter.add(ItemImageView(R.drawable.ic_submitted,R.drawable.bg_rectangle,this,1))
        adapter.add(ItemImageView(R.drawable.baseline_currency_rupee_24,R.drawable.bg_rectangle,this,2,"S"))
        adapter.add(ItemImageView(R.drawable.ic_demo_completed,R.drawable.bg_rectangle,this,3))
        adapter.add(ItemImageView(R.drawable.ic_ruppie,R.drawable.bg_rectangle,this,4,"S"))
        adapter.add(ItemImageView(R.drawable.ic_payment_recieved,null,this,5))
        binding.rvImage.adapter = adapter
    }
}