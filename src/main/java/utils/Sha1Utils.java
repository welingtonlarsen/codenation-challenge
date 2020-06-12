package utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Sha1Utils {

    public static String createSha1Hash(String dataToHash) {
        return DigestUtils.sha1Hex(dataToHash);
    }

}
