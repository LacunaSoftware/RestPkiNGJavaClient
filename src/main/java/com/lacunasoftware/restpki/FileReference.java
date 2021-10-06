package com.lacunasoftware.restpki;


import com.lacunasoftware.restpki.FileReferenceModel;

import java.io.*;
import java.net.URI;

/**
 * FileReference
 */
public class FileReference {
    private RestPkiService service;
    private InputStream stream;
    private String path;
    private byte[] content;
    private final String name;
    private final String mimeType;
    private final long length;
    private final String url;
    private String blobToken;
    public boolean canRead(){
        return this.service != null || this.url == null;
    }

    public String getBlobToken() {
        return blobToken;
    }
    public String getName() {
        return this.name;
    }
    public String getMimeType() {
        return this.mimeType;
    }
    public long getLength() {
        return this.length;
    }
    public String getUrl() { return this.url; }

    private FileReference(String name, String mimeType, long length, String url, InputStream stream, String path, byte[] content) {
        this.name = name;
        this.mimeType = mimeType;
        this.length = length;
        this.url = url;
        this.stream = stream;
        this.path = path;
        this.content = content;
    }

    private FileReference(RestPkiService service, FileReferenceModel model) {
        this.service = service;
        this.name = model.getName();
        this.mimeType = model.getMimeType();
        this.length = model.getLength();
        this.url = model.getUrl();
        this.blobToken = model.getBlobToken();
    }

    public static FileReference fromStream(InputStream stream, String name, String mimeType) {
        if (stream == null) {
            throw new IllegalArgumentException("Stream cannot be null");
        }
        return new FileReference(name, mimeType, 0, null, stream, null, null);
    }

    public static FileReference fromFile(String path, String name, String mimeType) {
        if (path == null) {
            throw new IllegalArgumentException("Path cannot be null");
        }
        if (path.isEmpty()) {
            throw new IllegalArgumentException("Cannot reference an empty path");
        }
        return fromFile(new File(path), name, mimeType);
    }

    public static FileReference fromFile(File file, String name, String mimeType) {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        return new FileReference(name, mimeType, file.length(), null, null, file.getPath(), null);
    }

    public static FileReference fromBytes(byte[] bytes, String name, String mimeType) {
        if (bytes == null) {
            throw new IllegalArgumentException("Bytes cannot be null");
        }
        if (bytes.length == 0) {
            throw new IllegalArgumentException("Cannot reference an empty byte array");
        }
        return new FileReference(name, mimeType, bytes.length, null, null, null, bytes);
    }

    public static FileReference fromUrl(String url, String name, String mimeType) {
        if (url == null) {
            throw new IllegalArgumentException("URL cannot be null");
        }
        if (url.isEmpty()) {
            throw new IllegalArgumentException("Cannot reference an empty url");
        }
        URI uri = URI.create(url);
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("Cannot reference a relative url");
        }
        return new FileReference(name, mimeType, 0, url, null, null, null);
    }

    public InputStream openRead() throws Exception {
        if (!this.canRead()) {
            throw new IllegalArgumentException("This FileReference cannot be read");
        }
        if (this.stream != null) {
            return this.stream;
        } else if (this.content != null) {
            return new ByteArrayInputStream(this.content);
        } else if (this.path != null) {
            return new FileInputStream(new File(path));
        } else if (this.url != null) {
            return service.openRead(this.url); // `service` is guaranteed to be not null here (see CanRead)
        } else {
            throw new RuntimeException("Should not happen case"); // should not happen
        }
    }

    public byte[] getContent() throws Exception {
        if (this.content != null) {
            return this.content;
        }
        InputStream stream = this.openRead();
        return Util.readStream(stream);
    }
}