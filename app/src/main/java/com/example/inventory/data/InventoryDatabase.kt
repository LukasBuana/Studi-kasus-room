package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Kode InventoryDatabase adalah kelas database Room untuk aplikasi inventaris,
 * yang mendefinisikan database dengan entitas Item dan menyediakan akses ke ItemDao untuk operasi CRUD.
 * Kelas ini memastikan hanya satu instance database yang digunakan di seluruh aplikasi.
 * Jika versi database berubah tanpa migrasi, fallbackToDestructiveMigration() akan menghapus dan
 * membuat ulang database secara otomatis.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null
        fun getDatabase(context: Context): InventoryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }

    }
}
