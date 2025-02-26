package local.jotape.airports.controllers;
     
import local.jotape.airports.service.AirportService;
import java.util.List;
import local.jotape.airports.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
