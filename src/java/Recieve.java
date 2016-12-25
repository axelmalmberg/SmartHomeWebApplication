
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
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
public class Recieve {
    
    // this is just and example
    
    //change the url and input etc
    
    //make it not void since we want to get something
    
    
    public String getSensors(String deviceId) {
        String output = "";
        String URL = "http://smarthomeinterface.azurewebsites.net/getSensors/" + deviceId;
        output = send(URL);       
        return output;
    }
    
    public String getDevices(String roomId) {
        String output = "";
        String URL = "http://smarthomeinterface.azurewebsites.net/getDevices/" + roomId;
        output = send(URL);       
        return output;
    }
    
    
    public String getRooms(String homeServerId) {
        String output = "";
        String URL = "http://smarthomeinterface.azurewebsites.net/getRooms/" + homeServerId;
        output = send(URL);       
        return output;
    }
    
    public String getHomeServer(String userId) {
        String output = "";     
        String URL = "http://smarthomeinterface.azurewebsites.net/getHomeServers/" + userId;
        output = send(URL);      
        return output;
    }
    
    
    public String send(String URL) {
        String output2 = "";
        try {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(URL);
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

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
	  } catch (ClientProtocolException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();
	  }
        return output2;
    }
    
}
