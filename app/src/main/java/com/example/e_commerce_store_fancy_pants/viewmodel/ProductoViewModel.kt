package com.example.e_commerce_store_fancy_pants.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.e_commerce_store_fancy_pants.data.ProductoDatabase
import com.example.e_commerce_store_fancy_pants.model.Producto
import com.example.e_commerce_store_fancy_pants.repository.ProductoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductoViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData : LiveData<List<Producto>>

    private val repository : ProductoRepository

    init {
        val productoDao = ProductoDatabase.getDatabase(application).productoDao()
        repository = ProductoRepository(productoDao)
        getAllData = repository.getAllData
    }

    fun addProducto(producto: Producto){
        viewModelScope.launch(Dispatchers.IO) { repository.addProducto(producto) }
    }

    fun updateProducto(producto: Producto){
        viewModelScope.launch(Dispatchers.IO) { repository.updateProducto(producto) }
    }

    fun deleteProducto(producto: Producto){
        viewModelScope.launch(Dispatchers.IO) { repository.deleteProducto(producto) }
    }
}