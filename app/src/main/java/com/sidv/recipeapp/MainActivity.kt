package com.sidv.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "This is some text")
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "SUBMIT")
                }
            }
        }
    }

}