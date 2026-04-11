# EDU-PATH - Hệ Thống Quản Lý Khóa Học Tiếng Anh

## 📖 Giới Thiệu Dự Án

EDU-PATH là một hệ thống quản lý khóa học tiếng Anh được xây dựng với mục tiêu cho phép nhân viên học vụ thực hiện tra cứu, xem chi tiết và cập nhật trạng thái các lớp học một cách hiệu quả. Đây là dự án Mini Project trong khuôn khổ môn học IT210 - Java Web Application.

### 🎯 Mục Tiêu Dự Án

- Xây dựng phân hệ quản lý thông tin các khóa học tiếng Anh
- Cung cấp giao diện thân thiện cho nhân viên học vụ
- Hỗ trợ tra cứu và lọc khóa học theo nhiều tiêu chí
- Quản lý trạng thái và thông tin khóa học

---

## 🚀 Tính Năng Chính

### 1. Thiết Lập Hệ Thống Layout
- Sử dụng Thymeleaf Layout Dialect
- Header chứa Logo "EDU-PATH" và Slogan
- Navbar với các nút điều hướng
- Layout kế thừa cho tất cả các trang

### 2. Danh Sách & Lọc Khóa Học
- Hiển thị danh sách khóa học dạng bảng
- Tìm kiếm theo trình độ (Beginner, Intermediate, Advanced)
- Lọc theo học phí tối đa
- Thông báo khi không có kết quả phù hợp

### 3. Xem Chi Tiết Lộ Trình
- Xem thông tin chi tiết khóa học
- Hiển thị: Tên khóa, Lộ trình học, Giảng viên, Thời lượng
- Hiển thị trạng thái "Đã đủ chỗ" / "Còn chỗ"

### 4. Cập Nhật Thông Tin Khóa Học
- Form chỉnh sửa thông tin khóa học
- Cập nhật học phí và ngày khai giảng
- Áp dụng PRG Pattern (Post-Redirect-Get)

### 5. Xóa/Lưu Trữ Khóa Học
- Hủy khóa học khi chưa có học viên
- Validation nghiệp vụ (không xóa khi đã có học viên)
- Thông báo lỗi rõ ràng

---

## 🛠️ Công Nghệ Sử Dụng

### Backend
- **Java 21** - Ngôn ngữ lập trình chính
- **Spring MVC 7.0.6** - Framework web
- **Gradle** - Build tool

### Frontend
- **Thymeleaf 3.1.1** - Template engine
- **Thymeleaf Layout Dialect 3.4.0** - Layout management
- **Bootstrap 5.3.0** - CSS Framework

### Server
- **Apache Tomcat** (hoặc servlet container tương thích)
- **Jakarta Servlet API 6.1.0**

---

## 📁 Cấu Trúc Dự Án

```
Session06MiniProject/
├── src/
│   ├── main/
│   │   ├── java/com/session06miniproject/
│   │   │   ├── config/
│   │   │   │   ├── WebConfig.java              # Cấu hình Spring MVC & Thymeleaf
│   │   │   │   └── WebAppInitializer.java       # Khởi tạo ứng dụng web
│   │   │   ├── controller/
│   │   │   │   └── CourseController.java       # Controller xử lý request
│   │   │   ├── model/
│   │   │   │   └── Course.java                 # Model Course
│   │   │   ├── repository/
│   │   │   │   └── CourseRepository.java       # Repository & Mock Data
│   │   │   └── service/
│   │   │       └── CourseService.java          # Service layer
│   │   ├── resources/
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           ├── templates/
│   │           │   ├── layout/
│   │           │   │   └── main-layout.html   # Layout chính
│   │           │   └── course/
│   │           │       ├── list.html           # Danh sách khóa học
│   │           │       ├── detail.html         # Chi tiết khóa học
│   │           │       └── edit.html           # Form chỉnh sửa
│   │           └── web.xml                    # Cấu hình web
│   └── test/
│       ├── java/
│       └── resources/
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle                    # Cấu hình Gradle
├── settings.gradle                 # Cài đặt Gradle
├── gradlew                         # Gradle wrapper (Unix)
├── gradlew.bat                     # Gradle wrapper (Windows)
├── .gitignore                      # Git ignore file
├── srs.txt                         # Tài liệu đặc tả yêu cầu
└── README.md                       # Tài liệu dự án này
```

---

## 📋 Chi Tiết Cấu Trúc

### 📦 Package Structure

#### **config/**
- [`WebConfig.java`](src/main/java/com/session06miniproject/config/WebConfig.java) - Cấu hình Spring MVC, Thymeleaf Template Engine, và Layout Dialect
- [`WebAppInitializer.java`](src/main/java/com/session06miniproject/config/WebAppInitializer.java) - Khởi tạo DispatcherServlet và cấu hình ứng dụng web

#### **controller/**
- [`CourseController.java`](src/main/java/com/session06miniproject/controller/CourseController.java) - Xử lý các HTTP request:
  - `GET /` - Redirect đến danh sách khóa học
  - `GET /course/list` - Hiển thị danh sách với lọc
  - `GET /course/detail/{code}` - Xem chi tiết khóa học
  - `GET /course/edit/{code}` - Hiển thị form chỉnh sửa
  - `POST /course/edit` - Cập nhật thông tin khóa học
  - `POST /course/delete/{code}` - Xóa khóa học

#### **model/**
- [`Course.java`](src/main/java/com/session06miniproject/model/Course.java) - Entity Course với các thuộc tính:
  - `code` - Mã khóa học
  - `name` - Tên khóa học
  - `level` - Trình độ (Beginner, Intermediate, Advanced)
  - `tuitionFee` - Học phí
  - `description` - Lộ trình học
  - `instructor` - Giảng viên
  - `duration` - Thời lượng
  - `studentCount` - Số học viên hiện tại
  - `isFull` - Trạng thái (đủ chỗ chưa)
  - `startDate` - Ngày khai giảng

#### **repository/**
- [`CourseRepository.java`](src/main/java/com/session06miniproject/repository/CourseRepository.java) - Repository với Mock Data:
  - `findAll()` - Lấy tất cả khóa học
  - `findByCode(String code)` - Tìm kiếm theo mã
  - `update(Course course)` - Cập nhật khóa học
  - `delete(String code)` - Xóa khóa học
  - 5 khóa học mẫu để demo

#### **service/**
- [`CourseService.java`](src/main/java/com/session06miniproject/service/CourseService.java) - Business logic:
  - `filterCourses(String level, Double maxFee)` - Lọc khóa học
  - `getCourseByCode(String code)` - Lấy khóa học theo mã
  - `updateCourse(Course course)` - Cập nhật khóa học
  - `deleteCourse(String code)` - Xóa khóa học với validation

### 🎨 View Structure

#### **layout/**
- [`main-layout.html`](src/main/webapp/WEB-INF/templates/layout/main-layout.html) - Layout chính:
  - Header với Logo và Slogan
  - Navbar với các nút điều hướng
  - Content area với `layout:fragment="content"`
  - Footer

#### **course/**
- [`list.html`](src/main/webapp/WEB-INF/templates/course/list.html) - Danh sách khóa học:
  - Form tìm kiếm với Level và Max Fee
  - Bảng hiển thị danh sách
  - Nút Sửa và Hủy khóa học

- [`detail.html`](src/main/webapp/WEB-INF/templates/course/detail.html) - Chi tiết khóa học:
  - Thông tin chi tiết khóa học
  - Trạng thái "Đã đủ chỗ" / "Còn chỗ"
  - Nút quay lại và sửa

- [`edit.html`](src/main/webapp/WEB-INF/templates/course/edit.html) - Form chỉnh sửa:
  - Form với th:object binding
  - Cho phép sửa học phí và ngày khai giảng
  - Nút lưu và hủy

---

## 🚦 Cách Chạy Dự Án

### Yêu Cầu Hệ Thống
- JDK 21 hoặc cao hơn
- Gradle 8.x (hoặc sử dụng Gradle Wrapper)
- Servlet Container (Apache Tomcat 10+ hoặc Jetty)

### Các Bước Thực Hiện

1. **Clone hoặc tải dự án**
   ```bash
   cd Session06MiniProject
   ```

2. **Build dự án**
   ```bash
   # Sử dụng Gradle Wrapper (không cần cài đặt Gradle)
   ./gradlew build
   
   # Hoặc nếu đã cài đặt Gradle
   gradle build
   ```

3. **Chạy dự án trên Tomcat**
   ```bash
   # Copy file WAR từ build/libs/ vào thư mục webapps của Tomcat
   cp build/libs/Session06MiniProject-1.0-SNAPSHOT.war $TOMCAT_HOME/webapps/
   
   # Khởi động Tomcat
   $TOMCAT_HOME/bin/startup.sh  # Linux/Mac
   $TOMCAT_HOME/bin/startup.bat # Windows
   ```

4. **Truy cập ứng dụng**
   ```
   http://localhost:8080/Session06MiniProject-1.0-SNAPSHOT/
   ```

### Chạy với IDE (IntelliJ IDEA / Eclipse)

1. Mở dự án với IDE
2. Import Gradle project
3. Cấu hình Tomcat Server trong IDE
4. Deploy và chạy

---

## 📊 Mock Data

Dự án sử dụng 5 khóa học mẫu để demo:

| Mã Khóa | Tên Khóa Học | Trình Độ | Học Phí | Học Viên | Trạng Thái |
|---------|--------------|----------|---------|----------|------------|
| ENG-101 | Tiếng Anh Giao Tiếp Nhập Môn | Beginner | 3,000,000 VNĐ | 15 | Đã đủ chỗ |
| IELTS-5.0 | Luyện thi IELTS 5.0 | Intermediate | 6,000,000 VNĐ | 10 | Còn chỗ |
| IELTS-6.5 | Luyện thi IELTS 6.5+ | Advanced | 8,500,000 VNĐ | 0 | Còn chỗ |
| TOEIC-500 | Luyện thi TOEIC 500 | Beginner | 4,000,000 VNĐ | 0 | Còn chỗ |
| BUS-ENG | Tiếng Anh Thương Mại | Advanced | 9,000,000 VNĐ | 5 | Còn chỗ |

---

## 🎯 Các Endpoint API

| Method | Endpoint | Mô Tả |
|--------|----------|-------|
| GET | `/` | Redirect đến danh sách khóa học |
| GET | `/course/list` | Hiển thị danh sách với lọc (level, maxFee) |
| GET | `/course/detail/{code}` | Xem chi tiết khóa học |
| GET | `/course/edit/{code}` | Hiển thị form chỉnh sửa |
| POST | `/course/edit` | Cập nhật thông tin khóa học |
| POST | `/course/delete/{code}` | Xóa khóa học |

---

## 🔧 Cấu Hình Chính

### Thymeleaf Configuration
- Template Mode: HTML
- Character Encoding: UTF-8
- Prefix: `/WEB-INF/templates/`
- Suffix: `.html`
- Layout Dialect: Enabled

### Spring MVC Configuration
- Component Scan: `com.session06miniproject`
- View Resolver: ThymeleafViewResolver
- Character Encoding: UTF-8

---

## 📝 Yêu Cầu Kỹ Thuật

- ✅ Sử dụng Thymeleaf `#numbers.formatDecimal` để hiển thị học phí
- ✅ Sử dụng đúng các annotation: `@GetMapping`, `@PostMapping`
- ✅ Sử dụng `@RequestParam` với default value
- ✅ Sử dụng `@PathVariable` cho URL động
- ✅ Áp dụng PRG Pattern cho form submission
- ✅ Mock Data với ít nhất 5 khóa học

---

## 🎓 Tài Liệu Tham Khảo

- [Spring MVC Documentation](https://docs.spring.io/spring-framework/reference/web.html)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [Thymeleaf Layout Dialect](https://github.com/ultraq/thymeleaf-layout-dialect)
- [Bootstrap 5 Documentation](https://getbootstrap.com/docs/5.3/)

---

## 👥 Tác Giả

Dự án được thực hiện trong khuôn khổ môn học IT210 - Java Web Application.

---

## 📄 Giấy Phép

Dự án được tạo ra cho mục đích học tập và giáo dục.

---

## 🔄 Lịch Sử Phiên Bản

- **v1.0.0** - Phiên bản đầu tiên với đầy đủ các tính năng theo SRS
  - Triển khai 5 chức năng cốt lõi
  - Cấu hình Thymeleaf Layout Dialect
  - Mock Data với 5 khóa học
  - UI với Bootstrap 5

---

## 📞 Hỗ Trợ

Nếu có câu hỏi hoặc vấn đề liên quan đến dự án, vui lòng liên hệ giảng viên môn IT210.

---

**EDU-PATH - Hệ Thống Quản Lý Khóa Học Tiếng Anh** © 2026
