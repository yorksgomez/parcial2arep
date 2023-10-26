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
        get("lucasseq", (req,res) -> {
            res.type("application/json");
            return Request.request(RoundRobin.getCurrentApi() + "lucasseq?value=" + req.queryParams("value"));
        });

        get("/", (req, res) -> {
           res.type("text/html");
            return getIndex();
        });

    }

    private static int getPort() {
        if (System.getenv("PROXY_PORT") != null) {
            return Integer.parseInt(System.getenv("PROXY_PORT"));
        }
        return 4567;
    }

    private static String getIndex() {
        return "<html>\n" +
                "<head>\n" +
                "\t<title>SECUENCIA LUCAS</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<form method=\"get\" id=\"form\">\n" +
                "\t\tNumero para lucas: <input type=\"number\" name=\"value\"> <input type=\"submit\" value=\"Lucas!\">\n" +
                "\t</form>\n" +
                "\t<div id=\"result\">\n" +
                "\t\n" +
                "\t</div>\n" +
                "\t<script>\n" +
                "\t\tlet form = document.querySelector(\"#form\");\n" +
                "\t\t\n" +
                "\t\tform.addEventListener(\"submit\", (ev) => {\n" +
                "\t\t\tev.preventDefault();\n" +
                "\t\t\t\n" +
                "\t\t\tfetch(\"/lucasseq?value=\" + form.elements.value.value).then(res => res.json()).then(json => {\n" +
                "\t\t\t\tconsole.log(json); document.querySelector(\"#result\").innerText = \"El resultado es \" + json.output;\n" +
                "\t\t\t});\n" +
                "\t\t\t\n" +
                "\t\t});\n" +
                "\t\t\n" +
                "\t</script>\n" +
                "</body>\n" +
                "</html>";
    }

}

