package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ValidDataByDistance extends Capabilities {






    @ParameterizedTest
    @CsvFileSource(resources = "/dataFiles/gpsCoordinates.csv", numLinesToSkip = 1)
    void availableVehiclesNumberByGPSCoordinates(String lat, String lon){

    }
}
