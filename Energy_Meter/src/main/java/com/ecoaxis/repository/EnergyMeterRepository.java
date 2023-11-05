package com.ecoaxis.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ecoaxis.model.EnergyMeter;

/**
 * The `EnergyMeterRepository` interface is responsible for defining data access methods for the `EnergyMeter` entity.
 * It extends the JpaRepository interface provided by Spring Data JPA for basic CRUD operations.
 */
public interface EnergyMeterRepository extends JpaRepository<EnergyMeter, Integer>{
	
	
	/**
     * Retrieves the latest energy consumption record from the database.
     *
     * @return The latest energy consumption record, or null if no records are found.
     */
	@Query("SELECT e FROM EnergyMeter e ORDER BY e.id DESC LIMIT 1")
	public EnergyMeter getLatestEnergyRecordFromDB();
	
	
	/**
     * Retrieves aggregated hourly energy consumption data from the database.
     *
     * @return A list of arrays, where each array contains aggregated data for a specific date and hour.
     */
	@Query("SELECT DATE(e1.timestamp) AS con_date, CONCAT(HOUR(e1.timestamp), ':00') AS con_hour, SUM(e1.hour_value) AS hourly_sum "
			+ "FROM EnergyMeter e1 "
			+ "GROUP BY con_date, con_hour")
	List<Object[]> getHourlyConsumptionData();
	
	
	
}
