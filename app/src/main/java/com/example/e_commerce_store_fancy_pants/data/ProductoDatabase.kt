package com.example.e_commerce_store_fancy_pants.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_commerce_store_fancy_pants.model.Producto

@Database(entities = [Producto::class], version = 1, exportSchema = false)
abstract class ProductoDatabase : RoomDatabase() {
    abstract fun productoDao() : ProductoDao

    companion object{
        @Volatile
        private var INSTANCE : ProductoDatabase? = null

        fun getDatabase(context: android.content.Context) : ProductoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductoDatabase::class.java,
                    "producto_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}