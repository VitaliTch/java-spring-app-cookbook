package com.algocrafters.store.couchbase.entity.travel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Airline entity class to start with Couchbase 'travel-sample' bucket example.
 *
 */
@Document
@TypeAlias(("airline"))
@NoArgsConstructor @Setter @Getter
public class Airline {
    @Id
    private String id;

    private String callsign;

    private String country;

    private String iata;

    private String icao;

    private String name;

    private String type;

    @PersistenceCreator
    public Airline(String id, String callsign, String country, String iata, String icao, String name, String type) {
        this.id = id;
        this.callsign = callsign;
        this.country = country;
        this.iata = iata;
        this.icao = icao;
        this.name = name;
        this.type = type;
    }
}
