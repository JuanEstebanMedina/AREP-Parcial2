package co.edu.escuelaing.mathservices;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private static final HashMap<Integer, Integer> resultsMap = new HashMap<>();

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
        System.out.println("map: " + resultsMap);
        return sb.toString();
    }

    private int catalanNumber(int value) {
        if (value == 0)
            return 1;

        if (resultsMap.containsKey(value))
            return resultsMap.get(value);

        int sum = 0;
        for (int i = 0; i < value; i++) {
            sum += (catalanNumber(i) * catalanNumber(value - 1 - i));
        }

        resultsMap.put(value, sum);
        return sum;
    }
}
