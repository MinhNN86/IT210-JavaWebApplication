# Phân tích lỗi Spring MVC cấu hình DispatcherServlet & ComponentScan

---

## 1. Lỗi trong `MyWebAppInitializer.java`

```java
return new String[] { "/api/*" };
```

❌ **Vấn đề:**
- `DispatcherServlet` chỉ xử lý request có dạng `/api/...`
- Nhưng bạn gọi: `http://localhost:8080/demo/welcome`
- URL này **KHÔNG match** `/api/*` → `DispatcherServlet` không nhận request → Tomcat trả về **404 Not Found**

**Kết luận:**
- `DispatcherServlet` đang nghe: `/demo/api/*`
- Không phải: `/demo/*`

---

## 2. Lỗi trong `WebConfig.java`

```java
@ComponentScan(basePackages = "com.demo.service")
```

❌ **Vấn đề:**
- Spring chỉ scan trong package: `com.demo.service`
- Trong khi Controller nằm ở: `com.demo.controller`

**Hậu quả:**
- Spring **KHÔNG** tìm thấy `@Controller`
- Không có bean `WelcomeController`
- Không mapping `/welcome`

**Kết quả:**
- Dù mapping đúng → vẫn lỗi
- Vì không có controller để xử lý request

---

## 3. Nếu chỉ sửa lỗi 1 (Servlet Mapping) thì sao?

✔ **Sửa:**
```java
"/"
```
❗ Nhưng **KHÔNG sửa** `ComponentScan`

**Kết quả:**
- Request vào được `DispatcherServlet` ✅
- Nhưng: Không tìm thấy Controller ❌

**Kết luận:**
- Ứng dụng **VẪN KHÔNG chạy**
- Vì: `No mapping found for HTTP request`
