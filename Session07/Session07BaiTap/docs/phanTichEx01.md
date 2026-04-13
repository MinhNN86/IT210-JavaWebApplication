# PHẦN 1 – PHÂN TÍCH LỖI

---

❌ **1. Tên cửa hàng bị null**

**Nguyên nhân chính:**
- Spring Data Binding map theo `name` của input
- Nhưng HTML của bạn Fresher:
    - Thiếu `name`
    - Hoặc `name` không trùng với field trong model

**Ví dụ sai:**
```html
<input type="text" id="name">
```

➡️ *Spring sẽ KHÔNG bind được →* `restaurantName = null`

---

❌ **2. Checkbox boolean bị lỗi**

**Nguyên nhân:**
- Checkbox trong HTML:
    - KHÔNG gửi gì nếu không check
    - Nếu không có value → Spring không bind được đúng

**Ví dụ sai:**
```html
<input type="checkbox" name="active">
```

**Khi:**
- check → gửi "on" (`string` ❌)
- không check → không gửi gì ❌

➡️ *Spring boolean cần:*
- "true" / "false"
