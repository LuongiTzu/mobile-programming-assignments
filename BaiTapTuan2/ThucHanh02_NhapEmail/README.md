# mobile-programming-assignments
# BÀI TẬP TUẦN 02 – ỨNG DỤNG XÁC ĐỊNH EMAIL HỢP LỆ

## Mục tiêu
Tạo ứng dụng Android bằng Jetpack Compose cho phép nhập địa chỉ email, kiểm tra định dạng hợp lệ và hiển thị thông báo tương ứng.

## Kết quả đạt được
Ứng dụng gồm một ô nhập email, nút “Kiểm tra” và dòng thông báo hiển thị kết quả:
- Nếu chưa nhập hoặc không có ký tự “@” → báo lỗi
- Nếu đúng định dạng → hiển thị thông báo hợp lệ với màu xanh.

## Giải thích các hàm

### `data class thongBao`
Lưu trữ thông tin thông báo (nội dung và màu hiển thị).

### `fun xacDinhChuanEmail(email: String)`
Kiểm tra định dạng email và trả về kết quả hợp lệ hoặc lỗi.

### `@Composable fun ManHinhNhapMail()`
Giao diện chính chứa ô nhập email, nút kiểm tra và phần hiển thị thông báo.

### `@Composable fun AppTitle()`
Hiển thị tiêu đề “Thực hành 02” ở đầu màn hình.

### `@Composable fun EmailInputField()`
Tạo ô nhập liệu cho địa chỉ email.

### `@Composable fun ThongBaoLoi()`
Hiển thị thông báo lỗi hoặc kết quả kiểm tra email.

### `@Composable fun KiemTraButton()`
Nút “Kiểm tra” dùng để gọi hàm xác định email hợp lệ.

### `class MainActivity`
Activity chính, khởi tạo và hiển thị giao diện `ManHinhNhapMail()`.
