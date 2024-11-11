/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import android.content.Context

/*
 * Interface `AppContainer` digunakan sebagai wadah untuk dependency injection.
 * Interface ini berisi satu properti, yaitu `itemsRepository` yang mengacu pada `ItemsRepository`.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
}


/*
 * Kelas `AppDataContainer` adalah implementasi dari `AppContainer` yang bertanggung jawab
 * untuk menyediakan instance dari `OfflineItemsRepository` menggunakan `InventoryDatabase`.
 */
class AppDataContainer(private val context: Context) : AppContainer {

    /*
    * Properti `itemsRepository` mengimplementasikan `ItemsRepository`.
    * `by lazy` memastikan bahwa `OfflineItemsRepository` hanya akan dibuat saat pertama kali diakses.
    * Menggunakan `InventoryDatabase.getDatabase(context).itemDao()` untuk mendapatkan `itemDao`
    * yang dibutuhkan oleh `OfflineItemsRepository`.
    */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
