package FHIRtoSpeech;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.apache.commons.lang3.NotImplementedException;

public class ExtractFHIR {
    //FHIR is from /api/Observation/patient ID
    //All the methods below only work for this particular FHIR format

    JsonElement jsonTreeRoot;
    JsonUtility jsonUtility = new JsonUtility();
    JsonArray jsonArray;


    private void initJsonTree(String fhirResult) {
        jsonTreeRoot = new JsonUtility().parseRawJsonIntoJsonTree(fhirResult);
        String jsonTreeRootType = jsonUtility.checkJsonTreeType(jsonTreeRoot);
        if(jsonTreeRootType == "JsonArray") {
            jsonArray = jsonTreeRoot.getAsJsonArray();
        } else {
            throw new NotImplementedException("Non-JsonArray is not supported in this demo");
        }
    }

    public String extractObservationName(String fhirResult) {
        if (jsonTreeRoot == null)
            initJsonTree(fhirResult);
        if(jsonUtility.checkJsonTreeType(jsonTreeRoot) == "JsonArray") {
            JsonElement observationName = jsonArray.get(0).getAsJsonObject()
                    .get("entry").getAsJsonArray().get(0).getAsJsonObject()
                    .get("resource").getAsJsonObject()
                    .get("code").getAsJsonObject()
                    .get("text");
            return observationName.toString();
        }
        return "";
    }

    public String extractObservationValue(String fhirResult) {
        if (jsonTreeRoot == null)
            initJsonTree(fhirResult);
        if(jsonUtility.checkJsonTreeType(jsonTreeRoot) == "JsonArray") {
            JsonElement observationValue = jsonArray.get(0).getAsJsonObject()
                    .get("entry").getAsJsonArray().get(0).getAsJsonObject()
                    .get("resource").getAsJsonObject()
                    .get("valueQuantity").getAsJsonObject()
                    .get("value");
            return observationValue.toString();
        }
        return "";
    }

    public String extractObservationUnit(String fhirResult) {
        if (jsonTreeRoot == null)
            initJsonTree(fhirResult);
        if(jsonUtility.checkJsonTreeType(jsonTreeRoot) == "JsonArray") {
            JsonElement observationUnit = jsonArray.get(0).getAsJsonObject()
                    .get("entry").getAsJsonArray().get(0).getAsJsonObject()
                    .get("resource").getAsJsonObject()
                    .get("valueQuantity").getAsJsonObject()
                    .get("unit");
            return observationUnit.toString();
        }
        return "";
    }

}
