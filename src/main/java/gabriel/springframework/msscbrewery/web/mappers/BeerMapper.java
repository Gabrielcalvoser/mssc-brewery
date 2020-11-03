package gabriel.springframework.msscbrewery.web.mappers;

import gabriel.springframework.msscbrewery.domain.BeerDomain;
import gabriel.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerDomainToBeerDto (BeerDomain beerDomain);

    BeerDomain beerDtoToBeerDomain( BeerDto beerDto);
}
