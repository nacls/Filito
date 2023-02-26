package com.masoumi.filime.unit4

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.masoumi.filime.R
import com.masoumi.filime.ui.composable.MenuIntro
import com.masoumi.filime.ui.composable.OnClick
import com.masoumi.filime.ui.theme.FilimeTheme
import com.masoumi.filime.unit1.BusinessCard
import com.masoumi.filime.unit1.HappyBirthday

class UnitFourMenu : ComponentActivity() {
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
                                1 -> {}
                                else -> {
                                    // Do nothing, this shouldn't happen
                                }
                            }
                            intent?.let { startActivity(it) }
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
        MenuIntro(modifier = Modifier.align(Alignment.CenterHorizontally),
            stringResource(id = R.string.unit_four_intro))
        WideButtonList(onButtonClick = onButtonClick)
    }
}

@Composable
fun WideButtonList(onButtonClick: OnClick) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

    }
}