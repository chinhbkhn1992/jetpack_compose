package com.example.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newscompose.ui.theme.NewsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var enable1 = rememberSaveable { mutableStateOf(false) }
            val text = rememberSaveable {
                mutableStateOf("")
            }
            var listItem =
                rememberSaveable { mutableStateOf((1..10000).toList().map { it.toString() }) }
            NewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Greeting("Android")
                        Text(text = "Tao la tao")
                        BasicTextField(
                            value = text.value, onValueChange = {
                                text.value = it
                            },
                            Modifier
                                .border(
                                    width = 2.dp,
                                    color = Color.Red,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(4.dp)
                        )
                        TextButton(
                            onClick = {

                            },
                            enabled = text.value.length > 6,
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Yellow,
                                containerColor = Color.Red,
                                disabledContentColor = Color.Gray
                            )
                        ) {
                            Text("Increase")
                        }
                        LazyColumn(modifier = Modifier.fillMaxHeight(200f)) {
                            listItem.value.map {
                                item {
                                    Text(text = it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsComposeTheme {
        Greeting("Android")
    }
}