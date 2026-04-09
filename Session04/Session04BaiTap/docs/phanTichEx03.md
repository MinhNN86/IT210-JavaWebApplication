## Phân tích Cách A và Cách B

### Cách A
- Số `5` nằm trong phần **URI Path** của URL.
- Cách này thể hiện rõ tài nguyên cụ thể cần truy cập.
- Phù hợp khi muốn lấy một đối tượng theo ID.

### Cách B
- Số `5` nằm trong **query string** sau dấu `?`.
- Cách này thường dùng cho lọc, tìm kiếm hoặc truyền tham số phụ.

### Kết luận
Theo nguyên tắc REST, khi cần truy xuất một tài nguyên cụ thể theo ID thì nên dùng **PathVariable**. Vì vậy, **Cách A** phù hợp hơn vì URL rõ ràng, dễ hiểu và đúng chuẩn thiết kế REST.
