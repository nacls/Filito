package com.masoumi.filime.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masoumi.filime.R
import com.masoumi.filime.ui.theme.FilimeTheme
import com.masoumi.filime.ui.theme.Shapes
import com.masoumi.filime.unit3.data.Datasource
import com.masoumi.filime.unit3.model.Affirmation

class AffirmationList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilimeTheme {
                Scaffold(
                    topBar = {
                        AffirmationTopAppBar()
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colors.background
                    ) {
                        AffirmationList(affirmationList = Datasource().loadAffirmations())
                    }
                }
            }
        }
    }
}

@Composable
private fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation)
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(8.dp)
            .clip(Shapes.medium)
            .background(MaterialTheme.colors.surface),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.animateContentSize(animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ))) {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(Shapes.medium),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(affirmation.stringResourceId),
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(20.0f, true),
                    style = MaterialTheme.typography.body1
                )
                ItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                    modifier = Modifier.weight(1.0f, false)
                )
            }
            if (expanded)
                AffirmationExpanded()

        }
    }
}

@Composable
private fun ItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = modifier,
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.primary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@Composable
fun AffirmationExpanded(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 4.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(R.string.says_who),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = stringResource(R.string.me),
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
fun AffirmationTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    ) {
        Image(
            modifier = Modifier.width(100.dp),
            painter = painterResource(R.drawable.affirmations),
            contentDescription = null,
            contentScale = ContentScale.Fit

        )
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationCardPreview() {
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
}