/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bumblebee
 */
public class Room {
    String roomId;
    String roomName;
    Device[] devices;
    
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public String getRoomId() {
        return roomId;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setDevices(Device[] devices) {
        this.devices = devices;
    }
    public Device[] getDevices() {
        return devices;
    }
}
