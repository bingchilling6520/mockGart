# mockGart
Main code repo for the mock bot

All files from the project are uploaded.
If you want to run this code, remember to install necessary softwares as repo does not contains those.

## Talons / VEXes ID mapping

**Note**: All Driverbase motors are observed by looking from **the back of the robot** (aka the battery side)

|Motor|Vietnamese note|Talon ID|
|-----|---------------|--------|
|Driverbase Right Master|Motor bánh bên phải phía trước|1|
|Driverbase Right Follow|Motor bánh bên phải phía sau|2|
|Driverbase Left Master|Motor bánh bên trái phía trước|3|
|Driverbase Left Follow|Motor bánh bên trái phía sau|4|
|Intake|Intake (cái để hút kéo bóng vào)|5|
|Pulley|Motor máng|6|
|Reserved (for future use)|Dự phòng trong trường hợp Thắng lại đổi kế hoạch|7|
|Trapdoor (actually Victor SRX)|Trapdoor (cái để giữ bóng)|8|

## Controller mapping

PS5 or whatever handheld controller given by cỏ

|Name / Axis purpose|Vietnamese note|Axis ID|
|---------------------|---------------|---------|
|Driverbase Left Side|Điều khiển các bánh trái của Driverbase|1 (Left Joystick)|
|Driverbase Right Side|Điều khiển các bánh phải của Driverbase|5 (Right Joystick)|
|Invert|Giữ để đảo ngược chiều Intake và Pullley (Máng)|3 (L1 Button)|
|Speed Boost|Tăng tốc cho bánh cả hai bên Driverbase|4 (R1 Button)|

|Name / Button purpose|Vietnamese note|Button ID|
|---------------------|---------------|---------|
|Intake|Giữ để chạy hút|5 (L2)|
|Pulley|Giữ để chạy máng|6 (R2)|
|Open/Close Trapdoor|Đóng / mở trapdoor (**nhớ nhìn state trên SmartDashboard**)|3 (cx ko biết là button tên j)|

## Team blue không phải dọn lab go bruh bruh
