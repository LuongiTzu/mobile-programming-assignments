package com.example.htquanlythuvien.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Data classes moved from ManagementScreen
data class BookUi(val id: String, val title: String, val available: Boolean = true)
data class StudentUi(val id: String, val name: String)

/**
 * Khối trạng thái trống – dùng khi chưa có dữ liệu / chưa chọn.
 */
@Composable
fun EmptyState(
    title: String,
    description: String,
    actionText: String? = null,
    onAction: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    OutlinedCard(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(title)
            Text(description)
            if (actionText != null && onAction != null) {
                Button(onClick = onAction, modifier = Modifier.padding(top = 8.dp)) {
                    Text(actionText)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyStatePreview() {
    EmptyState(
        title = "Bạn chưa mượn quyển sách nào",
        description = "Nhấn 'Thêm' để bắt đầu hành trình đọc sách!"
    )
}
