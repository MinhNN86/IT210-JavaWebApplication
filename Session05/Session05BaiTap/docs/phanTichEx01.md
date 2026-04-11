Các lỗi trong cấu hình ban đầu:

1. Sai prefix:
    - Sử dụng /WEB-INF/views thay vì /WEB-INF/templates

2. Sai suffix:
    - Dùng .jsp thay vì .html (Thymeleaf chỉ hỗ trợ HTML)

3. Thiếu cấu hình:
    - Chưa cấu hình SpringTemplateEngine
    - Chưa cấu hình ThymeleafViewResolver

Cách sửa:
- Đổi prefix thành /WEB-INF/templates/
- Đổi suffix thành .html
- Thêm TemplateEngine và ViewResolver

Kết quả:
- Hệ thống render đúng giao diện Thymeleaf
- Không còn lỗi 500