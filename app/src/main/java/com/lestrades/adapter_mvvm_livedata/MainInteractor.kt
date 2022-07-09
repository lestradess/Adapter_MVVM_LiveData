package com.lestrades.adapter_mvvm_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.concurrent.thread

class MainInteractor {
    val items: MutableLiveData<MutableList<ItemEntity>> = MutableLiveData()

    init {
        items.value = mutableListOf()
    }

    fun addItem(itemEntity: ItemEntity) {
        items.value?.let {
            val newData: MutableList<ItemEntity> = mutableListOf(itemEntity)
            newData.addAll(it)
            items.value = newData
        }
    }

    fun updateItem(itemEntity: ItemEntity){
        items.value?.let {
            val index = it.indexOf(itemEntity)
            it.set(index, itemEntity)
        }
    }
}