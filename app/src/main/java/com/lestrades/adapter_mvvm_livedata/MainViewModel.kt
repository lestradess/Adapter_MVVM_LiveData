package com.lestrades.adapter_mvvm_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var interactor = MainInteractor()

    val items = interactor.items

    val errorMsg: MutableLiveData<String> = MutableLiveData()

    fun addItem(itemEntity: ItemEntity){
        try {
            interactor.addItem(itemEntity)
        } catch (e: Exception) {
            errorMsg.value = e.message
        }
    }

    fun updateItem(itemEntity: ItemEntity){
        try {
            interactor.updateItem(itemEntity)
        } catch (e: Exception) {
            errorMsg.value = e.message
        }
    }
}