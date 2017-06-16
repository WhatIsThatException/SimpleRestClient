package main;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by kpant on 6/16/17.
 *
 * Parses a JSON file containing a USD to EUR exchange rate from http://rate-exchange-appspot.com
 */
public class JSONMain {
    private static final String JSON_FILE_NAME = "rate-exchange.json";

    /**
     * Parse and display the JSON file
     * */
    public static void main(String[] args) {
        try {
            JsonParser parser = Json.createParser(new FileReader(JSON_FILE_NAME));

            while(parser.hasNext()) {
                JsonParser.Event event = parser.next();
                if(event.equals(JsonParser.Event.KEY_NAME)) {
                    String key = parser.getString();
                    parser.next();
                    String value = parser.getString();
                    System.out.printf(">> %s: %s\n", key, value);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
