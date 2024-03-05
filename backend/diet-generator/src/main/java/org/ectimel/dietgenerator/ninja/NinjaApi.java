package org.ectimel.dietgenerator.ninja;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NinjaApi {

    @Value("${ninja-api-key}")
    private String ninjaApiKey;

    @Value("${ninja-api-endpoint}")
    private String ninjaApiEndpoint;

    public NinjaItem getNinjaItem(String query) {

        RestClient restClient = RestClient.create();
        String URI = ninjaApiEndpoint + query;

        NinjaResponse ninjaResponse = restClient.get()
                .uri(URI)
                .header("X-Api-Key", ninjaApiKey)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(NinjaResponse.class);

        assert ninjaResponse != null;
        return ninjaResponse.getItems().getFirst();
    }

}
