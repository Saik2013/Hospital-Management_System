package com.acciojob.basicapilearning;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("v2")  :---> What is the benefit
public class ApiClass {
    Map<Integer,Patient> patientDb = new HashMap<>();

    @GetMapping("/addPatient")
    public String addPatientToDb(@RequestParam("patientId") int patientId,
                                 @RequestParam("name") String name,
                                 @RequestParam("age") int age,
                                 @RequestParam("disease") String disease){
        Patient patient = new Patient( patientId, name, age, disease);
        int key = patientId;
        patientDb.put(key,patient);
        return "patient has been added to DB";
    }

    @GetMapping("/findOldestPatient")
    public Patient findOldPatient(){
        int patientId = -1;
        int maxAge = 0;
        for(Patient patient: patientDb.values()){
            if(patient.getAge() > maxAge){
                patientId = patient.getPatientId();
                maxAge = patient.getAge();
            }
        }
        return patientDb.get(patientId);
    }
    @PostMapping("/addPatientViaReqBody")
    public String addPatientToDbViaReqBody(@RequestBody Patient patient){
        int key = patient.getPatientId();
        patientDb.put(key,patient);
        return "patient has been added";
    }
    @GetMapping("/getPatientInfo")
    public Patient gettingPatientInfo(@RequestParam(value = "patientId",required = false)int patientId,
                                      @RequestParam(value = "name", required = false)String name){
        if(name != null){
            for(Patient patient : patientDb.values()){
                if(patient.getName().equals(name)){
                    return patient;
                }
            }
        }
        int key = patientId;
        Patient patient = patientDb.get(key);
        System.out.println(patient);
        return patient;
    }
    @GetMapping("/viewPatient/{patientId}/")
    public String viewpatient(@PathVariable("patientId") int patientId){
        Patient patient = patientDb.get(patientId);
        return patient.toString();
    }
}