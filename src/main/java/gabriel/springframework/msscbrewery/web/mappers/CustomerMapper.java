package gabriel.springframework.msscbrewery.web.mappers;

import gabriel.springframework.msscbrewery.domain.CustomerDomain;
import gabriel.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerDomainToCustomerDto (CustomerDomain customerDomain);

    CustomerDomain customerDtoToCustomerDomain (CustomerDto customerDto);
}
