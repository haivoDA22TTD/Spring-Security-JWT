# Clone dự án về máy 
git clone https://github.com/haivoDA22TTD/Spring-Security-JWT.git
# Chạy dự án 
![image](https://github.com/user-attachments/assets/63c79d0d-34ba-4995-ac70-468f59edefff)
# Đăng ký tài khoản
  Mở postman tại URL gõ localhost:3000/api/auth/register. Chọn phương thức Post chọn mục Body->raw
  ![image](https://github.com/user-attachments/assets/ee813820-5cec-403b-bf6a-a6d9c9c629f0)

  Điền thông tin tài khoản và ấn nút Send
  
  ![image](https://github.com/user-attachments/assets/13432861-fe1c-4b07-8d07-6e7a3c169cf2)
  Sau khi đăng ký tài khoản thành công 
  
  ![image](https://github.com/user-attachments/assets/66af0bcb-3f8c-4e3e-b68a-26fa92ece5bb)
  Tài khoản sau khi đăng ký sẽ được lưu vào Database và mật khẩu người dùng sẽ được mã hóa bằng thuật toán BCrypt
  
   ![image](https://github.com/user-attachments/assets/3afda0be-b0c1-4f25-b27f-bf21a0d004aa)

# Đăng nhập vào tài khoản đã đăng ký
  Tại URL gõ localhost:3000/api/auth/login chọn phương thức Post và điền thông tin tài khoản và ấn nút Send
  
  ![image](https://github.com/user-attachments/assets/bf387625-d57c-4bd7-baa8-b6f32df8cc9f)
  
# Đăng nhập thành công
  ![image](https://github.com/user-attachments/assets/fba349f7-b3f4-46a7-af7f-bd44ea3c7aad)
  Sau khi đăng nhập thành công sẽ nhận được Token 
