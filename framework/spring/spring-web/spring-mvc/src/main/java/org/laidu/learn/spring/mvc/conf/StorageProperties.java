package org.laidu.learn.spring.mvc.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * StorageProperties
 *
 * @author tiancai.zang
 * on 2018-10-11 11:10.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}