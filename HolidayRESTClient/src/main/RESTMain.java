package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * calls the Restful web service at REST_URL defined below
 * Created by kpant on 6/16/17.
 */
public class RESTMain {
    public static final String REST_URL = "http://www.holidaywebservice.com/Holidays/HolidayService.asmx/GetHolidaysForYear?countryCode=US&year=2017";
    public static final int OK_STATUS = Response.Status.OK.getStatusCode();




    public static void main(String[] args) {

        //call the service and get the response object
        Response response = ClientBuilder.newClient().target(REST_URL).
                request(MediaType.APPLICATION_JSON).get();
        //process the response object

        Response.StatusType status = response.getStatusInfo();

        int statusCode = status.getStatusCode();
        if (statusCode == OK_STATUS) {

            System.out.println(response.readEntity(String.class));
        } else {
            System.out.printf("Service returned status: \"%d %s\"\n", statusCode, status.getReasonPhrase());
        }
    }
}
