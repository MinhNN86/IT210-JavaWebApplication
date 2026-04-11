# 📊 Phân tích luồng dữ liệu (Data Flow)

## 1. Luồng tổng thể

View A (dish-list.html)
→ Người dùng nhấn "Chỉnh sửa"
→ Gửi request chứa ID (/bai3/edit/{id})

→ Controller nhận ID
→ Gọi Service lấy Dish theo ID

→ Nếu tồn tại:
→ Đẩy object Dish vào Model
→ Trả về View B (edit-dish.html)

→ Nếu không tồn tại:
→ Redirect về /bai2/dishes
→ Kèm thông báo lỗi: "Không tìm thấy món ăn yêu cầu!"

---

## 2. Thymeleaf sử dụng

* th:object → bind object Dish vào form
* th:field → bind dữ liệu vào input
* @{...} → tạo URL động
* th:href → link chỉnh sửa

---

## 3. Data Binding

* Spring tự động map dữ liệu form → object Dish
* Không cần parse thủ công

---

## 4. Sơ đồ

User click Edit
→ Controller (/bai3/edit/{id})
→ Service
→ Model (Dish)
→ View (edit-dish.html)
