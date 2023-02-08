package com.example.testtask.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtask.common.Constants

@Composable
fun QuerySwitch(
    clickApple: () -> Unit,
    clickTesla: () -> Unit,
    clickBitcoin: () -> Unit,
    currentQuery: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(modifier = Modifier
            .padding(16.dp)
            .clickable { clickApple() }
        ) {
            Text(
                "apple",
                fontSize = 25.sp,
                modifier = Modifier.background(color = if (currentQuery == Constants.query_Apple) Color.Gray else Color.Unspecified)
            )
        }
        Card(modifier = Modifier
            .padding(16.dp)
            .clickable { clickTesla() }
        )
        {
            Text(
                "tesla",
                fontSize = 25.sp,
                modifier = Modifier.background(color = if (currentQuery == Constants.query_Tesla) Color.Gray else Color.Unspecified)
            )
        }
        Card(modifier = Modifier
            .padding(16.dp)
            .clickable { clickBitcoin() }) {
            Text(
                "bitcoin",
                fontSize = 25.sp,
                modifier = Modifier.background(color = if (currentQuery == Constants.query_Bitcoin) Color.Gray else Color.Unspecified)
            )
        }
    }
}