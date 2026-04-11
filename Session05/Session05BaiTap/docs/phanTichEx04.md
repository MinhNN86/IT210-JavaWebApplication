# 📊 So sánh 2 cách xây dựng giao diện

## Cách A: Copy-paste Header/Footer

### ✅ Ưu điểm

* Dễ làm, không cần cấu hình thêm
* Phù hợp project nhỏ

### ❌ Nhược điểm

* Lặp code (vi phạm DRY)
* Khó bảo trì (sửa header phải sửa nhiều file)
* Dễ lỗi không đồng bộ giao diện

---

## Cách B: Sử dụng Layout Dialect (layout:decorate)

### ✅ Ưu điểm

* Tái sử dụng code (DRY)
* Dễ bảo trì (chỉ sửa 1 file layout)
* Code sạch, chuyên nghiệp
* Chuẩn enterprise

### ❌ Nhược điểm

* Cần cấu hình thêm (LayoutDialect)
* Ban đầu khó hiểu hơn

---

# 🎯 Kết luận

→ Nên dùng Cách B trong các dự án thực tế vì:

* Giảm lặp code
* Dễ mở rộng
* Tối ưu maintain

---

# ⚙️ Phân tích kỹ thuật

Thymeleaf mặc định KHÔNG hỗ trợ layout nâng cao.

→ layout:decorate là tính năng của thư viện:
nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect

→ Vì vậy phải đăng ký Bean LayoutDialect vào SpringTemplateEngine

Nếu không:
→ layout:decorate sẽ không hoạt động
