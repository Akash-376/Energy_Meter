package com.electricity.model;


import java.time.LocalDate;
import lombok.Data;

/**
 * The `HourlyConsumptionObject` class represents an object containing hourly energy consumption data.
 * It is used to encapsulate information about energy consumption for a specific date and hour.
 * It is not an Entity.
 */

@Data
public class HourlyConsumptionObject {
	/**
     * The date for which the hourly energy consumption is recorded.
     */
    private LocalDate con_date;
    
    /**
     * The hour during which the energy consumption is recorded (in "HH:00" format).
     */
    private String con_Hour;
    
    /**
     * The hourly energy consumption value for the specified date and hour.
     */
    private Double hourlyConsumption;
    
    /**
     * Default constructor for the `HourlyConsumptionObject` class.
     */
    public HourlyConsumptionObject() {}
    
    /**
     * Constructor to create a `HourlyConsumptionObject` with specified values.
     *
     * @param con_date The date for which the hourly consumption is recorded.
     * @param con_Hour The hour during which the consumption is recorded (in "HH:00" format).
     * @param hourlyConsumption The hourly energy consumption value.
     */
	public HourlyConsumptionObject(LocalDate con_date, String con_Hour, Double hourlyConsumption) {
		this.con_date = con_date;
		this.con_Hour = con_Hour;
		this.hourlyConsumption = hourlyConsumption;
	}

    
}
