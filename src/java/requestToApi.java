
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
    //change url and the input 
    //make the correct parameters such as commandId, sensorId, unitId
    public void send(String commandId, String sensorId, String userId) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost("http://smarthomeinterface.azurewebsites.net/home/3");

            //StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
//            StringEntity input = new StringEntity("{\n"
//                    + "  \"commandId\": \"" + commandId +"\",\n"
//                    + "  \"sensorId\": \"" + sensorId +"\",\n"
//                    + "  \"userId\": \"" + userId +"\"\n"
//                    + "}");

            StringEntity input = new StringEntity("{\"commandId\":" + commandId +",\"sensorId\":\"" + sensorId +",\"userId\":\"" + userId +"\"}");

            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
