package com.gl.ceir.alerts;

public class AlertConfigDto {
    String alertId;

    public AlertConfigDto(String alertId) {
        this.alertId = alertId;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }
}
