# Báo cáo App Demo: Các kỹ thuật LazyList trong Jetpack Compose

## 1. Thông tin sinh viên và đề tài báo cáo
### 1.1. Thông tin sinh viên:
- **Họ và tên sinh viên:** Huỳnh Tuấn Lượng
- **MSSV:** 052205000366
- **Lớp:** CN2301C
- **Lớp học phần:** [CQ]_HKI2025-2026_Lập trình thiết bị di động_010112103401

### 1.2. Đề tài báo cáo:
Build Android Applications Kotlin Hands - PART II - Chaper 6: Building Lists with Jetpack Compose

## 2. Thông tin source code
- **Ngôn ngữ:** Kotlin
- **UI framework:** Jetpack Compose
- **Kiến trúc:** Compose cơ bản (không ViewModel)
- **Navigation:** Navigation Compose
- **Min SDK:** 24
- **Target SDK:** 36
- **Compose Compiler:** 1.5.11
- **Gradle Plugin:** AGP 8.1+

### Luồng hoạt động của ứng dụng:
1. `MainActivity` khởi chạy và hiển thị `NavHost`.
2. Màn hình đầu tiên là `HomeScreen`.
3. Từ `HomeScreen`, người dùng có thể chọn một trong các demo chức năng khác nhau (LazyColumn, CRUD, StaggeredGrid…).
4. `navController.navigate(route)` được sử dụng để điều hướng đến màn hình tương ứng.
5. Mỗi màn hình dùng `LazyList` để hiển thị nội dung và minh họa kỹ thuật liên quan được vận dụng từ tài liệu **Build Android Applications Kotlin Hands - PART II - Chaper 6**.

- **Link git dự án:** `https://github.com/LuongiTzu/mobile-programming-assignments.git`
- **Link thư mục dự án cụ thể:** `https://github.com/LuongiTzu/mobile-programming-assignments/tree/main/DemoLazyListThuyetTrinh/DemoLazyList`

## 3. Mô tả cơ bản & Cách cài đặt
### 3.1. Mô tả cơ bản
`DemoLazyList` là một ứng dụng mẫu được xây dựng bằng Jetpack Compose, dùng để trình bày demo các kỹ thuật làm việc với danh sách (`LazyList`) trong Compose. Các kỹ thuật này được vận dụng từ sách **Build Android Applications Kotlin Hands - PART II - Chaper 6** và một số tài liệu tham khảo bên ngoài.

Ứng dụng minh họa các thao tác phổ biến, cơ bản và một số chức năng nâng cao khi làm việc với danh sách, bao gồm:
- Cách hiển thị danh sách cơ bản: `LazyColumn` và `LazyRow`.
- CRUD (Create – Read – Update – Delete): Thêm phần tử, xóa bằng cách click, vuốt để xóa (Swipe to Delete), sửa phần tử.
- Cách sử dụng `StickyHeader`, `LazyListState`, `key` và `contentType`.
- Cách tạo danh sách chứa nhiều loại item (Multiple View Types).
- Xử lý sự kiện click và điều hướng sang màn hình chi tiết.
- Các tính năng tìm hiểu thêm:
    - Nested LazyList (Danh sách lồng nhau).
    - Staggered Grid (Lưới so le).
    - `LazyLayoutCacheWindow`.

### 3.2. Cách cài đặt
**Bước 1 — Clone dự án**

Sử dụng Git:
```bash
git clone https://github.com/LuongiTzu/mobile-programming-assignments.git
```
Sau đó điều hướng đến đúng thư mục của ứng dụng:
`cd mobile-programming-assignments/DemoLazyListThuyetTrinh/DemoLazyList`

Hoặc bạn có thể tải trực tiếp file `.zip` từ GitHub rồi giải nén.

**Bước 2 — Mở dự án bằng Android Studio**

1. Khởi động Android Studio.
2. Chọn **Open** hoặc **Open Existing Project**.
3. Trỏ đến thư mục gốc của ứng dụng vừa clone: `<path-to-your-folder>/mobile-programming-assignments/DemoLazyListThuyetTrinh/DemoLazyList`.

> **Lưu ý:** Bạn phải mở đúng thư mục `DemoLazyList` (thư mục chứa `app/`, `gradle/`, `settings.gradle.kts`, `build.gradle.kts`), không mở toàn bộ repository.

**Bước 3 — Đồng bộ Gradle**
Android Studio sẽ tự động tải các dependencies cần thiết và đồng bộ dự án. Nếu được hỏi, hãy chọn **Sync Now**.

**Bước 4 — Build & Run ứng dụng**
1. Kết nối thiết bị Android thật (đã bật USB Debugging) hoặc khởi chạy một Android Emulator (API 24+).
2. Chọn module `app` từ thanh công cụ.
3. Nhấn nút **Run ‘app’** (biểu tượng tam giác màu xanh).

Android Studio sẽ build ứng dụng, cài đặt lên thiết bị và tự động mở màn hình chính của `DemoLazyList`.
