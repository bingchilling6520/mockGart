# mockGart
Main code repo for the mock bot

All files from the project are uploaded.
If you want to run this code, remember to install necessary softwares as repo does not contains those.
All music files should be deployed at src/main/deploy and can refer to its path as only its name and extension.

## Talons / VEXes ID mapping

**Note**: All reference point are observed by looking from **the back of the robot** (aka the battery side)

|Motor|Type|Vietnamese note|ID|
|-----|----|---------------|--------|
|Driverbase Right Master|TalonSRX|Motor bánh bên phải phía trước|1|
|Driverbase Right Follow|TalonSRX|Motor bánh bên phải phía sau|2|
|Driverbase Left Master|TalonSRX|Motor bánh bên trái phía trước|3|
|Driverbase Left Follow|TalonSRX|Motor bánh bên trái phía sau|4|
|Intake|TalonSRX|Intake (cái để hút kéo bóng vào)|5|
|Left Pulley|Falcon/TalonFX|Motor máng bên trái|6|
|Right Pulley|Falcon/TalonFX|Motot máng bên phải|7|
|Trapdoor|Servo|Trapdoor (cái để giữ bóng)|0|

## Controller mapping

PS5 or whatever handheld controller given by cỏ

**NOTE**: All button are controlled by **holding**, **EXCEPT** for trapdoor.

**1st controller**

|Name / purpose|Type|ID|Vietnamese note|
|--------------|----|--|---------------|
|Driverbase Left Side|Joystick axis|1 (Left Joystick)|Điều khiển các bánh trái của Driverbase|
|Driverbase Right Side|Joystick axis|5 (Right Joystick)|Điều khiển các bánh phải của Driverbase|
|Speed Boost|Button axis|4 (R2 Button)|Tăng tốc cho bánh cả hai bên Driverbase|
|Go straight (auto balance)|POV|0 (POV Up)|Tiến thẳng cả 2 bên (dùng cho việc qua cầu khỉ)|
|Go back (auto balance)|POV|180 (POV Down)|Lùi thẳng cả 2 bên (dùng cho việc qua cầu khỉ)|

**2nd controller**

|Name / purpose|Type|ID|Vietnamese note|
|--------------|----|--|---------------|
|Intake|Button axis|5 (L1)|Giữ để chạy intake hút bóng|
|Pulley|Button axis|6 (R1)|Giữ để chạy máng|
|Open/Close Trapdoor|Button|3|Đóng / mở trapdoor (**nhớ nhìn state trên SmartDashboard**)|
|Invert|Button axis|3 (L2)|Đảo ngược chiều quay của intake và pulley (cho bóng xuống)|
|Boost pulley|Button axis|4 (R2)|Tăng tốc độ quay máng -> bắn bóng cao hơn|

## Team blue không phải dọn lab go bruh bruh
