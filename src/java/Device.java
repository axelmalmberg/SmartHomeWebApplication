/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bumblebee
 */
public class Device {
    String deviceId;
    String deviceName;
    Sensor[] sensors;
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setSensors(Sensor[] sensors) {
        this.sensors = sensors;
    }
    public Sensor[] getSensors() {
        return sensors;
    }
    
}
