package co.edu.escuelaing.proxy;

import java.io.IOException;
import java.net.HttpRetryException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    private static final String URL1 = "http://35.175.219.160:8081/catalan";
    private static final String URL2 = "http://52.90.160.34:8082/catalan";

    @GetMapping("/catalan")
    public String greeting(@RequestParam(defaultValue = "10") int value) throws HttpRetryException, IOException {
        try {
            return HttpConnectionExample.httpConnection(URL1 + "?value=" + value);
        } catch (Exception e) {
            return HttpConnectionExample.httpConnection(URL2 + "?value=" + value);
        }
        // return new MathServiceResponse("Secuencia de Catalan", value,
        // String.format(template, value));
    }

}
