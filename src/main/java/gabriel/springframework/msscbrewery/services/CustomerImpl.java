package gabriel.springframework.msscbrewery.services;

import gabriel.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerImpl implements CustomerService{
    @Override
    public CustomerDto getCustomerId(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).customerName("Antonio el de los periquitos").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // para actualizar el customer
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting a Customer...");
    }
}
