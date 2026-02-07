package com.example.lab_1_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    // Используем Column для центрирования всего контента на экране (адаптивность)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Верхняя часть: Лого, Имя, Группа
        MainInfoSection()

        // Нижняя часть: Контакты
        ContactSection()
    }
}

@Composable
fun MainInfoSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(

            painter = painterResource(id = R.drawable.my_photo),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.logo_size))
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = R.string.full_name),
            fontSize = dimensionResource(id = R.dimen.text_size_name).value.sp,

            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.student_group),
            fontSize = dimensionResource(id = R.dimen.text_size_info).value.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactSection() {
    Column {
        ContactItem(icon = Icons.Default.Phone, text = stringResource(id = R.string.contact_phone))
        ContactItem(icon = Icons.Default.Email, text = stringResource(id = R.string.contact_email))
        ContactItem(icon = Icons.Default.Info, text = stringResource(id = R.string.contact_telegram))
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size))
        )
        Text(
            text = text,
            fontSize = dimensionResource(id = R.dimen.text_size_info).value.sp,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
        )
    }
}