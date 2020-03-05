package FHIRtoSpeech;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        new Main().demoRun();
    }

    public void demoRun() {
        ExtractFHIR extractFHIR = new ExtractFHIR();
        Text_to_Speech tts = new Text_to_Speech();
        String fhirResult;

        try {
            fhirResult = new String(Files.readAllBytes(Paths.get("Patient_Observation_Sample.json")));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String ttsInput = extractFHIR.extractObservationName(fhirResult)
                + extractFHIR.extractObservationValue(fhirResult)
                + extractFHIR.extractObservationUnit(fhirResult);
        tts.generateSpeechFileFromInputText(ttsInput);
    }

    public void realRun(String FHIRuri) {
        ExtractFHIR extractFHIR = new ExtractFHIR();
        Text_to_Speech tts = new Text_to_Speech();

        String fhirResult = new Main().retrieveFhirData(FHIRuri);

        String ttsInput = extractFHIR.extractObservationName(fhirResult)
                + extractFHIR.extractObservationValue(fhirResult)
                + extractFHIR.extractObservationUnit(fhirResult);
        tts.generateSpeechFileFromInputText(ttsInput);

    }

    private String retrieveFhirData(String FHIRuri) {
        FHIRdb fhirDb = new FHIRdb();

        try {
            String accessToken = fhirDb.sendPostAndReturnAccessToken();
            String fhirResult = fhirDb.sendGetReqAndReturnGetResult(accessToken, FHIRuri);  //Method only works for FHIR from /api/Observation/patient ID
            fhirDb.close();
            return fhirResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }



}
