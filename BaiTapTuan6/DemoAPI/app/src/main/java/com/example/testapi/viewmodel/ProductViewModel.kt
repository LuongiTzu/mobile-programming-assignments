package com.example.smarttasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarttasks.data.model.Product
import com.example.smarttasks.data.remote.RetrofitInstance
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class ProductViewModel : ViewModel() {

    private val _product = mutableStateOf<Product?>(null)
    val product: State<Product?> = _product

    init {
        fetchProduct()
    }

    private fun fetchProduct() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProduct()
                _product.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
