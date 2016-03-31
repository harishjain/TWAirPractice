package com.twair;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    private List<Flight> flightList;

    public FlightSearch(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public FlightSearch byLocation(String source, String destination) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }

    public FlightSearch bySeatAvailability(String noOfSeats) {
        int noOfSeatsIntValue = 1;
        try {
            noOfSeatsIntValue = Integer.parseInt(noOfSeats);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("number of seats should be a number");
        }
        return bySeatAvailability(noOfSeatsIntValue);
    }

    public FlightSearch bySeatAvailability(int noOfSeats) {
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getPlane().getNumberOfSeats() >= noOfSeats) {
                matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }
}
