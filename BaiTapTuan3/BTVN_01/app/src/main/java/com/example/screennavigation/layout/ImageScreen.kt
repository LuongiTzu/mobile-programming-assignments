package com.example.screennavigation.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.screennavigation.R
import com.example.screennavigation.ui.theme.ScreenNavigationTheme
import androidx.compose.ui.draw.clip

@Composable
fun ImageScreen(onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp, vertical = 30.dp)) {

        Box(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.Blue,
                modifier = Modifier.align(Alignment.CenterStart).clickable { onBack() }
            )
            Text(
                text = "Images",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Blue
            )
        }

        Spacer(Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ảnh từ web
            AsyncImage(
                model = "https://tuyensinhhuongnghiep.vn/upload/images/2023/09/08/truong-dai-hoc-giao-thong-van-tai-tphcm.jpg",
                contentDescription = "From web",
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                error = painterResource(id = R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,//
                modifier = Modifier.fillMaxWidth().height(180.dp).clip(RoundedCornerShape(14.dp))
            )
            Text(
                text = "https://tuyensinhhuongnghiep.vn/upload/images/2023/09/08/truong-dai-hoc-giao-thong-van-tai-tphcm.jpg",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
            )

            Spacer(Modifier.height(50.dp))

            // Ảnh trong app (local)
            Image(
                painter = painterResource(id = R.drawable.uthne),
                contentDescription = "In app",
                modifier = Modifier.fillMaxWidth().height(180.dp).clip(RoundedCornerShape(14.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                "In app",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageScreenPreview() {
    ScreenNavigationTheme { ImageScreen(onBack = {}) }
}
