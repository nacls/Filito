package com.masoumi.filime.unit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masoumi.filime.R
import com.masoumi.filime.ui.theme.FilimeTheme
import com.masoumi.filime.ui.theme.Orange700

class BusinessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyBusinessCard()
                }
            }
        }
    }
}

@Composable
fun MyBusinessCard() {
    Column(modifier = Modifier.fillMaxSize()) {
        GeneralInformation(modifier = Modifier.padding(top = 48.dp))
        ContactInformation(modifier = Modifier.padding(top = 36.dp))
    }
}

@Composable
fun GeneralInformation(modifier: Modifier) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularImage()
        BigCenteredText()
        OrangeCenteredText()
    }
}

@Composable
fun ContactInformation(modifier: Modifier) {
    val iconModifier = Modifier.padding(end = 4.dp)
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            ContactInformationItem(
                iconModifier,
                stringResource(R.string.phone_number),
                Icons.Filled.Phone
            )
            ContactInformationItem(
                iconModifier,
                stringResource(R.string.random_id),
                Icons.Filled.AccountBox
            )
            ContactInformationItem(iconModifier, stringResource(R.string.email), Icons.Filled.Email)
        }
    }

}

@Composable
fun ContactInformationItem(modifier: Modifier, value: String, icon: ImageVector) {
    Row() {
        Icon(imageVector = icon, stringResource(id = R.string.icon), modifier = modifier)
        Text(text = value)
    }
}
@Composable
fun CircularImage(){
    Image(
        painterResource(R.drawable.my_profile),
        contentDescription = stringResource(id = R.string.my_profile_description),
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .clip(CircleShape)
    )
}

@Composable
fun BigCenteredText(){
    Text(
        text = stringResource(id = R.string.my_full_name),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 24.dp, start = 24.dp, top = 16.dp),
        fontSize = 24.sp,
    )
}

@Composable
fun OrangeCenteredText(){
    Text(
        text = stringResource(id = R.string.my_title),
        textAlign = TextAlign.Center,
        color = Orange700,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 24.dp, start = 24.dp, top = 8.dp),
        fontSize = 18.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FilimeTheme {
        MyBusinessCard()
    }
}