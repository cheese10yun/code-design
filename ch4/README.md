# 패스트 캠퍼스 유지보수하기 좋은 코드 디자인
[패스트 캠퍼스 유지보수하기 좋은 코드 디자인](https://fastcampus.co.kr/dev_online_spring) 예제 코드


1. Exception 처리를 왜 해야할까요?
2. Check Exception VS UnChecked Exception

 
## 오류 코드 코드보다 예외를 사용하라

> [클린 코드 내](http://www.yes24.com/Product/Goods/11681152)

```java
public class DeviceController {
    ...
    public void sendShutDown() {
        DeviceHandle handle = getHandle(DEV1);
        // 디바이스 상태를 점검한댜.
        if (handle != DeviceHandle.INVALID) {
            // 레코드 필드에 디바이스 상태를 저장한다.
            retrieveDeviceRecord(handle);
            // 디바이스가 일시정지 상태가 아니라면 종료한다.
            if (record.getStatus() != DEVICE_SUSPENDED) {
                pauseDevice(handle);
                clearDeviceWorkQueue(handle);
                closeDevice(handle);
            } else {
                logger.log("Device suspended. Unable to shut down");
            }
        } else {
            logger.log("Invalid handle for: " + DEV1.toString());
        }
    }
    ...
}
```
* 비지니스 로직과 오류 처리 코드가 함께 있어 코드가 복잡하하다
* 무슨 오류가 있는지 명확하게 파악이 힘들다.

```java
public class DeviceController {
	...
	public void sendShutDown() {
		try {
			tryToShutDown();
		} catch (DeviceShutDownError e) {
			// 적절한 Exception을 발생시키는것이 더 바람직하다.
            logger.log(e);
		}
	}

	private void tryToShutDown() throws DeviceShutDownError {
		DeviceHandle handle = getHandle(DEV1);
		DeviceRecord record = retrieveDeviceRecord(handle); 
		pauseDevice(handle); 
		clearDeviceWorkQueue(handle); 
		closeDevice(handle);
	}

	private DeviceHandle getHandle(DeviceID id) {
		...
		throw new DeviceShutDownError("Invalid handle for: " + id.toString());
		...
	}
	
```
* **비지니스 코드와 오류 처리 코드가 분리되어 가독성이 좋다**
* **무슨 예외가 왜 발생하는지 명확해짐**