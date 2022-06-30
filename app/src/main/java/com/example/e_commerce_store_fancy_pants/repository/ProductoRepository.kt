package com.example.e_commerce_store_fancy_pants.repository

import androidx.lifecycle.LiveData
import com.example.e_commerce_store_fancy_pants.data.ProductoDao
import com.example.e_commerce_store_fancy_pants.model.Producto

class ProductoRepository(private val productoDao: ProductoDao) {
    val getAllData: LiveData<List<Producto>> = productoDao.getAllData()

    suspend fun addProducto(producto: Producto){
        productoDao.addProducto(producto)
    }

    suspend fun updateProducto(producto: Producto){
        productoDao.updateProducto(producto)
    }

    suspend fun deleteProducto(producto: Producto){
        productoDao.deleteProducto(producto)
    }
}