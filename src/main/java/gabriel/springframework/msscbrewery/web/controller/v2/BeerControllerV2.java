package gabriel.springframework.msscbrewery.web.controller.v2;

import gabriel.springframework.msscbrewery.services.v2.BeerServiceV2;
import gabriel.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }
    @PostMapping //POST - CREATE A NEW BEER
    public ResponseEntity handlePost(@NotNull @RequestBody BeerDtoV2 beerDto){

        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("location", "/api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PutMapping({"/beerId"})
    public ResponseEntity handleUpdate(@PathVariable("beerID") UUID beerId, @RequestBody BeerDtoV2 beerDto){
        beerServiceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT );
    }
    @DeleteMapping({"/beerId"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerID") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }


};
