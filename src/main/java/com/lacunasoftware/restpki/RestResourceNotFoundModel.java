package com.lacunasoftware.restpki;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by desenv on 28/08/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class RestResourceNotFoundModel extends RestGeneralErrorModel {
    public String resourceName;
    public String resourceId;
}
