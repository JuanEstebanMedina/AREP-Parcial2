package co.edu.escuelaing.mathservices;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private static final HashMap<Integer, String> results = new HashMap<>();

    @GetMapping("/catalan")
    public MathServiceResponse catalan(@RequestParam(defaultValue = "10") int value) {
        return new MathServiceResponse("Secuencia de Catalan", value, catalanSecuence(value));
    }

    private String catalanSecuence(int value) {
        if (value < 0)
            return "invalid value";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= value; i++) {
            sb.append(catalanNumber(i));

            if (i < value)
                sb.append(", ");
        }

        return sb.toString();
    }

    private int catalanNumber(int value) {
        if (value == 0)
            return 1;

        int sum = 0;
        for (int i = 0; i < value; i++) {
            sum += (catalanNumber(i) * catalanNumber(value - 1 - i));
        }

        return sum;
    }
}
