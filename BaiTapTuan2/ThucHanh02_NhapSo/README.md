# mobile-programming-assignments
# BÀI TẬP TUẦN 02 – ỨNG DỤNG NHẬP SỐ VÀ HIỂN THỊ DANH SÁCH

## Mục tiêu
Tạo ứng dụng Android bằng Jetpack Compose cho nhập một số nguyên, sau đó sinh ra danh sách các số từ 1 đến n và hiển thị lên màn hình.

## Kết quả đạt được
Ứng dụng gồm một ô nhập số, nút “Tạo” và danh sách kết quả hiển thị các số từ 1 đến n.  
Nếu người dùng nhập sai định dạng, số âm hoặc vượt quá giới hạn cho phép, ứng dụng sẽ hiển thị thông báo lỗi.

## Giải thích các hàm

### `class MainActivity`
Activity chính, khởi chạy và hiển thị giao diện `ManHinhNhapSo()`.

### `@Composable fun ManHinhNhapSo()`
Giao diện chính gồm ô nhập số, nút tạo và danh sách kết quả hiển thị theo số lượng nhập vào.

### `@Composable fun NumberItem(number: Int)`
Tạo thẻ (Card) hiển thị từng phần tử số trong danh sách sinh ra.

### `@Preview fun DefaultPreview()`
Hiển thị bản xem trước giao diện trong Android Studio.
---
![Output1](https://raw.githubusercontent.com/LuongiTzu/mobile-programming-assignments/main/BaiTapTuan2/ThucHanh02_NhapSo/output1.png)
![Output2](https://raw.githubusercontent.com/LuongiTzu/mobile-programming-assignments/main/BaiTapTuan2/ThucHanh02_NhapSo/output2.png)
![Output3](https://raw.githubusercontent.com/LuongiTzu/mobile-programming-assignments/main/BaiTapTuan2/ThucHanh02_NhapSo/output3.png)
