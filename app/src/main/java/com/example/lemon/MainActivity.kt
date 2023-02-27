package com.example.lemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemon.ui.theme.LemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Limoncio()
                }
            }
        }
    }
}

@Composable
fun HacerLimonada() {
    var result by remember { mutableStateOf( 10) }
    val imageResource = when(result) {
        10 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_drink
        1 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_squeeze
    }
    val strResource = when (result) {
        10 -> R.string.limonArbol
        2 -> R.string.limon
        1 -> R.string.limonVasio
        else -> R.string.limonVasio
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {
        Text(text = stringResource(strResource))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result = result--
            if (result < 1) result = 10
        }) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(strResource)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Limoncio() {
    LemonTheme {
        HacerLimonada()
    }
}