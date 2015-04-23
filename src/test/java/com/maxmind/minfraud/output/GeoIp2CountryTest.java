package com.maxmind.minfraud.output;

import com.fasterxml.jackson.jr.ob.JSON;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeoIp2CountryTest extends AbstractOutputTest {


    @Test
    public void testIsHighRisk() throws Exception {
        GeoIp2Country country = deserialize(
                GeoIp2Country.class,
                JSON.std
                        .composeString()
                        .startObject()
                        .put("is_high_risk", true)
                        .end()
                        .finish()
        );

        assertTrue(country.isHighRisk());
    }
}