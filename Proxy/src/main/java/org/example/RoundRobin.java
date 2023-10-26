package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class RoundRobin {

    private static ArrayList<String> apis = null;
    private static int position = 0;

    public static ArrayList<String> getApiList() {

        if(apis == null) {
            String apistr = System.getenv("APIS");
            apis = new ArrayList<>(Arrays.asList(apistr.split(";")));
        }

        return apis;
    }

    public static String getCurrentApi() {
        String api = getApiList().get(position % getApiList().size());
        position++;

        if(position >= getApiList().size())
            position = 0;

        return api;
    }


}
