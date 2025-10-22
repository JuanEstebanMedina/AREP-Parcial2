package co.edu.escuelaing.proxy;

import java.io.IOException;
import java.net.ConnectException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    private static final String URL1 = "http://localhost:8081/catalan";
    private static final String URL2 = "http://localhost:8082/catalan";

    // EC2 instances
    // private static final String URL1 = "http://35.175.219.160:8081/catalan";
    // private static final String URL2 = "http://52.90.160.34:8081/catalan";

    @GetMapping("/catalan")
    public String catalan(@RequestParam(defaultValue = "10") String value) throws IOException {
        try {
            return HttpConnectionExample.httpConnection(URL1 + "?value=" + value);
        } catch (ConnectException e) {
            return HttpConnectionExample.httpConnection(URL2 + "?value=" + value);
        }
    }
}
