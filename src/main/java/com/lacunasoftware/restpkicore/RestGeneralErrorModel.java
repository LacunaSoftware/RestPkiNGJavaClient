package com.lacunasoftware.restpkicore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by desenv on 28/08/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class RestGeneralErrorModel {
    public String message;
}
