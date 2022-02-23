package com.dardell.businesscard;

import com.dardell.businesscard.model.Employee;
import com.dardell.businesscard.model.Me;
import com.dardell.businesscard.service.EmployeeService;
import com.dardell.businesscard.service.MeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/me")
public class MeResource {
    private final MeService meService;

    public MeResource(MeService meService) {
        this.meService = meService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Me> getMe(@PathVariable("id") Long id){
        Me me = meService.findMeById(id);
        return new ResponseEntity<>(me, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Me> addEmployee(@RequestBody Me me) {
        Me newMe = meService.addMe(me);
        return new ResponseEntity<>(newMe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Me> updateEmployee(@RequestBody Me me) {
        Me updateMe = meService.updateMe(me);
        return new ResponseEntity<>(updateMe, HttpStatus.OK);
    }

}
