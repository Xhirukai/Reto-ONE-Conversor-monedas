import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {

    ValorConversion obtenerValorConversion (String base_code, String target_code){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6674f980ee31ca211383056d/pair/" + base_code + "/" + target_code);

        HttpClient clienteHttp = HttpClient.newHttpClient();
        HttpRequest peticionHttp = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> respuestaHttp = null;
        try {
            respuestaHttp = clienteHttp
                    .send(peticionHttp, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(respuestaHttp.body(), ValorConversion.class);
    }


}
