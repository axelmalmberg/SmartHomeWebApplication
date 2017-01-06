package Classes;


import java.util.ArrayList;

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
    String roomId;
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getRoomId() {
        return roomId;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    public String getDeviceName() {
        return deviceName;
    }
    
    
}
