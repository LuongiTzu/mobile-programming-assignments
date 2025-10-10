# BÀI TẬP VỀ NHÀ TUẦN 02 – ỨNG DỤNG XÁC ĐỊNH TÊN VÀ TUỔI

## Mục tiêu
Tạo ứng dụng Android bằng Jetpack Compose cho phép nhập họ tên và tuổi, sau đó xác định và hiển thị nhóm tuổi tương ứng:
- Em bé (<2)
- Trẻ em (2–6)
- Người lớn (6–65)
- Người già (>65)

## Kết quả đạt được
Ứng dụng hiển thị hai ô nhập liệu (Họ và tên, Tuổi), nhấn nút “Kiểm tra” sẽ hiển thị kết quả phân loại người dùng, nếu nhập sai thì hiện thông báo lỗi.

### `data class KetQuaXacMinh`
Lưu trữ thông tin kết quả xác minh (thông báo, màu, phân loại tuổi).

### `fun xacDinhNhapHopLe(ten: String, tuoi: String)`
Kiểm tra dữ liệu nhập vào, xác định loại tuổi và trả về kết quả hợp lệ hoặc lỗi.

### `@Composable fun ManHinhNhapTenTuoi()`
Giao diện chính chứa các trường nhập,nơi gọi hàm, các nút kiểm tra và phần hiển thị.

### `@Composable fun InputField()`
Tạo hai ô nhập liệu: họ tên và tuổi.

### `@Composable fun KiemTraButton()`
Tạo nút kiểm tra để gọi hàm xử lý khi người dùng nhấn nút.

### `@Composable fun ThongTinNguoiDungCard()`
Hiển thị thông tin người dùng và kết quả phân loại khi nhập hợp lệ.

### `@Composable fun ThongBaoLoi()`
Hiển thị thông báo lỗi nếu nhập sai hoặc thiếu dữ liệu.

### `class MainActivity`
Activity chính, khởi chạy giao diện `ManHinhNhapTenTuoi()`.


