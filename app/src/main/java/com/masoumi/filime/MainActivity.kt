package com.masoumi.filime

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.masoumi.filime.ui.composable.MenuIntro
import com.masoumi.filime.ui.composable.OnClick
import com.masoumi.filime.ui.composable.WideButtonWithClickCallback
import com.masoumi.filime.ui.theme.FilimeTheme
import com.masoumi.filime.unit1.UnitOneMenu
import com.masoumi.filime.unit2.CalculateTip
import com.masoumi.filime.unit3.AffirmationList
import com.masoumi.filime.unit4.UnitFourMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ContentList(onButtonClick =
                    {
                        var intent: Intent? = null
                        when (it) {
                            1 -> intent = Intent(this, UnitOneMenu::class.java)
                            2 -> intent = Intent(this, CalculateTip::class.java)
                            3 -> intent = Intent(this, AffirmationList::class.java)
                            4 -> intent = Intent(this, UnitFourMenu::class.java)
                            5 -> {}
                            6 -> {}
                            7 -> {}
                            8 -> {}
                            else -> {
                                // Do nothing, this shouldn't happen
                            }
                        }
                        intent?.let { startActivity(it) }
                    })
                }
            }
        }
    }
}

@Composable
fun ContentList(
    onButtonClick: OnClick
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            RectangularIntroImage()
            MenuIntro(
                modifier = Modifier, text = stringResource(id = R.string.introduction)
            )
            WideButtonsList(onButtonClick = onButtonClick)
        }

    }
}

@Composable
fun RectangularIntroImage() {
    Image(
        painterResource(R.drawable.jetpack_logo),
        contentDescription = stringResource(id = R.string.jetpack_compose_logo_description),
        modifier = Modifier.fillMaxWidth(0.5f)
    )
}

@Composable
fun WideButtonsList(
    onButtonClick: OnClick
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_one),
            onClick = onButtonClick,
            id = 1
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_two),
            onClick = onButtonClick,
            id = 2
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_three),
            onClick = onButtonClick,
            id = 3
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_four),
            onClick = onButtonClick,
            id = 4
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_five),
            onClick = onButtonClick,
            id = 5
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_six),
            onClick = onButtonClick,
            id = 6
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_seven),
            onClick = onButtonClick,
            id = 7
        )
        WideButtonWithClickCallback(
            title = stringResource(id = R.string.unit_eight),
            onClick = onButtonClick,
            id = 8
        )
    }
}


