package com.gl.ceir.alerts;

import com.gl.ceir.alerts.constants.AlertMessagePlaceholders;

import java.util.Map;

public class AlertDto {

    private String alertId;

    private String alertProcess;

    private Map<AlertMessagePlaceholders, String> placeHolderMap;

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getAlertProcess() {
        return alertProcess;
    }

    public void setAlertProcess(String alertProcess) {
        this.alertProcess = alertProcess;
    }

    public Map<AlertMessagePlaceholders, String> getPlaceHolderMap() {
        return placeHolderMap;
    }

    public void setPlaceHolderMap(Map<AlertMessagePlaceholders, String> placeHolderMap) {
        this.placeHolderMap = placeHolderMap;
    }
}
