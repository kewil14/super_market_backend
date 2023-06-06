package cm.cti.serviceutilisateur.web_api;

import cm.cti.serviceutilisateur.dto.ResponseDto;
import cm.cti.serviceutilisateur.entities.Address;
import cm.cti.serviceutilisateur.exception.DAOException;
import cm.cti.serviceutilisateur.exception.FormValidationException;
import cm.cti.serviceutilisateur.services.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//pour dire que c est a classe qui gere les web configuration
@RestController
@RequestMapping("api/address")

public class AdresseApi {
    @Autowired
    private AddressService service;

//    creer une addresse
    @PostMapping
    public ResponseDto <Address> create( @RequestBody Address address){
        ResponseDto<Address> response = new ResponseDto<Address>();
        List<String> message = new ArrayList<String>();
        try{
             service.add(address);
             response.setBody(address);

        } catch (DAOException e){
            message.add(e.getMessage());
        }
        if(message.size() != 0) {
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        else{
           response.setStatus(HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/addresses")
    public ResponseDto <List<Address>> getAll(Address address){
        ResponseDto<List<Address>> response = new ResponseDto<List<Address>>();
        List<String> message = new ArrayList<String>();
        try{
            List<Address> list =  service.getAll();
            response.setBody(list);

        } catch (DAOException e){
            message.add(e.getMessage());
        }
        if(message.size() != 0) {
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        else{
            response.setStatus(HttpStatus.OK);
        }
        return response;
    }
    @GetMapping("/{{id}}")

    public ResponseDto <Address> findById( @PathVariable Long id) throws FormValidationException {
        ResponseDto<Address> response = new ResponseDto<Address>();
        List<String> message = new ArrayList<String>();
        try{
            Address add =  service.findId(id);
            response.setBody(add);

        } catch (DAOException e){
            message.add(e.getMessage());
        }
        if(message.size() != 0) {
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        else{
            response.setStatus(HttpStatus.OK);
        }
        return response;
    }
    @DeleteMapping("/{{id}}")
    public ResponseDto <Long> delete( @PathVariable Long id){
        ResponseDto<Long> response = new ResponseDto<Long>();
        List<String> message = new ArrayList<String>();
        try{
            service.delete(id);
            response.setBody(id);

        } catch (DAOException e){
            message.add(e.getMessage());
        }
        if(message.size() != 0) {
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        else{
            response.setStatus(HttpStatus.OK);
        }
        return response;
    }
}


