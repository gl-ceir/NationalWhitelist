package com.gl.ceir.alerts;

import com.gl.ceir.alerts.constants.AlertIds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AlertConfig {

    @Value("${alert.feature-name:}")
    private String featureName = "national_whitelist";
    @Value("${alert.url}")
    private String url;

    private Map<AlertIds, AlertConfigDto> alertsMapping;

    @PostConstruct
    public void init() {
        alertsMapping = new HashMap<>();
        alertsMapping.put(AlertIds.DATABASE_EXCEPTION, new AlertConfigDto("alert016"));
        alertsMapping.put(AlertIds.DATABASE_TABLE_EXCEPTION, new AlertConfigDto("alert016"));
        alertsMapping.put(AlertIds.MODULE_EXECUTED_WITH_EXCEPTION, new AlertConfigDto("alert1209"));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<AlertIds, AlertConfigDto> getAlertsMapping() {
        return alertsMapping;
    }

    public void setAlertsMapping(Map<AlertIds, AlertConfigDto> alertsMapping) {
        this.alertsMapping = alertsMapping;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}
