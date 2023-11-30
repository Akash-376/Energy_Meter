package com.electricity.service;

import java.util.List;

import com.electricity.exception.NotFoundException;
import com.electricity.model.EnergyMeter;
import com.electricity.model.HourlyConsumptionObject;


/**
 * The `EnergyMeterService` interface defines the service methods for managing energy consumption data.
 * It provides methods for inserting energy meter values, calculating hourly energy consumption,
 * and fetching table values.
 */
public interface EnergyMeterService {
	
	/**
     * Inserts an energy meter value with the specified timestamp and per minute incremental value.
     *
     * @param timeStamp ,The timestamp for the energy consumption data in "yyyy-MM-dd HH:mm:ss" format.
     * @param min_IncrementValue, The per minute increment value for energy consumption.
     * @return A message indicating the success or failure of the insertion.
     */
	public String insertEnergyMeterValue (String timeStamp, double min_IncrementValue);
	
	/**
     * Calculates and retrieves hourly energy consumption data as a list of `HourlyConsumptionObject` instances.
     *
     * @return A list of `HourlyConsumptionObject` instances representing per hour consumption data.
     */
	public List<HourlyConsumptionObject> calculateHourlyEnergyConsumption();
	
	/**
     * Fetches table values of energy meter data and returns them as a list of `EnergyMeter` instances.
     *
     * @return A list of `EnergyMeter` instances representing the energy meter table values.
     * @throws NotFoundException if the data is not found.
     */
	public List<EnergyMeter> fetchTableValue() throws NotFoundException;
	
}
