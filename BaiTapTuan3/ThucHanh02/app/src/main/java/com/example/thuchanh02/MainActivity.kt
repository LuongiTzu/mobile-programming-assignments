package com.example.thuchanh02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thuchanh02.ui.theme.ThucHanh02Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThucHanh02Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ManHinhHienThi()
                }
            }
        }
    }
}

@Composable
fun ManHinhHienThi() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logojet),
            contentDescription = "Jetpack Compose",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "Jetpack Compose!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.offset( y= -70.dp)
        )
        Button(
            onClick = {
            },

            modifier = Modifier.height(56.dp)
           .clip(RoundedCornerShape(50.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6E8CFB)),
            shape = RoundedCornerShape(15.dp)
        ) {

            Text(
                text = "I'm ready" ,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ThucHanh02Theme {
        ManHinhHienThi()
    }
}