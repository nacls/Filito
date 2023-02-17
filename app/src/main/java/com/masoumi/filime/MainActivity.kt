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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masoumi.filime.ui.composable.OnClick
import com.masoumi.filime.ui.composable.WideButtonWithClickCallback
import com.masoumi.filime.ui.theme.FilimeTheme
import com.masoumi.filime.unit1.UnitOneMenu

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
                            2 -> {}
                            3 -> {}
                            4 -> {}
                            5 -> {}
                            6 -> {}
                            7 -> {}
                            else -> {
                                // Do nothing, this shouldn't happen
                            }
                        }
                        if (intent != null)
                            startActivity(intent)
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
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RectangularIntroImage()
        JustifiedIntroText(modifier = Modifier.align(Alignment.CenterHorizontally))
        WideButtonsList(onButtonClick = onButtonClick)
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
fun JustifiedIntroText(modifier: Modifier) {
    Text(
        text = stringResource(id = R.string.introduction),
        textAlign = TextAlign.Justify,
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 24.dp, start = 24.dp, top = 16.dp),
        fontSize = 18.sp,
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
    }
}


