# Báo cáo bảo mật JSP: XSS, JSTL và đường dẫn an toàn

---

## 1. XSS là gì?
- **XSS (Cross-Site Scripting)** là kỹ thuật tấn công chèn mã script độc hại vào website.
- Ví dụ tấn công:

```html
<script>alert('hack')</script>
```

---

### ✔ Vì sao `<c:out>` an toàn hơn `${}`?
- Sử dụng:
  ```jsp
  <c:out value="${keyword}" />
  ```
  - Sẽ tự động **escape** ký tự đặc biệt:
    - `<script>alert(1)</script>` → `&lt;script&gt;alert(1)&lt;/script&gt;`
    - **Không chạy được JS**
- Nếu dùng `${keyword}` trực tiếp:
  - Sẽ render nguyên văn, có thể bị thực thi mã độc nếu dữ liệu chứa script.

---

## 2. `<c:if>` vs `<c:choose>`
- `<c:if>`: kiểm tra điều kiện đơn giản (if)
- `<c:choose>`: nhiều nhánh (if-else, switch-case)
- **Ứng dụng thực tế:**
  - Giá vé, vé còn → nên dùng `<c:choose>` để xử lý nhiều trường hợp.

---

## 3. `<c:url>` để làm gì?
- Tạo URL an toàn, tự động thêm context path của ứng dụng.
- Ví dụ:
  ```jsp
  <c:url value="/events/1/book"/>
  ```
  - Sẽ tự động thành `/ticketing/events/1/book` nếu deploy context là `/ticketing`.
- Nếu hardcode `/events/1/book`:
  - Khi deploy ở context khác (vd: `/ticketing`) sẽ **sai đường dẫn**.

---

**Tóm lại:**
- Luôn dùng `<c:out>` để tránh XSS.
- Dùng `<c:choose>` cho logic nhiều nhánh.
- Dùng `<c:url>` để tạo link an toàn, tránh hardcode context path.
