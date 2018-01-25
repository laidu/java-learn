package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * crawler responses
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-13 11:28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrawlerResponse {


    /**
     * responses name
     */
    private String responseName;

    /**
     * encrypt String
     */
    private String encryptString;

    /**
     * origin content
     */
    private String contentSource;

    /**
     * file path
     */
    private String filedPath;

    /**
     * file value
     */
    private String filedValue;
}