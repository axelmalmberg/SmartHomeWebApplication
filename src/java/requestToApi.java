
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bumblebee
 */
public class requestToApi {

    //This is just an example
    //change URL and the input 
    //make the correct parameters such as commandId, sensorId, unitId
    //if you want to make a request
    //send the correct body in the StringEntity to send
    //and use the correct url in the send parameter as well
    //You can see all the example code etc at: http://smarthomeinterface.azurewebsites.net/docs/#/
    
    public String addSensor(String sensorName, String sensorType, String deviceId) {
        String output2 = "";
        try {

            StringEntity input = new StringEntity("{\"sensorName\":\"" + sensorName + "\",\"sensorType\":\"" + sensorType + "\",\"deviceid\":\"" + deviceId + "\"}");
            String URL = "\"http://smarthomeinterface.azurewebsites.net/addDevice";
            output2 = send(input, URL);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output2;
    }
    
    public String addRoom(String roomName, String serverId) {
        String output2 = "";
        try {

            StringEntity input = new StringEntity("{\"roomName\":\"" + roomName + "\",\"serverId\":\"" + serverId + "\"}");
            String URL = "\"http://smarthomeinterface.azurewebsites.net/addRoom";
            output2 = send(input, URL);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output2;
    }
    
    public String addHomeServer(String serverName, String userId) {
        String output2 = "";
        try {

            StringEntity input = new StringEntity("{\"serverName\":\"" + serverName + "\",\"userId\":\"" + userId + "\"}");
            String URL = "\"http://smarthomeinterface.azurewebsites.net/addHomeServer";
            output2 = send(input, URL);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output2;
    }
    
    public String addDevice(String deviceName, String roomId) {
        String output2 = "";
        try {

            StringEntity input = new StringEntity("{\"deviceName\":\"" + deviceName + "\",\"roomId\":\"" + roomId + "\"}");
            String URL = "\"http://smarthomeinterface.azurewebsites.net/addDevice";
            output2 = send(input, URL);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output2;

    }

    public String createUser(String username, String password, String email) {
        String output = "";
        try {
            StringEntity input = new StringEntity("{\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"email\":\"" + email + "\"}");
            String URL = "http://smarthomeinterface.azurewebsites.net/user/create";
            output = send(input, URL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }

    public String logIn(String username, String password) {
        String output2 = "";
        try {

            StringEntity input = new StringEntity("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");
            String URL = "http://smarthomeinterface.azurewebsites.net/user/login";
            output2 = send(input, URL);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output2;
    }

    public String setStatus(String commandId, String sensorId, String userId) {
        String output2 = "";
        try {
            StringEntity input = new StringEntity("{\"commandId\":\"" + commandId + "\",\"sensorId\":\"" + sensorId + "\",\"userId\":\"" + userId + "\"}");
            String URL = "http://smarthomeinterface.azurewebsites.net/home/3";

            output2 = send(input, URL);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output2;
    }

    public String send(StringEntity Input, String URL) {
        String output2 = "";
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(URL);

            StringEntity input = Input;

            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                output2 = output;
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();

            return output2;

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return output2;
    }

}
