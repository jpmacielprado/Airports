/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.jotape.airports.service;

import local.jotape.airports.repositories.AirportRepository;
import java.util.List;
import local.jotape.airports.DTO.AirportMinDTO;
import local.jotape.airports.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesideva
 */
@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll(){
        
        List<Airport> result = airportRepository.findAll();
        return result;
    }
    
     /**retorna DTO Airports filtrado por cidade.
         * @param city
         * @return
         */
        public List<Airport> findByCity(String city) {
            List<Airport> result = airportRepository.findByCityIgnoreCase(city);
            return result;
        }
        
        /**Retorna DTO AirportsMinDTO filtrado por Country
         * 
         * @param country
         * @return
         */
        public List<AirportMinDTO> findByCountry(String country){
            List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
            
            List<AirportMinDTO> resultDTO = resultAirport.stream()
                  .map(x -> new AirportMinDTO(x)).toList();
            
            return resultDTO;
        }
        
        /**
         * Retorna DTO Airport por iataCode
         * @param iataCode
         * @return
         */
        public Airport findByIataCode(String iataCode) {
            Airport result = airportRepository.findByIataCode(iataCode);
            return result;
        }
}
