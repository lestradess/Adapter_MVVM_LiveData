package com.lestrades.adapter_mvvm_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.concurrent.thread

class MainInteractor {
    val items: MutableLiveData<MutableList<Any>> = MutableLiveData()

    init {
        items.value = mutableListOf()
    }

    fun addItem(itemEntity: Any) {
        items.value?.let {
            val newData: MutableList<Any> = mutableListOf(itemEntity)
            newData.addAll(it)
            items.value = newData
        }
    }

    fun updateItem(itemEntity: Any){
        items.value?.let {
            val index = it.indexOf(itemEntity)
            it.set(index, itemEntity)
        }
    }
}