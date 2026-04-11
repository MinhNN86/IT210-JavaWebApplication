# 📊 Thiết kế kiến trúc Smart Order

## 1. Kiến trúc 3 tầng

Controller → Service → Repository

* Controller:
  Nhận request, điều hướng view

* Service:
  Xử lý logic (tính tổng tiền, validate)

* Repository:
  Lưu trữ dữ liệu (in-memory)

---

## 2. Data Flow

User truy cập /bai5/order
→ Controller gọi Service lấy danh sách món

→ Service gọi Repository
→ trả về List<Dish>

→ Controller đưa vào Model
→ View hiển thị

---

## 3. Natural Templating

* HTML vẫn hiển thị dữ liệu mẫu khi mở trực tiếp
* Khi chạy server → Thymeleaf override bằng th:*

---

## 4. Nguyên tắc Dumb View

* View chỉ hiển thị
* Không tính toán tổng tiền
* Logic đặt ở Service

---

## 5. Bảo mật /WEB-INF

* Thư mục /WEB-INF không truy cập trực tiếp qua URL
* ViewResolver render server-side
  → Người dùng không thể truy cập file .html trực tiếp
