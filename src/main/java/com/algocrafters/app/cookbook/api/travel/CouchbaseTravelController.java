package com.algocrafters.app.cookbook.api.travel;

import com.algocrafters.app.cookbook.service.travel.TravelService;
import com.algocrafters.store.couchbase.entity.travel.Airline;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A sample API for getting started with Couchbase by utilizing the sample data bucket 'travel-sample'.
 *
 * @author Vitali Tchalov (github.com/VitaliTch)
 * @since 0.1
 */
@RestController
@RequestMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CouchbaseTravelController {

    private final TravelService travelService;

    public CouchbaseTravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping(value = "/public/travel/airlines")
    public ResponseEntity<List<Airline>> findAirlines(@RequestParam(value = "searchCriteria", required = false) String searchCriteria) {
        return ResponseEntity.ok(travelService.findAirlines(searchCriteria));
    }
}
