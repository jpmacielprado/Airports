package local.jotape.airports.controllers;
     
import local.jotape.airports.service.AirportService;
import java.util.List;
import local.jotape.airports.DTO.AirportMinDTO;
import local.jotape.airports.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    /**
     * Endpint /airport/airport
     * Retorna TODOS os aeroportos da base de dados
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }
    
    /**EndPoint /airports/city/{city name}
     * @param cityName
     * @return
     */
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> finByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);
        
        if (result.isEmpty()) {
            // ops... lista vazia
            // not found devolve 404
            return ResponseEntity.notFound().build();
        } else {
            //boa! tem dados
            //devolvo ok 202
            return ResponseEntity.ok(result);
            
        }
    }
    
    /**EndPoint /airports/city/{city name}
     * @param countryName
     * @return
     */
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
        
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        if (result.isEmpty()) {
            //ops.. lista vazia
            //devolve erro 404
            return ResponseEntity.notFound().build();
            
        } else {
            //ae, tem dados
            // devolve ok 200
            return ResponseEntity.ok(result);
        }
        
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);
        
        if (result == null) {
            //ops.. Aeroporto vazio
            //notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else{
            //Tem dados
            //ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
}
