/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bumblebee
 */
public class HomeServer {
    String homeServeName;
    String homeServerId;
    String userId;
    Room[] rooms;
    
    public void setHomeServerName(String homeServerName) {
    this.homeServeName = homeServerName;
    }
    
    public void setHomeServerId(String homeServerId) {
    this.homeServerId = homeServerId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getHomeServerName() {
        return homeServeName;
    }
    public String getHomeServerId() {
        return homeServerId;
    }
    public String getUserId() {
        return userId;
    }
    public void setRoom(Room[] rooms) {
        this.rooms = rooms;
    }
    public Room[] getRoom() {
        return rooms;
    }    
}
 