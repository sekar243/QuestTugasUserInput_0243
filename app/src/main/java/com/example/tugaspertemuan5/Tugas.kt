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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults


@Composable
fun  FormBiodata(modifier: Modifier) {
    val context = LocalContext.current

    //variabel untuk menyimapan input dari keyboard
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTanggal by remember { mutableStateOf("") }
    var textExperience by remember { mutableStateOf("") }

    //variabel untuk menyimapan pilihan skill
    var textAndroid by remember { mutableStateOf(false) }
    var textUIUX by remember { mutableStateOf(false) }
    var textWeb by remember { mutableStateOf(false) }

    //variabel untuk mengatur pilihan tanggal dan pengalaman
    var dropdownBuka by remember { mutableStateOf(false) }
    var datePickerBuka by remember { mutableStateOf(false) }

    //variabel untuk menyimpan data hasil submit
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf("") }

    //variabel untuk mengatur tampilan card
    var cardTampil by remember { mutableStateOf(false) }
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
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.form_padding)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.from_tittle),
                        fontSize = dimensionResource(
                            R.dimen.title_size
                        ).value.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.title_red)
                    )

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.small_spacing)
                        )
                    )

                    Text(
                        text = stringResource(R.string.from_subtitle),
                        fontSize = dimensionResource(
                            R.dimen.subtitle_size
                        ).value.sp,
                        color = colorResource(R.color.text_gray)
                    )
                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.content_spacing)
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.field_spacing)
                        )
                    ) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            onValueChange = { textNamaDepan = it },
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            label = {
                                Text(stringResource(R.string.nama_depan))
                            }
                        )
                        OutlinedTextField(
                            value = textNamaBelakang,
                            onValueChange = { textNamaBelakang = it },
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            label = {
                                Text(stringResource(R.string.nama_belakang))
                            }
                        )
                    }
                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.field_spacing)
                        )
                    )

                    OutlinedTextField(
                        value = textEmail,
                        onValueChange = { textEmail = it },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        label = {
                            Text(stringResource(R.string.email))
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.field_spacing)
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.field_spacing)
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = textTanggal,
                                onValueChange = {},
                                modifier = Modifier.fillMaxWidth(),
                                readOnly = true,
                                singleLine = true,
                                label = {
                                    Text(
                                        stringResource(R.string.tanggal_lahir)
                                    )
                                },
                                trailingIcon = {
                                    TextButton(
                                        onClick = {
                                            datePickerBuka = true
                                        }
                                    ) {
                                        Text(
                                            stringResource(R.string.pilih_tanggal)
                                        )
                                    }
                                }
                            )
                        }
                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = textExperience,
                                onValueChange = {},
                                modifier = Modifier.fillMaxWidth(),
                                readOnly = true,
                                singleLine = true,
                                label = {
                                    Text(
                                        stringResource(R.string.experience)
                                    )
                                },
                                trailingIcon = {
                                    TextButton(
                                        onClick = {
                                            dropdownBuka = true
                                        }
                                    ) {
                                        Text(
                                            stringResource(R.string.panah_dropdown)
                                        )
                                    }
                                }
                            )

                            DropdownMenu(
                                expanded = dropdownBuka,
                                onDismissRequest = {
                                    dropdownBuka = false
                                }
                            ) {
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            stringResource(
                                                R.string.experience_beginner
                                            )
                                        )
                                    },
                                    onClick = {
                                        textExperience = context.getString(
                                            R.string.experience_beginner
                                        )
                                        dropdownBuka = false
                                    }
                                )

                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            stringResource(
                                                R.string.experience_intermediate
                                        )
                                        )
                                    },
                                    onClick = {
                                        textExperience = context.getString(
                                            R.string.experience_intermediate
                                        )
                                        dropdownBuka = false
                                    }
                                )

                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            stringResource(
                                                R.string.experience_advanced
                                            )
                                        )
                                    },
                                    onClick = {
                                        textExperience = context.getString(
                                            R.string.experience_advanced
                                        )
                                        dropdownBuka = false
                                    }
                                )
                            }
                        }
                    }

                    if (datePickerBuka) {
                        val dateState = rememberDatePickerState()

                        DatePickerDialog(
                            onDismissRequest = {
                                datePickerBuka = false
                            },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        dateState.selectedDateMillis?.let {
                                            textTanggal = SimpleDateFormat(
                                                context.getString(
                                                    R.string.date_format
                                                ),
                                                Locale.getDefault()
                                            ).format(Date(it))
                                        }

                                        datePickerBuka = false
                                    }
                                ) {
                                    Text(stringResource(R.string.pilih))
                                }
                            },
                            dismissButton = {
                                TextButton(
                                    onClick = {
                                        datePickerBuka = false
                                    }
                                ) {
                                    Text(stringResource(R.string.batal))
                                }
                            }
                        ) {
                            DatePicker(state = dateState)
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.field_spacing)
                        )
                    )
                    Text(
                        text = stringResource(R.string.pilih_skill),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = dimensionResource(R.dimen.skill_title_size).value.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.text_primary)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = textAndroid,
                                onCheckedChange = { textAndroid = it }
                            )
                            Text(stringResource(R.string.skill_android))
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = textUIUX,
                                onCheckedChange = { textUIUX = it }
                            )
                            Text(stringResource(R.string.skill_uiux))
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = textWeb,
                                onCheckedChange = { textWeb = it }
                            )
                            Text(stringResource(R.string.skill_web))
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.content_spacing)
                        )
                    )


                    Button(
                        onClick = {
                            nama = "$textNamaDepan $textNamaBelakang"
                            email = textEmail
                            tanggal = textTanggal
                            experience = textExperience

                            val skills = mutableListOf<String>()

                            if (textAndroid) {
                                skills.add(
                                    context.getString(R.string.skill_android)
                                )
                            }

                            if (textUIUX) {
                                skills.add(
                                    context.getString(R.string.skill_uiux)
                                )
                            }

                            if (textWeb) {
                                skills.add(
                                    context.getString(R.string.skill_web)
                                )
                            }

                            skill = skills.joinToString(", ")
                            jumlahSubmit++
                        },
                        enabled = textNamaDepan.isNotBlank() &&
                                textNamaBelakang.isNotBlank() &&
                                textEmail.isNotBlank() &&
                                textTanggal.isNotBlank() &&
                                textExperience.isNotBlank() &&
                                (textAndroid || textUIUX || textWeb),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(R.dimen.button_height)),
                        shape = RoundedCornerShape(
                            dimensionResource(R.dimen.button_corner)
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.title_red),
                            disabledContainerColor =
                                colorResource(R.color.button_disabled)
                        )
                    ) {
                        Text(stringResource(R.string.proceed))
                    }


                }
                    }
                }
            }
        }

