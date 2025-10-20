package com.example.screennavigation.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screennavigation.ui.theme.ScreenNavigationTheme

@Composable
fun ComponentScreen(
    onOpenTextDetail: () -> Unit,
    onBack: () -> Unit,
    onOpenImage: () -> Unit,
    onOpenTextField: () -> Unit,
    onOpenRowLayout: () -> Unit,
    onLazyColumn: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp)
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
                text = "UI Components List",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Blue
            )
        }

        Spacer(Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Display", fontWeight = FontWeight.Bold)
            MenuItem(title = "Text", subtitle = "Displays text", onClick = onOpenTextDetail)
            MenuItem(title = "Image", subtitle = "Displays an image", onClick = onOpenImage)

            Spacer(Modifier.height(6.dp))
            Text("Input", fontWeight = FontWeight.Bold)
            MenuItem(title = "TextField", subtitle = "Input field for text", onClick = onOpenTextField)
            MenuItem(title = "PasswordField", subtitle = "Input field for passwords")

            Spacer(Modifier.height(6.dp))
            Text("Layout", fontWeight = FontWeight.Bold)
            MenuItem(title = "Column", subtitle = "Arranges elements vertically")
            MenuItem(title = "Row", subtitle = "Arranges elements horizontally", onClick = onOpenRowLayout)

            Spacer(Modifier.height(6.dp))
            Text("Lazy List", fontWeight = FontWeight.Bold)
            MenuItem(title = "Lazy Column", subtitle = "Displays a list of items vertically", onClick = onLazyColumn)
            MenuItem(title = "Lazy Row", subtitle = "Displays a list of items horizontally")

            Spacer(Modifier.height(6.dp))
            Text("Lazy List", fontWeight = FontWeight.Bold)
            //MenuItem(title = "dmmm", subtitle = "Displays a list of items", onClick = onDetail)
            //MenuItem(title = "cai cacsco cáccs", subtitle = "Displays a list of items horizontally")
        }
    }
}

@Composable
private fun MenuItem(
    title: String,
    subtitle: String,
    onClick: (() -> Unit)? = null
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFFD1E6FF))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.Black)
            Text(subtitle, fontSize = 13.sp, color = Color.DarkGray)
        }
    }
}

/* -------------------- PREVIEW -------------------- */
@Preview(showBackground = true, name = "ComponentScreen Preview")
@Composable
fun ComponentScreenPreview() {
    ScreenNavigationTheme {
        ComponentScreen(
            onOpenTextDetail = {},
            onBack = {},
            onOpenImage = {},
            onOpenTextField = {},
            onOpenRowLayout = {},
            onLazyColumn = {}
        )
    }
}
