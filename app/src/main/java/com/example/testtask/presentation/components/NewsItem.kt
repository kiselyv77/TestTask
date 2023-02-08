package com.example.testtask.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun NewsItem(
    title: String,
    description: String,
    imageUrl: String
) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(3))
            .clickable { }) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title, fontSize = 25.sp
            )
            AsyncImage(
                model = imageUrl,
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
            )
            Text(
                text = description, fontSize = 20.sp
            )
        }

    }
}