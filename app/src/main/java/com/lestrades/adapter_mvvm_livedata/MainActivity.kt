package com.lestrades.adapter_mvvm_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lestrades.adapter_mvvm_livedata.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupRecyclerView()
        setupButton()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.items.observe(this,{
            adapter.submitList(it)
        })
        mainViewModel.errorMsg.observe(this,{
            Snackbar.make(binding.root, it,Snackbar.LENGTH_SHORT).show()
        })
    }


    private fun setupRecyclerView() {
        adapter = ItemAdapter(this)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    private fun setupButton() {
        binding.btnSave.setOnClickListener{
            val itemEntity = ItemEntity(Random.nextLong(),binding.etText.text.toString())
            mainViewModel.addItem(itemEntity)
        }
    }

    override fun onClick(itemEntity: ItemEntity) {
        mainViewModel.updateItem(itemEntity)
    }
}