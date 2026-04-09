URL: /bai4/products?category=chay&limit=10

Dữ liệu vào:

* category (String)
* limit (int)

Controller:

* Nhận category và limit bằng @RequestParam
* Đưa vào ModelMap với key: category, limit, message

View:

* Tên file: productList.jsp
* Nhận dữ liệu bằng ${category}, ${limit}, ${message} và hiển thị ra HTML
