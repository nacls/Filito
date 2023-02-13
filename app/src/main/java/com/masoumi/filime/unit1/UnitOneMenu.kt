package com.masoumi.filime.unit1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masoumi.filime.R
import com.masoumi.filime.ui.theme.FilimeTheme

class UnitOneMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContentList(onBirthdayCardClick = {
                        val intent = Intent(this, HappyBirthday::class.java)
                        startActivity(intent)
                    }, onBusinessCardClick = {
                        val intent = Intent(this, BusinessCard::class.java)
                        startActivity(intent)
                    })
                }
            }
        }
    }
}

@Composable
fun ContentList(onBirthdayCardClick: () -> Unit, onBusinessCardClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.unit_one_intro),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp, top = 16.dp),
            fontSize = 18.sp,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), onClick = {
                onBirthdayCardClick()
            }) {
                Text(
                    stringResource(id = R.string.birthday_card),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), onClick = {
                onBusinessCardClick()
            }) {
                Text(
                    stringResource(id = R.string.business_card),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}