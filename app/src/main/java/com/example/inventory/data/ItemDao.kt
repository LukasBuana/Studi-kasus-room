
package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventory.data.Item
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {
    /**
     * Fungsi ini digunakan untuk menambahkan item baru ke database. Jika item dengan ID yang sama sudah ada,
     * maka item tersebut akan diabaikan karena menggunakan strategi konflik IGNORE
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    /**
     * Fungsi ini meng-update data item yang sudah ada di database.
     * Data item yang sesuai akan diperbarui dengan nilai baru yang diberikan
     */
    @Update
    suspend fun update(item: Item)


    /**
     * Fungsi ini menghapus item dari database sesuai dengan data item yang diberikan.
     */
    @Delete
    suspend fun delete(item: Item)


    /**
     * Fungsi ini mengambil item tertentu berdasarkan id dari database.
     * Hasilnya dikembalikan sebagai aliran (Flow) data Item, yang memungkinkan pembaruan
     * data secara real-time.
     */
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>


    /**
     * Fungsi ini mengambil semua item dalam database, diurutkan berdasarkan nama secara ascending (menaik).
     * Hasilnya dikembalikan sebagai Flow dari daftar item, yang terus diperbarui
     * setiap kali ada perubahan pada data.
     */
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>



}