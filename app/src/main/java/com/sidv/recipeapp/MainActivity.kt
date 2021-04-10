package com.sidv.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.gestures.Scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScrollableColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    bitmap = imageFromResource(
                        res = resources,
                        resId = R.drawable.howcuttingdo
                    ),
                    contentDescription = "image",
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                )
                {
                    Text(
                        text = "This is some text",
                        style = TextStyle(
                            fontSize = 26.sp,
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Text(
                        text = "This is some text",
                        style = TextStyle(
                            color = Color(0xFF85bb65)
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(text = "This is some text")
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "SUBMIT")
                    }
                }
            }
        }
    }

}