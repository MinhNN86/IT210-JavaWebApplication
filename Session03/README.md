# StudentHub - Session03

Ung dung Spring MVC (khong dung Spring Boot) de quan ly sinh vien theo SRS.

## Chuc nang da lam
- Danh sach sinh vien: `/students`
- Sap xep: `/students?sortBy=name`, `/students?sortBy=gpa`
- Loc/tim kiem: `/students?search=Nguyen`, `/students?faculty=CNTT`
- Chi tiet sinh vien: `/students/detail?id=1`
- Dashboard: `/dashboard`

## Cau truc 4 tang
- `config`: cau hinh Spring MVC va khoi tao web
- `controller`: nhan request va day du lieu cho view
- `service`: xu ly nghiep vu va thong ke dashboard
- `repository`: du lieu hardcoded trong bo nho

## Run nhanh
```bash
./gradlew clean test
./gradlew clean war
```

WAR tao ra o:
- `build/libs/Session03-1.0-SNAPSHOT.war`

Sau do deploy WAR len Tomcat 10.x.

