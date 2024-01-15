package com.algocrafters.app.cookbook.service.travel;

import com.algocrafters.app.cookbook.store.couchbase.repository.AirlineRepository;
import com.algocrafters.store.couchbase.entity.travel.Airline;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TravelService {
    private final AirlineRepository airlineRepository;

    public TravelService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<Airline> findAirlines(@Nullable String searchParams) {
        if (StringUtils.isBlank(searchParams)) {
            return airlineRepository.findAll();
        }
        // TODO: implement search and filtering by searchParams
        Optional<Airline> airline = Optional.empty();

        return airline.map(List::of).orElse(Collections.emptyList());
    }
}
