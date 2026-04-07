# Giải thích về Scope và Race Condition trong Web Application

---

## 1. Vì sao error phải dùng **Request Scope**?
- **Request scope** chỉ tồn tại trong 1 request duy nhất.
- Nếu dùng **Session**:
  - Lỗi sẽ hiển thị mãi, kể cả khi reload hoặc login thành công.
  - → Trải nghiệm người dùng (UX) sai.

---

## 2. Vì sao `totalViewCount` dùng **Application Scope**?
- **Application scope**: biến dùng chung cho toàn hệ thống, mọi user đều thấy cùng 1 giá trị.
- Nếu dùng **Session**:
  - Mỗi user có 1 biến riêng biệt.
  - Ví dụ:
    - User A thấy: 3
    - User B thấy: 1 (❌ sai yêu cầu)

---

## 3. **Race Condition** là gì?
- Khi nhiều thread truy cập/ghi dữ liệu cùng lúc → dữ liệu bị sai lệch.

### ❌ Ví dụ code lỗi (không thread-safe):
```java
count++;
```

### ✔ Cách khắc phục:
```java
synchronized (application) {
    // ...
}
```
- Đảm bảo chỉ 1 thread update tại 1 thời điểm → dữ liệu luôn chính xác.
