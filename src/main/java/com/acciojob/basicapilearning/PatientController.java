package com.acciojob.basicapilearning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/addpatientViaReqBody")

    public ResponseEntity addPatientToDbViaReqBody(@RequestBody Patient patient){
        Patient ans = patientService.findOldestPatient();
        if(ans != null){
            return new ResponseEntity("No patients were present in DB",HttpStatus.EXPECTATION_FAILED);

        }
        return new ResponseEntity(ans,HttpStatus.OK);
    }
    @GetMapping("/viewPatient/{patientId}/")
    public ResponseEntity viewPatient(@PathVariable("patientId") int patientId){
        Patient patient = patientService.getPatientInfo(patientId);
        if(patient == null){
            return new ResponseEntity("No valid patient found",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(patient,HttpStatus.OK);
    }
}
