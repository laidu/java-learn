package org.laidu.commom.util.http.curl;

import jodd.util.StringUtil;
import jodd.util.URLDecoder;
import org.laidu.commom.util.regex.RegexUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * curl example (brup suite) :
 * curl -i -s -k  -X $'POST' \
 * -H $'Content-Type: application/x-www-form-urlencoded' -H $'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36' \
 * --data-binary $'client_id=77185425430.apps.googleusercontent.com&client_secret=OTJgUOQcT7lO7GsGZq2G4IlT&grant_type=refresh_token&refresh_token=1/YBcVnG-meman9MWGGnYSTaAjhWTPsJr56Y9Dvdcq7U-ezbiSqz23f43SaTRiBOnY&scope=https://www.googleapis.com/auth/cusco-chrome-extension' \
 * $'https://www.googleapis.com/oauth2/v4/token'
 * <p>
 * <p>
 * curl -i -s -k  -X $'POST' \
 * -H $'Content-Type: application/x-www-form-urlencoded' -H $'User-Agent: Dalvik/2.1.0 (Linux; U; Android 6.0.1; Redmi 3 Build/M4B30X)' \
 * --data-binary $'pcn=com.zhaoqianhua.cash&screen=%28720%2C1280%29&dpi=%28320%2C320%29&ak=Xz4E3L0mcVhwhAktoDoHCXbtOAsKPG1L&macaddr=MDI6MDA6MDA6MDA6MDA6MDA%3D%0A++++&url=https%3A%2F%2Fapi.map.baidu.com%2Fsdkcs%2Fverify&appid=-1&mb=Redmi+3&from_service=lbs_androidsdk&net=0&from=lbs_yunsdk&os=Android23&sv=4.0.0&imt=1&output=json&cuid=F663AF9A1E6D8107A06B4AB7DFC5BD38%7C87374814251&mcode=FA%3A8A%3AD5%3AE1%3A57%3A30%3A03%3A1D%3A48%3A2E%3A44%3A9B%3AFB%3AF2%3AEE%3A7A%3ABE%3AE5%3AED%3AFF%3Bcom.zhaoqianhua.cash&resid=02&version=1.0.6&name=%E6%89%BE%E9%92%B1%E8%8A%B1&language=zh&ver=1' \
 * $'https://api.map.baidu.com/sdkcs/verify'
 * @author tczang
 */
public final class CurlParserUtilV2 {

    private final String curlLine;

    /**
     * Private constructor.
     * @param curl
     */
    private CurlParserUtilV2(String curl) {
        this.curlLine = curl;
    }

    /**
     * @return Singleton instance
     */
    public static CurlParserUtilV2 init(String curl) {
        return new CurlParserUtilV2(curl);
    }

    private Map<String, String> keyValuePairs() {
        Map<String, String> keyValuePairs = new HashMap<>();
        String headePattern = "(-H \\$'([^:]*:[^']*)')+";
        int headDataIndex = 2;
        List<String> headerList = RegexUtil.getInstance().getMacthAllResult(headePattern, curlLine, headDataIndex);
        headerList.forEach(header ->{
            String[] keyValue = header.split(":", 2);
            if (keyValue.length == 2) {
                keyValuePairs.put(keyValue[0].trim(), URLDecoder.decode(keyValue[1].trim()));
            }
        });

        return keyValuePairs;
    }

    public Map<String, String> getHeaders() {

        Map<String, String> keyValuePairs = keyValuePairs();

        keyValuePairs.remove("Content-Length");

        return keyValuePairs;
    }

    public Map<String, String> getCookies() {

        Map<String, String> cookieMap = new HashMap<>();

        StringBuilder cookiesString = new StringBuilder();

        cookiesString.append(getHeaders().get("Cookie"));
        cookiesString.append(getBCookiesString());

        if (StringUtil.isNotBlank(cookiesString.toString())) {
            String cookiesPattern = "([^; ]*=[^;]*)+";
            List<String> cookieStringList = RegexUtil.getInstance().getMacthAllResult(cookiesPattern,cookiesString.toString());

            cookieStringList.forEach(cookie -> {
                String[] cookiePairs = cookie.split("=", 2);
                if (cookiePairs.length == 2) {
                    cookieMap.put(cookiePairs[0].trim(), URLDecoder.decode(cookiePairs[1].trim()));
                }
            });
        }

        return cookieMap;
    }

    private String getBCookiesString() {

        String bHeaderPattrern = "-b \\$'([^']*)'";
        int bHeaderIndex = 1;
        return RegexUtil.getInstance().getMacthResult(bHeaderPattrern, curlLine, bHeaderIndex);
    }


    public String getMethod() {
        String methodPattern = "-X \\$'([A-Z]{2,5})'";
        int methodIndex = 1;
        return RegexUtil.getInstance().getMacthResult(methodPattern, curlLine, methodIndex, "GET");
    }


    public String getUrl() {
        String urlPattern = "\\$'(https?://.*)'";
        int urlIndex = 1;
        return RegexUtil.getInstance().getMacthResult(urlPattern, curlLine, urlIndex);
    }

    public String getBodyString() {
        String stringBodyPattern = "--data-binary \\$'([^\\$]*)'";
        int stringBodyIndex = 1;
        return RegexUtil.getInstance().getMacthResult(stringBodyPattern, curlLine, stringBodyIndex);
    }

    public Map<String, String> getFormBody() {
        Map<String, String> formMap = new HashMap<>();

        String formBodyString = getBodyString();

        String formDataPattern = "([^=&]+=[^&']*)+";
        int formDataIndex = 1;
        List<String> formStringList = RegexUtil.getInstance().getMacthAllResult(formDataPattern, formBodyString, formDataIndex);

        formStringList.forEach(formString -> {

            String[] form = formString.split("=",2);
            if (form.length==2) {
                formMap.put(form[0].trim(),form[1].trim());
            }
        });

        return formMap;
    }


}

