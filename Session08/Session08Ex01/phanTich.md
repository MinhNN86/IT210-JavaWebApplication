# Phân tích logic

## 1. Lọt khoảng trắng (Space) vào Database

**Nguyên nhân:**
- Annotation `@NotNull` chỉ kiểm tra giá trị có bị `null` hay không.
- `@NotNull` cho phép chuỗi rỗng (`""`) hoặc chuỗi chỉ chứa khoảng trắng (`"   "`).
- Khi người dùng nhập dấu cách, giá trị này vẫn hợp lệ với `@NotNull` và sẽ được lưu vào database.

## 2. Không chặn được request từ Postman gây lỗi 500

**Nguyên nhân:**
- Trong `UserController`, tham số `@RequestBody AddressDto addressDto` thiếu annotation `@Valid` (hoặc `@Validated`).
- Khi thiếu annotation này, Spring Boot không kiểm tra validation của DTO khi nhận request.
- Nếu gửi dữ liệu sai (bỏ qua frontend, dùng Postman), request vẫn chạy vào logic bên trong.
- Khi tầng Service/Repository xử lý hoặc lưu giá trị null vào database, sẽ phát sinh lỗi hệ thống như `NullPointerException` hoặc vi phạm ràng buộc dữ liệu (ConstraintViolation), dẫn đến lỗi **500 Internal Server Error** thay vì trả về lỗi **400 Bad Request** hợp lệ.

