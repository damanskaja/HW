import de.telran.g_280323_m_be_shop.domain.entity.common.CommonCustomer;
import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Customer;
import de.telran.g_280323_m_be_shop.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody CommonCustomer customer) {
        try {
            service.add(customer);
            return new ResponseEntity<>("Customer added successfully", HttpStatus.OK);
        } catch (CustomerValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (OtherSpecificException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteByName(@PathVariable String name) {
        service.deleteByName(name);
    }

    @GetMapping("/count")
    public int getCount() {
        return service.getCount();
    }

    @GetMapping("/total/{id}")
    public double getTotalPrice(@PathVariable int id) {
        return service.getTotalPriceById(id);
    }

    @GetMapping("/average/{id}")
    public double getAverage(@PathVariable int id) {
        return service.getAveragePriceById(id);
    }

    @GetMapping("/{customerId}/{productId}")
    public void addToCart(@PathVariable int customerId, @PathVariable int productId) {
        service.addToCartById(customerId, productId);
    }

    @DeleteMapping("/{customerId}/{productId}")
    public void deleteFromCart(@PathVariable int customerId, @PathVariable int productId) {
        service.deleteFromCartById(customerId, productId);
    }

    @DeleteMapping("/clear/{customerId}")
    public void clearCart(@PathVariable int customerId) {
        service.clearCartById(customerId);
    }
}
