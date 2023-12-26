package utils;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
/**
 * ScenarioContext is used to store any data to be shared between the steps inside scenario
 */
public class ScenarioContext {

    public static final String API_RESPONSE = "api_response";

    private static final Logger logger = LoggerFactory.getLogger(ScenarioContext.class);

    private static final Map<String, Object> context = new HashMap<>();

    public static <T> void set(String key, T value) {
        logger.info("Store data with key {} into scenario context", key);
        context.put(key, value);
    }

    public static <T> T get(String key, Class<T> tClass) {
        try {
            if (!context.containsKey(key)) {
                throw new RuntimeException("Scenario context does not contain key" + key);
            }
            return tClass.cast(context.get(key));
        } catch (ClassCastException e) {
            return null;
        }
    }

    public static Response getApiResponse() {
        return get(API_RESPONSE, Response.class);
    }

    public static void clear() {
        context.clear();
    }
}
