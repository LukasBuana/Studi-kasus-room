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
package com.example.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.inventory.ui.theme.InventoryTheme

class MainActivity : ComponentActivity() {

    /*
     * Fungsi `onCreate` dipanggil saat `MainActivity` pertama kali dibuat.
     * Di sini, kita menginisialisasi UI aplikasi dan mengatur tampilan tema menggunakan Jetpack Compose.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Mengaktifkan mode Edge-to-Edge, memungkinkan aplikasi menggunakan seluruh area layar, termasuk di bawah status bar dan navigation bar
        enableEdgeToEdge()

        // Memanggil metode `super.onCreate` untuk melanjutkan proses pembuatan activity
        super.onCreate(savedInstanceState)

        // Mengatur tampilan konten UI menggunakan Jetpack Compose
        setContent {
            // Menggunakan tema aplikasi `InventoryTheme` untuk menampilkan elemen UI
            InventoryTheme {
                // Membuat container `Surface` yang menggunakan warna latar belakang dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Mengatur container untuk mengisi seluruh ukuran layar
                    color = MaterialTheme.colorScheme.background // Mengatur warna latar dari skema warna tema
                ) {
                    // Memanggil `InventoryApp`, yang berisi seluruh composable utama aplikasi
                    InventoryApp()
                }
            }
        }
    }
}