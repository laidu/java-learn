package org.laidu.crawler.helper.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * helper config
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelperConfig {

    private String codePath;
    private String codePackage;
    private String templeFilePath;
    private String xmlFilePath;
}