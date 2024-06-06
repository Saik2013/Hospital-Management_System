package com.acciojob.basicapilearning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public String addPatientToDb(Patient patient){
        String response = patientRepository.addToDb(patient);
        return response;
        //call Repository Layer method
        //that saves to the DB.
    }

    public Patient findOldestPatient(){
        List<Patient> patientList =  patientRepository.getAllPatients();
        Patient patientAns = null;
        int maxAge = 0;
        for(Patient patient : patientList){
            if(patient.getAge() > maxAge){
                patientAns = patient;
                maxAge = patient.getAge();
            }
        }
        return patientAns;
    }

    public Patient getPatientInfo(int patientId){
        List<Patient> patients = patientRepository.getAllPatients();
        return patients.get(patientId);
    }
}
