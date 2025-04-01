package com.gl.ceir.alerts;

import com.gl.ceir.alerts.constants.AlertIds;
import com.gl.ceir.alerts.constants.AlertMessagePlaceholders;

import java.util.Map;

public interface AlertService {

    void sendAlertNow(AlertIds alertIds, Map<AlertMessagePlaceholders, String> placeHolderMap);

    void sendAlert(AlertIds alertIds, Map<AlertMessagePlaceholders, String> placeHolderMap);
}
