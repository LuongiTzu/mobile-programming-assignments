package com.example.screennavigation.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screennavigation.ui.theme.ScreenNavigationTheme
import androidx.compose.ui.graphics.Color
import com.example.screennavigation.ui.theme.ScriptFont

@Composable
fun TextScreen(onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 30.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable { onBack() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Blue,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = "Text Detail",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Blue
            )
        }

        // Demo text styles
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 300.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            val demo = buildAnnotatedString {
                append("The ")
                withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) { append("quick ") }
                withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = androidx.compose.ui.graphics.Color(0xFFB17200))) {
                    append("Brown")
                }
                append("\nfox ")
                withStyle(SpanStyle(letterSpacing = 9.sp)) { append("jumps") }
                append(" ")
                withStyle(SpanStyle(fontStyle = FontStyle.Italic, fontWeight = FontWeight.Black)) { append("over") }
                append("\n")
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) { append("the") }
                withStyle(SpanStyle(fontFamily = ScriptFont,fontStyle = FontStyle.Italic)) { append("  lazy ") }
                append("dog.")
            }

            Text(text = demo, fontSize = 28.sp, lineHeight = 36.sp)
            Spacer(Modifier.height(8.dp))
        }
    }
}

/* ---------- Preview ---------- */
@Preview(showBackground = true, name = "TextScreen Preview")
@Composable
fun TextScreenPreview() {
    ScreenNavigationTheme { TextScreen(onBack = {}) }
}
