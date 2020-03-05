//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//public class FHIRTool {
//
//    public String fhirToJson(String fhirData) throws Exception{
//        String JsonFormat = sendGetandReturnGetResult("https://fhir-json-tool.azurewebsites.net/api/fhir-json-tool");
//        return JsonFormat;
//    }
//
//
//    private String sendGetandReturnGetResult(String uri) throws Exception {
//
//        HttpGet request = new HttpGet(uri);
//
//        try (CloseableHttpResponse response = HttpClients.createDefault().execute(request)) {
//
//            HttpEntity entity = response.getEntity();
//
//            if (entity != null) {
//                // return it as a String
//                String result = EntityUtils.toString(entity);
//                return result;
//            }
//        }
//        return "";
//    }
//}
