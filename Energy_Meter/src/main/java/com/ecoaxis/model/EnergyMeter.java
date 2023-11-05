package com.ecoaxis.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The `EnergyMeter` class represents an entity for storing energy consumption data.
 * It is used to store information related to energy consumption at specific timestamps.
 * This class is mapped to the "energy_meter_data" table in the database.
 */

@Entity
@Data
@Table(name = "energy_meter_data")
public class EnergyMeter {
	
	/**
     * Unique identifier for the energy meter data.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * The timestamp when the energy consumption data was recorded.
     */
    @Column(name = "timestamp", unique = true)
    private LocalDateTime timestamp;

    /**
     * The per minute incremental energy consumption value.
     */
    @Column(name = "min")
    private double min_value;

    /**
     * The hourly energy consumption value.
     */
    @Column(name = "hours")
    private double hour_value;

    /**
     * Default constructor for the `EnergyMeter` class.
     */
    public EnergyMeter() {}
    
    /**
     * Constructor to create an `EnergyMeter` object with a timestamp and per minute incremental value.
     *
     * @param timestamp A string representation of the timestamp in "yyyy-MM-dd HH:mm:ss" format.
     * @param min_value The per minute energy incremental value.
     */
	public EnergyMeter(String timestamp, double min_value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsedTimestamp = LocalDateTime.parse(timestamp, formatter);
		this.timestamp = parsedTimestamp;
		this.min_value = min_value;
	}
    
    


}
