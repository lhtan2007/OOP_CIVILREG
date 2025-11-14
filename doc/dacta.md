# Đặc tả chương trình hỗ trợ quản lý hồ sơ hộ tịch

## 1. Mở đầu

Chương trình này được sử dụng để hỗ trợ công việc quản lý các hồ sơ hộ tịch, bao gồm: hồ sơ đăng ký khai sinh, đăng ký lại khai sinh; hồ sơ đăng ký khai tử, đăng ký lại khai tử; hồ sơ đăng ký kết hôn, đăng ký lại kết hôn; hồ sơ đề nghị cấp bản sao trích lục hộ tịch (khai sinh, khai tử, kết hôn).

Chương trình có khả năng lưu trữ các hồ sơ nói trên và xuất các biểu mẫu Giấy khai sinh, Trích lục khai tử, Giấy chứng nhận kết hôn và bản sao các giấy tờ đó.

### 1.1. Thuật ngữ và chữ viết tắt

#### 1.1.1. Thuật ngữ

- **Đăng ký khai sinh** là việc cơ quan Nhà nước có thẩm quyền ghi nhận sự kiện một người được sinh ra.

- **Đăng ký khai tử** là việc cơ quan Nhà nước có thẩm quyền ghi nhận sự kiện một người qua đời.

- **Đăng ký kết hôn** là việc cơ quan Nhà nước có thẩm quyền công nhận việc nam và nữ xác lập quan hệ vợ chồng với nhau.

- **Bản sao trích lục hộ tịch** là giấy tờ hộ tịch do cơ quan Nhà nước có thẩm quyền cấp dựa trên dữ liệu được lưu trữ trong Sổ hộ tịch hoặc Cơ sở dữ liệu hộ tịch điện tử, được trình bày theo thể thức quy định.

- **Cơ quan Nhà nước có thẩm quyền** bao gồm Ủy ban nhân dân xã, phường, Sở Tư pháp tỉnh, thành phố trực thuộc Trung ương, cơ quan đại diện ngoại giao Việt Nam tại nước ngoài.

- **Cơ quan đăng ký hộ tịch** là cơ quan Nhà nước có thẩm quyền đăng ký các sự kiện khai sinh, khai tử, kết hôn và các sự kiện khác theo quy định của pháp luật về hộ tịch.

#### 1.1.2. Các chữ viết tắt

| Chữ viết tắt | Nguyên nghĩa      |
|:------------:|:-----------------:|
| UBND         | Ủy ban nhân dân   |
| ĐKKS         | Đăng ký khai sinh |
| GKS          | Giấy khai sinh    |
| ĐKKH         | Đăng ký kết hôn   |
| TLKH         | Trích lục kết hôn |
| ĐKKT         | Đăng ký khai tử   |
| TLKT         | Trích lục khai tử |

### 1.2. Tài liệu tham khảo

1. Luật Hộ tịch năm 2014;

2. Nghị định số 123/2015/NĐ-CP ngày 15 tháng 11 năm 2015;

3. Thông tư số 04/2020/TT-BTP ngày 28 tháng 5 năm 2020.

## 2. Mô tả tổng thể chương trình

### 2.1. Yêu cầu hệ thống

Chương trình này có thể được sử dụng trên máy tính có cài đặt JRE (Java Runtime Environment) và máy chủ SQL Server (hay MySQL và tương đương, đảm bảo tương thích với JDBC; hoặc kết nối với máy chủ SQL khác).

### 2.2. Các chức năng của chương trình

- Khai báo hồ sơ hộ tịch mới;

- Chỉnh sửa các hồ sơ đã tiếp nhận;

- Xuất kết quả xử lý ra tập tin PDF hoặc in trực tiếp.

### 2.3. Ràng buộc dữ liệu

Các hồ sơ đã nhập vào phải có đầy đủ dữ liệu tương ứng với quy định của pháp luật, đảm bảo không có hai hay nhiều hồ sơ trùng nhau.

## 3. Yêu cầu cụ thể

### 3.1. Yêu cầu chức năng

#### 3.1.1. Khai báo dữ liệu ban đầu

- Chương trình phải yêu cầu người dùng kết nối vào cơ sở dữ liệu do người dùng xác định.

- Chương trình phải cho phép người dùng nhập tên cơ quan đăng ký hộ tịch, lựa chọn việc hộ tịch (khai sinh, khai tử, kết hôn) cần giải quyết.

#### 3.1.2. Tiếp nhận hồ sơ

- Chương trình phải cho phép người dùng nhập dữ liệu theo các trường dữ liệu tương ứng với tờ khai đăng ký hộ tịch hoặc nhập dữ liệu từ tập tin mẫu điện tử tương tác đăng ký hộ tịch, đồng thời có thể kiểm tra tính đúng đắn của hồ sơ trong một số trường hợp cơ bản.

- Sau khi người dùng nhập dữ liệu, chương trình phải lưu dữ liệu đó vào cơ sở dữ liệu đã khai báo ở chức năng 3.1.1.

#### 3.1.3. Chỉnh sửa hồ sơ

- Chương trình phải cho phép người dùng chỉnh sửa, thay thế, xóa dữ liệu đã được lưu trong cơ sở dữ liệu.

- Việc chỉnh sửa, thay thế, xóa dữ liệu phải được lưu nhật ký (file log).

#### 3.1.4. Xuất kết quả xử lý

- Chương trình cho phép người dùng nhập các thông tin về người ký giấy tờ hộ tịch (chức vụ, họ và tên);

- Chương trình có khả năng xuất kết quả xử lý theo đúng biểu mẫu hộ tịch hiện hành.

### 3.2. Yêu cầu phi chức năng

- Chương trình có giao diện đồ hoạ dễ sử dụng, rõ ràng, không gây nhầm lẫn;

- Chương trình có khả năng hiển thị kết quả (file PDF) trực tiếp trên giao diện của chương trình.

- Chương trình tương thích với các phiên bản JRE gần nhất.

- Cơ sở dữ liệu được kết nối với chương trình có cấu trúc xác định và phải được chuẩn hóa theo chuẩn 3NF.








