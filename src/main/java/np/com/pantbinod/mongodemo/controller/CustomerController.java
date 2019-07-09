package np.com.pantbinod.mongodemo.controller;

import np.com.pantbinod.mongodemo.model.Customer;
import np.com.pantbinod.mongodemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CustomerController {


    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String startUp() {
        return "index";
    }

    @RequestMapping(value = "/api/v1/customers" , method = RequestMethod.GET)
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @PostMapping(value = "/api/v1/customers")
    public List<Customer> saveCustomer(@RequestBody Customer customer){
        System.out.println(customer.toString());
        customerRepository.save(customer);
       return customerRepository.findAll();
    }

    @DeleteMapping("/api/v1/customers/{id}")
    public Map<String,String> deleteCustomer(@PathVariable String id){
        customerRepository.deleteById(id);
        Map data = new HashMap();
        data.put("message", "success");
        data.put("data", null);
        return data;

    }


    @PutMapping(value = "/api/v1/customers/{id}")
    public Optional<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer){
            customer.set_id(id);
          customerRepository.save(customer);
        return customerRepository.findById(id);
    }



}
