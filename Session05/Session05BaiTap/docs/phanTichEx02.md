# 📊 Phân tích luồng Input - Output

## 1. Input

* Người dùng truy cập URL: `/bai2/dishes`

## 2. Xử lý tại Controller

* Controller gọi Service để lấy danh sách món ăn (List<Dish>)
* Dữ liệu được add vào Model với key: "dishes"

## 3. Service

* Trả về danh sách Dish (mock data hoặc từ DB)

## 4. Output (View - Thymeleaf)

* Nếu danh sách có dữ liệu:

    * Hiển thị bảng danh sách món ăn
    * Dùng `th:each` để lặp
    * Nếu `isAvailable = false` → hiển thị màu đỏ + "Hết hàng"

* Nếu danh sách rỗng hoặc null:

    * Hiển thị:
      "Hiện tại nhà hàng đang cập nhật thực đơn, vui lòng quay lại sau"

## 5. Sơ đồ luồng

User → Controller → Service → Model → View (Thymeleaf)
