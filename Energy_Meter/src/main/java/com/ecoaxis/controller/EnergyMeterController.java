package com.ecoaxis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecoaxis.model.EnergyMeter;
import com.ecoaxis.model.HourlyConsumptionObject;
import com.ecoaxis.service.EnergyMeterService;

/**
 * The `EnergyMeterController` class defines REST endpoints for managing energy consumption data.
 * It handles HTTP requests related to inserting energy meter readings, fetching hourly energy consumption data,
 * and retrieving energy meter table values.
 */
@RestController
public class EnergyMeterController {
	
	@Autowired
	private EnergyMeterService energyMeterService;
	
	/**
     * Handles the HTTP POST request for inserting an energy meter reading with a specified timestamp and per-minute Incremental reading value.
     *
     * @param timeStamp       The timestamp for the energy consumption data in "yyyy-MM-dd HH:mm:ss" format.
     * @param perMinReading   The per-minute Incremental reading.
     * @return A ResponseEntity containing a message indicating the success or failure of the insertion.
     */
	@PostMapping("/insert/{timeStamp}/{perMinReading}")
	public ResponseEntity<String> insertEnergyMeterReadingHandler(@PathVariable String timeStamp, @PathVariable Double perMinReading){
		
		String result = energyMeterService.insertEnergyMeterValue(timeStamp, perMinReading);
		
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		
	}
	
	/**
     * Handles the HTTP GET request for fetching hourly energy consumption data.
     *
     * @return A ResponseEntity containing a list of `HourlyConsumptionObject` instances representing hourly energy consumption data.
     */
	@GetMapping("/fetchHourlyConsumption")
	public ResponseEntity<List<HourlyConsumptionObject>> getHourlyEnergyConsumptionHandler(){
		
		List<HourlyConsumptionObject> hourlyRecord = energyMeterService.calculateHourlyEnergyConsumption();
		
		return new ResponseEntity<>(hourlyRecord, HttpStatus.OK);
	}
	
	/**
     * Handles the HTTP GET request for fetching energy meter table values.
     *
     * @return A ResponseEntity containing a list of `EnergyMeter` instances representing energy meter table values.
     */
	@GetMapping("/fetchTableValues")
	public ResponseEntity<List<EnergyMeter>> fetchTableValuesHandler(){
		
		List<EnergyMeter> meterReadings = energyMeterService.fetchTableValue();
		
		return new ResponseEntity<>(meterReadings, HttpStatus.OK);
		
	}
	
}
