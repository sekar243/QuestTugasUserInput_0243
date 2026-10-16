package com.example.tugaspertemuan5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun  FormBiodata(modifier: Modifier) {
    val context = LocalContext.current

    //variabel untuk menyimapan input dari keyboard
    val textNamaDepan by remember { mutableStateOf("") }
    val  textNamaBelakang by remember { mutableStateOf("") }
    val  textEmail by remember { mutableStateOf("") }
    val textTanggal by remember { mutableStateOf("") }
    val textExperience by remember { mutableStateOf("") }

    //variabel untuk menyimapan pilihan skill
    val textAndroid by remember { mutableStateOf("") }
    val textUIUX by remember { mutableStateOf("") }
    val textWeb by remember { mutableStateOf("") }

    //variabel untuk mengatur pilihan tanggal dan pengalaman
    val dropdownBuka by remember { mutableStateOf("") }
    val datePickerBuka by remember { mutableStateOf("") }

    //variabel untuk menyimpan data hasil submit
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf("") }
}