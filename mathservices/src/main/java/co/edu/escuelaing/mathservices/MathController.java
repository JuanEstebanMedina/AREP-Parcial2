package co.edu.escuelaing.mathservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/greeting")
    public MathServiceResponse catalan(@RequestParam(defaultValue = "10") int value) {
        return new MathServiceResponse("Secuencia de Catalan", value, catalanSecuence(value));
    }

    private String catalanSecuence(int value) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
