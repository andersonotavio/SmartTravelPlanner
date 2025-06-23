package com.otavioweb.SmartTravelPlanner.repository;

import com.otavioweb.SmartTravelPlanner.model.TravelItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelItemRepository extends JpaRepository<TravelItemModel, Long> {
}
