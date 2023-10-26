package org.example;

import java.util.ArrayList;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String... args){
        port(getPort());
        System.out.println("Running on " + getPort() + " port");
        get("lucasseq", (req,res) -> {
            res.type("application/json");
            int value = Integer.valueOf(req.queryParams("value"));
            ArrayList<String> results = new ArrayList<>();

            for(int i = 0; i <= value; i++)
                results.add(String.valueOf(Controller.lucas(i)));

            return "{\"operation\":\"Secuencia de Lucas\",\"input\":" + value + ",\"output\":\"" + String.join(",", results.toArray(new String[]{})) + "\"}";
        });

    }

    private static int getPort() {
        if (System.getenv("MATH_PORT") != null) {
            return Integer.parseInt(System.getenv("MATH_PORT"));
        }
        return 4567;
    }

}

