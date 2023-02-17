package com.masoumi.filime.unit1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masoumi.filime.R
import com.masoumi.filime.ui.composable.OnClick
import com.masoumi.filime.ui.composable.WideButtonWithClickCallback
import com.masoumi.filime.ui.theme.FilimeTheme

class UnitOneMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ContentList(
                        onButtonClick = {
                            var intent: Intent? = null
                            when (it) {
                                1 -> intent = Intent(this, HappyBirthday::class.java)
                                2 -> intent = Intent(this, BusinessCard::class.java)
                                else -> {
                                    // Do nothing, this shouldn't happen
                                }
                            }
                            if (intent != null)
                                startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ContentList(onButtonClick: OnClick) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuIntro(modifier = Modifier.align(Alignment.CenterHorizontally))
        WideButtonList(onButtonClick = onButtonClick)
    }
}

@Composable
fun MenuIntro(modifier: Modifier) {
    Text(
        text = stringResource(id = R.string.unit_one_intro),
        textAlign = TextAlign.Justify,
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 24.dp, start = 24.dp, top = 16.dp),
        fontSize = 18.sp,
    )
}

@Composable
fun WideButtonList(onButtonClick: OnClick) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.birthday_card),
            onClick = onButtonClick,
            id = 1
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.business_card),
            onClick = onButtonClick,
            id = 2
        )
    }
}