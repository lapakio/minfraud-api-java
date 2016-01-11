package com.maxmind.minfraud.response;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxmind.geoip2.record.Country;

import java.util.List;
import java.util.Map;

/**
 * This class contains minFraud response data related to the GeoIP2 Insights
 * country.
 */
public final class GeoIp2Country extends Country {
    private final boolean isHighRisk;

    public GeoIp2Country(
            @JacksonInject("locales") List<String> locales,
            @JsonProperty("confidence") Integer confidence,
            @JsonProperty("geoname_id") Integer geoNameId,
            @JsonProperty("is_high_risk") boolean isHighRisk,
            @JsonProperty("iso_code") String isoCode,
            @JsonProperty("names") Map<String, String> names
    ) {
        super(locales, confidence, geoNameId, isoCode, names);
        this.isHighRisk = isHighRisk;
    }

    public GeoIp2Country() {
        this(null, null, null, false, null, null);
    }

    /**
     * @return This value is true if the IP country is high risk.
     */
    @JsonProperty("is_high_risk")
    public boolean isHighRisk() {
        return this.isHighRisk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeoIp2Country{");
        sb.append("isHighRisk=").append(this.isHighRisk);
        sb.append(", super:").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
