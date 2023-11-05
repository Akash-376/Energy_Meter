package com.ecoaxis.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecoaxis.exception.NotFoundException;
import com.ecoaxis.model.EnergyMeter;
import com.ecoaxis.model.HourlyConsumptionObject;
import com.ecoaxis.repository.EnergyMeterRepository;


/**
 * The `EnergyMeterServiceImpl` class provides the implementation of service methods for managing energy consumption data.
 */
@Service
public class EnergyMeterServiceImpl implements EnergyMeterService{
	
	@Autowired
	private EnergyMeterRepository energyMeterRepository;

	
	
	@Override
	public String insertEnergyMeterValue(String timeStamp, double min_IncrementValue) {
		
		// creating new meter reading on the bases of per minute incremental value
		EnergyMeter currentMeterReading = new EnergyMeter(timeStamp.trim(), min_IncrementValue);
		
		// fetching previous or latest record from the database
		EnergyMeter previousReading = energyMeterRepository.getLatestEnergyRecordFromDB();
		
		if(previousReading == null) {
			currentMeterReading.setHour_value(0.0);
		}else {
			double hourValue = Math.abs(min_IncrementValue - previousReading.getMin_value());
			currentMeterReading.setHour_value(hourValue);
		}
		
		energyMeterRepository.save(currentMeterReading);
		
		return "Record added to the database";
	}

	@Override
	public List<HourlyConsumptionObject> calculateHourlyEnergyConsumption() {
		// TODO Auto-generated method stub
		
		// fetching the hourly consumption energy data from database
		List<Object[]> hourlyConsumptionList =  energyMeterRepository.getHourlyConsumptionData();
		
		// creating an empty ArrayList to add HourlyConsumptionObject by extracting from hourlyConsumptionList
		List<HourlyConsumptionObject> list = new ArrayList<>();
		
		// logic to create HourlyConsumptionObject list out of hourlyConsumptionList
		for(Object[] record : hourlyConsumptionList) {
			HourlyConsumptionObject obj = new HourlyConsumptionObject();
			
			// Extract the date value from the first element (record[0]) in the Object[] array,
			// it's a java.sql.Date, and convert it to a LocalDate.
			java.sql.Date sqlDate = (java.sql.Date) record[0];
	        LocalDate conDate = sqlDate.toLocalDate();
			obj.setCon_date(conDate);
			obj.setCon_Hour((String) record[1]);
			obj.setHourlyConsumption((Double) record[2]);
			
			list.add(obj);
			
		}
		
		return list;
	}

	@Override
	public List<EnergyMeter> fetchTableValue() throws NotFoundException{
		
		// fetching all the records of Energy Meter from the database
		List<EnergyMeter> energyMeterReadings = energyMeterRepository.findAll();
		
		if(energyMeterReadings.isEmpty()) throw new NotFoundException("Table is empty");
		
		return energyMeterReadings;
		
	}

}
