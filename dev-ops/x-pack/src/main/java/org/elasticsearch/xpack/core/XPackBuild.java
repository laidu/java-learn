package org.elasticsearch.xpack.core;

import org.elasticsearch.common.*;
import org.elasticsearch.common.io.*;

public class XPackBuild
{
    public static final XPackBuild CURRENT;
    private String shortHash;
    private String date;

    @SuppressForbidden(reason = "looks up path of xpack.jar directly")
    static Path getElasticsearchCodebase() {
        final URL url = XPackBuild.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            return PathUtils.get(url.toURI());
        }
        catch (URISyntaxException bogus) {
            throw new RuntimeException(bogus);
        }
    }

    XPackBuild(final String shortHash, final String date) {
        this.shortHash = shortHash;
        this.date = date;
    }

    public String shortHash() {
        return this.shortHash;
    }

    public String date() {
        return this.date;
    }

    static {
        final Path path = getElasticsearchCodebase();
        String shortHash = null;
        String date = null;
        Label_0157: {

            shortHash = "Unknown";
            date = "Unknown";
        }
        CURRENT = new XPackBuild(shortHash, date);
    }
}
