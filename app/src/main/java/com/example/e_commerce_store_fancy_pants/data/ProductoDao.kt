package com.example.e_commerce_store_fancy_pants.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.e_commerce_store_fancy_pants.model.Producto

@Dao
interface ProductoDao {
    @Query("SELECT * FROM PRODUCTO")
    fun getAllData() : LiveData<List<Producto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProducto(producto: Producto)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateProducto(producto: Producto)

    @Delete
    suspend fun deleteProducto(producto: Producto)
}