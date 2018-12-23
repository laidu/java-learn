package org.elasticsearch.license;

import org.apache.lucene.util.*;
import org.elasticsearch.common.io.*;
import org.elasticsearch.common.xcontent.*;

public class LicenseVerifier
{
    public static boolean verifyLicense(final License license, final byte[] encryptedPublicKeyData) {
        return true;
    }

    public static boolean verifyLicense(final License license) {
        return true;
    }
}
