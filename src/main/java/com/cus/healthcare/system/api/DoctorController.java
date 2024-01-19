package com.cus.healthcare.system.api;


import com.cus.healthcare.system.dto.request.RequestDoctorDto;
import com.cus.healthcare.system.service.DoctorService;
import com.cus.healthcare.system.service.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //this is a rest controller
@RequestMapping("/api/v1/doctors")//api path
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping //post method
    public ResponseEntity<StandardResponse> createDoctor(@RequestBody RequestDoctorDto doctorDto) {
        doctorService.createDoctor(doctorDto);

        StandardResponse standardResponse = new StandardResponse(201, "Doctor Add Successfully", doctorDto);

        return new ResponseEntity<>(standardResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public String getDoctor(@PathVariable String id){

        return "Get Doctor"+id;
    }


    @PutMapping(params = "id")
    public String updateDoctor(

            @RequestParam String id,
            @RequestBody RequestDoctorDto doctorDto

    ){

        return doctorDto.toString()+id;
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable String id){

        return id+"Delete Doctor";
    }

    @GetMapping(path = "/list" ,params = {"searchText","page","size"})
    public String getDoctorList(

            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size

    ){

        return "List Doctor";
    }


}
