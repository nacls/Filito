package com.masoumi.filime

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.masoumi.filime.ui.theme.FilimeTheme
import com.masoumi.filime.unit1.HappyBirthday

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ContentList(
                        onUnitOneClick = {
                            val intent = Intent(this, HappyBirthday::class.java)
                            startActivity(intent)
                        })
                }
            }
        }
    }
}

@Composable
fun ContentList(onUnitOneClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.jetpack_logo),
            contentDescription = stringResource(id = R.string.jetpack_compose_logo_description),
            modifier = Modifier.fillMaxWidth(0.5f)
        )
        Text(
            text = stringResource(id = R.string.introduction),
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
                onUnitOneClick()
            }) {
                Text(
                    stringResource(id = R.string.unit_one),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}