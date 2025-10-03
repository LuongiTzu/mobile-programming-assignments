# Bài tập 1 - Tài liệu

## Câu 1  
Sau khi học xong môn lập trình thiết bị di động, mong muốn của em là:  
- Thành thạo ở mức tương đối ngôn ngữ lập trình **Kotlin**.  
- Nắm vững những kiến thức cơ bản và nâng cao hơn một chút về lập trình ứng dụng Android: phương pháp, cấu trúc, lý thuyết, thiết kế UI/UX thân thiện và trực quan.  
- Trong tương lai: trau dồi Kotlin ở mức nâng cao, mở rộng sang **Flutter**, thực hiện nhiều project hơn, và có thể **tự xây dựng & triển khai ứng dụng hoàn chỉnh lên CH Play**.  

---

## Câu 2  
Theo em, trong tương lai gần (10 năm), **lập trình di động sẽ tiếp tục phát triển mạnh mẽ** bởi vì:  
1. Nhu cầu sử dụng smartphone ngày càng tăng, trở thành thiết bị không thể thiếu trong đời sống hằng ngày.  
2. Hàng loạt công nghệ mới như **AI, AR, VR, 5G/6G, IoT** thúc đẩy ngành này phát triển.  
3. Sự đầu tư mạnh mẽ của các hãng điện thoại và công ty công nghệ là đòn bẩy khiến lập trình di động không bao giờ mất đi sức hút.  

---

## Câu 3: Thiết kế 1 Profile Card App đơn giản bằng **Jetpack Compose**

### Giải thích code chính

- **class MainActivity : ComponentActivity()**  
  → Màn hình chính của ứng dụng Android.  

- **onCreate gọi setContent { ... }**  
  → Dùng để vẽ giao diện bằng Jetpack Compose.  

- **enableEdgeToEdge()**  
  → Cho phép giao diện hiển thị tràn ra toàn màn hình (status bar & navigation bar).  

- **setContent { ... }**  
  → Thay vì XML, Compose vẽ UI trực tiếp bằng Kotlin.  

- **ProfileCardAppTheme { ... }**  
  → Áp dụng theme (màu sắc, typography, style) từ `ui.theme`.  

- **Surface(...)**  
  → Container nền có thể set màu, bo góc, đổ bóng.  
  → Ở đây dùng làm **background** cho màn hình.  

---

### Các thành phần giao diện

- **@Composable fun ProfileCardScreen(...)**  
  → Hàm Composable định nghĩa UI của thẻ profile.  

- **Scaffold(...)**  
  → Layout chuẩn trong Compose, có sẵn slot: `topBar`, `bottomBar`, `floatingActionButton`, …  
  → Ở đây dùng `topBar` để chứa nút **Back** và **Edit**.  

- **Row(...)**  
  → Sắp xếp thành phần theo **hàng ngang**.  
  → Dùng trong `topBar` để đặt Back bên trái, Edit bên phải.  

- **Box(...)**  
  → Container xếp chồng (giống `FrameLayout` trong XML).  
  → Ở đây bọc `IconButton` + border.  

- **IconButton(...)**  
  → Nút bấm chứa icon.  

- **Icon(...)**  
  → Hiển thị biểu tượng (ví dụ `ArrowBack`, `Edit`).  

- **Column(...)**  
  → Sắp xếp thành phần theo **cột dọc**.  
  → Dùng để đặt Avatar, Tên, Địa chỉ.  

- **Image(...)**  
  → Hiển thị ảnh (avatar).  
  → Dùng `clip(CircleShape)` để cắt tròn + thêm `border`.  

- **Spacer(...)**  
  → Tạo khoảng trống dọc hoặc ngang.  
