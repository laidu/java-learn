package org.laidu.crawler.helper.har.model;
import lombok.Data;

/**
 * This object contains information about the log creator application and contains the following name/value pairs:
 */
@Data
public class Creator {

    /**
     * Required. The name of the application that created the log.
     */
    private String name;

    /**
     * Required. The version number of the application that created the log.
     */
    private String version;

    /**
     * Optional. A comment provided by the user or the application.
     */
    private String comment;
}
