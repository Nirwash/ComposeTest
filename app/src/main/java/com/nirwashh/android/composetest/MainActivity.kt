package com.nirwashh.android.composetest

import android.content.Context
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.nirwashh.android.composetest.ui.theme.ComposeTestTheme
import com.nirwashh.android.composetest.ui.theme.Purple200
import com.nirwashh.android.composetest.ui.theme.Purple500
import com.nirwashh.android.composetest.ui.theme.Purple700
import org.json.JSONObject

const val API_KEY = "e2db139856044a4981552101223107"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                ShowWeather("Moscow", this@MainActivity)
                Row {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(end = 8.dp)
                    ) {
                        itemsIndexed(
                            listOf(
                                ItemColumnModel(
                                    R.drawable.click_me,
                                    "Cat 1",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon,
                                    "Cat 2 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon2,
                                    "Cat 3 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.click_me,
                                    "Cat 4 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon,
                                    "Cat 5 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon2,
                                    "Cat 6 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.click_me,
                                    "Cat 7 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon,
                                    "Cat 8 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon2,
                                    "Cat 9 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.click_me,
                                    "Cat 10 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon,
                                    "Cat 11 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon2,
                                    "Cat 12 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.click_me,
                                    "Cat 13 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon,
                                    "Cat 14 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon2,
                                    "Cat 15 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.click_me,
                                    "Cat 16 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon,
                                    "Cat 17 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon2,
                                    "Cat 18 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.click_me,
                                    "Cat 19 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon,
                                    "Cat 20 ",
                                    getString(R.string.text)
                                ),
                                ItemColumnModel(
                                    R.drawable.moon2,
                                    "Cat 21 ",
                                    getString(R.string.text)
                                )
                            )
                        ) { _, item ->
                            ItemColumn(item = item)
                        }
                    }
                    LazyRow {
                        items(2) {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(end = 8.dp)
                            ) {
                                items(count = 100) {
                                    CircleButton(it)
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
fun CircleButton(text: Int) {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.Gray)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
            .padding(top = 4.dp, bottom = 4.dp)
            .background(
                color = color.value,
                shape = CircleShape,

                )
            .clickable {
                counter.value++
                val random = (0..255)
                    .shuffled()
                    .last()
                val random2 = (0..255)
                    .shuffled()
                    .last()
                val random3 = (0..255)
                    .shuffled()
                    .last()
                val random4 = (80..250)
                    .shuffled()
                    .last()
                color.value = Color(random, random2, random3, random4)


            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = text.toString())
    }
}


@Composable
fun ListItem(name: Int) {
    val counter = remember {
        mutableStateOf(0)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .clickable {
                Log.d("MainActivity", "Click")
                counter.value++
            },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.click_me),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = name.toString())
                    Text(text = counter.value.toString())
                }
            }
        }
    }
}

@Composable
fun ShowWeather(city: String, context: Context) {
    val state = remember {
        mutableStateOf("Unknown")
    }
    var value by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sun),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(45.dp)
                        .clip(CircleShape)
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(0.5f)
                ) {
                    Column {
                        TextField(
                            value = value,
                            onValueChange = { value = it },
                            label = { Text("Enter city") },
                            maxLines = 1,
                            textStyle = TextStyle(color = Color.Blue),
                        )
                        Text(text = "Temp ${state.value}° C")
                    }

                }
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .size(60.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_refresh),
                        contentDescription = "Image",
                        modifier = Modifier
                            .padding(5.dp)
                            .size(35.dp)
                            .clip(CircleShape)
                            .clickable {
                                getWeather(value, state, context)
                            },
                        contentScale = ContentScale.Crop,
                        alpha = 0.75f
                    )
                }
            }
        }
    }

}

private fun getWeather(city: String, state: MutableState<String>, context: Context) {
    val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY" +
            "&q=$city" +
            "&aqi=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val obj = JSONObject(response)
            val temp = obj.getJSONObject("current")
            state.value = temp.getString("temp_c")
            Log.d("MainActivity", "Response: ${temp.getString("temp_c")}")
        },
        {
            Log.d("MainActivity", "Volley error $it")
        })
    queue.add(stringRequest)

}



