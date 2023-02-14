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
fun WideButtonWithClickCallback(title: String, onClick: ClickCallback) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), onClick = onClick
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

typealias ClickCallback = () -> Unit