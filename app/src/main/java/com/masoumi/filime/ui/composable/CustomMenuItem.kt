package com.masoumi.filime.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomMenuItem(onClick: () -> Unit, title: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), onClick = onClick
    ) {
        Text(
            title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}