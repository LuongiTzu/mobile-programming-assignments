# Bài tập 1 - Tài liệu

## Câu 1  
Sau khi học xong môn lập trình thiết bị di động, mong muốn của em là: thành thạo ở mức tương đối ngôn ngữ lập trình Kotlin;  nắm vững những kiến thức cơ bản và nâng cao hơn một chút về lập trình ứng dụng android, về phương pháp, cấu trúc, lý thuyết, cách thiết kế UI, UX sao cho thân thiện và trực quan với người dùng…Về phần định hướng trong tương lai, em sẽ trau dồi thêm kiến thức và Kotlin ở mức nâng cao, mở ra thêm kiến thức về Flutter, từ đó thực hiện thêm nhiều project khác và sau đó nữa có thể tự xây dựng và triển khai một ứng dụng hoàn chỉnh lên CH Play.   

---

## Câu 2  
Theo em, trong tương lai gần (10 năm) lập trình di động sẽ tiếp tục phát triển mạnh mẽ bởi vì: thứ nhất, nhu cầu sử dụng smartphone ngày càng tăng, nó đã trở thành 1 thiết bị không thể thiếu trong cuộc sống hằng ngày của chúng ta, được vận dụng vào hầu hết vào các công việc và ngành nghề; thứ 2, hàng loạt công nghệ mới như AI, AR, VR, mạng 5G và 6G hay IoT cũng thúc đẩy ngành này; không những thế việc các hãng điện thoại hay công ty công nghệ cũng là một đòn bẩy giúp ngành lập trình di động không bao giờ mất đi sức hút.

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

  ---
  ![Ảnh Output](BaiTap1/output.png)

