package org.laidu.crawler.helper.har.model;

import lombok.Data;

/**
 *
 * This object contains information about the browser that created the log and contains the following name/value pairs:
 */
@Data
public class Browser {

    /**
     * Required. The name of the browser that created the log.
     */
    private String name;

    /**
     * Required. The version number of the browser that created the log.
     */
    private String version;

    /**
     * Optional. A comment provided by the user or the browser.
     */
    private String comment;
}
