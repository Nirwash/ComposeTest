package com.nirwashh.android.composetest

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemColumn(item: ItemColumnModel) {
    val colorTitle = remember {
        mutableStateOf(Color.Gray)
    }
    val colorContent = remember {
        mutableStateOf(Color.White)
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(3.dp)
            .clickable {
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
                colorTitle.value = Color(random, random2, random3, random4)
            }
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp
                )
        ) {
            Text(text = item.title, color = colorTitle.value, fontSize = 20.sp)
            Text(
                modifier = Modifier
                    .clickable {
                        isExpanded = !isExpanded
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
                        colorContent.value = Color(random, random2, random3, random4)
                    },
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                text = item.content, color = colorContent.value, fontSize = 16.sp
            )
        }

    }

}