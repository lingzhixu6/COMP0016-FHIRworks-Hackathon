package FHIRtoSpeech;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FHIRdb {

    // one instance, reuse
    private final CloseableHttpClient httpClient = HttpClients.createDefault();


    public void close() throws IOException {
        httpClient.close();
    }

    public String sendPostAndReturnAccessToken() throws Exception {

        HttpPost post = new HttpPost("https://login.microsoftonline.com/ca254449-06ec-4e1d-a3c9-f8b84e2afe3f/oauth2/v2.0/token");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
        urlParameters.add(new BasicNameValuePair("client_id", "0f6332f4-c060-49fc-bcf6-548982d56569"));
        urlParameters.add(new BasicNameValuePair("client_secret", "ux@CJAaxCD85A9psm-Wdb?x3/Z4c6gp9"));
        urlParameters.add(new BasicNameValuePair("scope", "https://gosh-fhir-synth.azurehealthcareapis.com/.default"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        post.setHeader("content-type", "application/x-www-form-urlencoded");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post))
        {
            String accessToken = extractAccessToken(EntityUtils.toString(response.getEntity()));
            return accessToken;
        }
    }


    public String sendGetReqAndReturnGetResult(String accessToken, String FHIRuri) throws Exception {

        FHIRuri = "https://gosh-fhir-synth.azurehealthcareapis.com" +
                "/Observation?patient=8f789d0b-3145-4cf2-8504-13159edaa747&ct=eyJ0b2tlbiI6IitSSUQ6fmNxcDBBS2s1dG13cUFBQUFBQUFBQUE9PSNSVDoxI1RSQzoxMCNJU1Y6MiNJRU86NjU1NTEjUUNGOjEjRlBDOkFnRUFJUUFhQUN3QUFQd0FSM2JqbVBkaFFMdGdxNlVVSXBRbFFJd1dRUnNBSVFRQUlUZ09BQT09IiwicmFuZ2UiOnsibWluIjoiIiwibWF4IjoiRkYifX0%3D";
        HttpGet request = new HttpGet(FHIRuri);
        String bearerToken = "Bearer"+" "+accessToken;
        request.addHeader("Authorization", bearerToken);

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String fhirResult = EntityUtils.toString(entity);
                return fhirResult;
            }
        }
        return "";
    }


    private String extractAccessToken(String jsonResultContainingAccessToken) {
        JsonUtility jsonUtility = new JsonUtility();

        JsonElement jsonTreeContainingAccessToken = jsonUtility.parseRawJsonIntoJsonTree(jsonResultContainingAccessToken);
        if(jsonUtility.checkJsonTreeType(jsonTreeContainingAccessToken) == "JsonObject") {
            JsonObject jsonObject = jsonTreeContainingAccessToken.getAsJsonObject();
            JsonElement accessToken = jsonObject.get("access_token");
            return accessToken.toString();
        }
        return "";
    }
}

