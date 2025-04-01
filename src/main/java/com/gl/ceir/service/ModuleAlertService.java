package com.gl.ceir.service;

import com.gl.ceir.alerts.AlertConfig;
import com.gl.ceir.alerts.AlertService;
import com.gl.ceir.alerts.constants.AlertIds;
import com.gl.ceir.alerts.constants.AlertMessagePlaceholders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ModuleAlertService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AlertService alertService;

    @Autowired
    AlertConfig alertConfig;

    public void sendAlert(AlertIds alertIds, Map<AlertMessagePlaceholders, String> placeHolderMap) {
        alertService.sendAlert(alertIds, placeHolderMap);
    }


    public void sendConfigurationMissingAlert(String configKey, String featureName) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.CONFIG_KEY, configKey);
        map.put(AlertMessagePlaceholders.FEATURE_NAME, featureName);
        alertService.sendAlertNow(AlertIds.CONFIGURATION_VALUE_MISSING, map);
    }

    public void sendDatabaseAlert(String error) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.EXCEPTION, error.length() > 200 ? error.substring(0, 200) : error);
        map.put(AlertMessagePlaceholders.FEATURE_NAME, alertConfig.getFeatureName());
        if (error.contains("doesn't exist")) {
            alertService.sendAlertNow(AlertIds.DATABASE_TABLE_EXCEPTION, map);
        } else {
            alertService.sendAlertNow(AlertIds.DATABASE_EXCEPTION, map);
        }
    }

    public void sendSmsNotSentAlert(String error, String sms) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.EXCEPTION, error);
        map.put(AlertMessagePlaceholders.SMS, sms);
        alertService.sendAlert(AlertIds.NOTIFICATION_SEND_EXCEPTION, map);
    }

    public void sendConfigurationWrongValueAlert(String configKey, String configValue, String featureName) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.CONFIG_KEY, configKey);
        map.put(AlertMessagePlaceholders.CONFIG_VALUE, configValue);
        map.put(AlertMessagePlaceholders.FEATURE_NAME, featureName);
        alertService.sendAlertNow(AlertIds.CONFIGURATION_VALUE_WRONG, map);
    }

    public void sendModuleExecutionAlert(String error) {
        Map<AlertMessagePlaceholders, String> map = new HashMap<>();
        map.put(AlertMessagePlaceholders.EXCEPTION, error);
        map.put(AlertMessagePlaceholders.FEATURE_NAME, alertConfig.getFeatureName());
        alertService.sendAlert(AlertIds.MODULE_EXECUTED_WITH_EXCEPTION, map);
    }


}
