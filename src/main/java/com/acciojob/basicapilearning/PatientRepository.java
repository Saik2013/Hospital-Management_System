package com.acciojob.basicapilearning;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class PatientRepository {
    Map<Integer,Patient> patientDb = new HashMap<>();

    public String addToDb(Patient patient){
        Integer key = patient.getPatientId();
        patientDb.put(key,patient);
        return "patient has been added";
    }
    public List<Patient> getAllPatients(){
        List<Patient> ansList = new ArrayList<>();
        for(Patient patient : patientDb.values()){
            ansList.add(patient);
        }
        return ansList;
    }

}
