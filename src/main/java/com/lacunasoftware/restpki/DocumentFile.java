package com.lacunasoftware.restpki;

import java.io.InputStream;

/**
 * DocumentFile
 */
public class DocumentFile {

    private RestPkiService service;
    private DocumentFileModel model;

    public String getName() {
        return model.getName();
    }

    public long getLength() {
        return model.getLength();
    }

    public String getContentType() {
        return model.getContentType();
    }

    public String getLocation() {
        return model.getLocation();
    }

    public boolean canRead() {
        return (model.getLocation() != null);
    }

    public DocumentFile(RestPkiService service, DocumentFileModel model) {
        this.service = service;
        this.model = model;
    }

    public InputStream OpenReadAsync(){ 
        return service.OpenReadAsync(getLocation());
    }

    public byte[] GetContentAsync(){
        return service.GetContentAsync(getLocation());
    }
}