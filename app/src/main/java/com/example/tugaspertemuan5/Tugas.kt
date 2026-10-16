package com.example.tugaspertemuan5

import android.media.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults


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

    //variabel untuk mengatur tampilan card
    var  cardTampil by remember { mutableStateOf(false) }
    var jumlahSubmit by remember { mutableStateOf(0) }

    LaunchedEffect(jumlahSubmit) {
        if (jumlahSubmit > 0) {
            cardTampil = true

            delay(
                context.resources.getInteger(
                    R.integer.card_duration
                ).toLong()
            )

            cardTampil = false
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(R.color.screen_bg)
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(R.drawable.laba),
                contentDescription = stringResource(
                    R.string.header_description
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .height(dimensionResource(R.dimen.header_height)),
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = dimensionResource(R.dimen.form_card_top),
                        start = dimensionResource(R.dimen.screen_padding),
                        end = dimensionResource(R.dimen.screen_padding)
                    )
                    .heightIn(
                        max = dimensionResource(R.dimen.form_max_height)
                    ),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.form_corner),
                    topEnd = dimensionResource(R.dimen.form_corner)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(R.color.form_white)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(R.dimen.card_elevation)
                )
            ) { }
        }
    }
}