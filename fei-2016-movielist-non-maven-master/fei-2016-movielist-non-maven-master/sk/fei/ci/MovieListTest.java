package sk.fei.ci;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;
import spark.utils.IOUtils;

public class MovieListTest {

	/**
	 * Start service
	 */
    @BeforeClass
    public static void beforeClass() {
    	MovieList.main(null);
    }

    /**
     * Stop service
     * 
     */
    @AfterClass
    public static void afterClass() {
        Spark.stop();
    }

    /**
     * Simple service test.
     * Check response status and response body.
     */
    @Test
    public void testService() throws IOException {
        TestResponse res = makeRequest("GET", "/hello");
        assertEquals(200, res.status);
        assertNotNull(res.body); 
        assertEquals("Hello World<br/>Save private ryan", res.body);
    }

    private TestResponse makeRequest(String method, String path) throws IOException {
        URL url = new URL("http://localhost:4567" + path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        connection.connect();
        String body = IOUtils.toString(connection.getInputStream());
        return new TestResponse(connection.getResponseCode(), body);
    }

    private static class TestResponse {
        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }
    }
}