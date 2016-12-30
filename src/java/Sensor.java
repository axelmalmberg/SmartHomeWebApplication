/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bumblebee
 */
public class Sensor {
    String sensorName;
    String sensorType;
    String sensorId;
    
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }
    
    public String getSensorName() {
        return sensorName;
    }
    public String getSensorType() {
        return sensorType;
    }
    public String getSensorId() {
        return sensorId;
    }
}
