
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
public class DataStorage {
    
    public static  ArrayList<Object> servers = new ArrayList<>();
    public static  ArrayList<Object> rooms = new ArrayList<>();
    public static  ArrayList<Object> devices = new ArrayList<>();
    public static  ArrayList<Object> sensors = new ArrayList<>();
    public static String userId;
    public static String homeServerId;
    
    public String getUserId() {
        return userId;
    }
    public String getHomeServerId() {
        return homeServerId;
    }
    
}
    
