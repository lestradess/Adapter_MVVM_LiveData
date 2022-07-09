package com.lestrades.adapter_mvvm_livedata

data class ItemEntity(
    var id: Long,
    var text: String,
    var isFavorite: Boolean = false)
