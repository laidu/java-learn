package org.laidu.commom.util.http.curl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.http.core.HttpRequest;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * curl command line parser
 * <p>
 * Created by tiancai.zang on 2017-11-04 13:09.
 */
@Slf4j
public class CurlParser {

    // curl 'https://www.yourendai.com/front/register.do'
    // -H 'origin: https://www.yourendai.com' -H 'accept-encoding: gzip, deflate, br' -H 'x-requested-with: XMLHttpRequest' -H 'accept-language: zh-CN,zh;q=0.8,en;q=0.6,fr;q=0.4' -H 'user-agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Mobile Safari/537.36' -H 'content-type: application/x-www-form-urlencoded; charset=UTF-8' -H 'accept: application/json, text/javascript, */*; q=0.01' -H 'referer: https://www.yourendai.com/loan/login.shtml' -H 'authority: www.yourendai.com'
    // -H 'cookie: JSESSIONID=F0D546A4B187A0523BB557EAD932705F; Hm_lvt_d10f34537b0c4098a0fdcc2756cb3556=1509952606; Hm_lpvt_d10f34537b0c4098a0fdcc2756cb3556=1509952606; UM_distinctid=15f903051aec6-0a6c0f3720750f-31657c03-1aeaa0-15f903051afa33; CNZZDATA1000517132=557184276-1509951908-null%7C1509951908; SERVERID=b37e1f387f49faf03d05e2a80347e29b|1509952628|1509952599'
    // --data 'cmd=checkTel&loginName=15638147989&type=login' --compressed
    public static HttpRequest parser(String curlCommand){

        HttpRequest httpRequest = HttpRequest.builder().build();

        /**
         * step 1 : remove line break
         */
//        curlCommand.replaceAll("\\","");

        /**
         * step 2 : get all header
         */
        Pattern p = Pattern.compile("-H '.'");
        Matcher m = p.matcher(curlCommand);
        while (m.find()){
            log.info("m.group(0)'s value : {}", m.group(0));
        }

        /**
         * step 3 : get request method
         */
        /**
         * step 4 : get request body
         */

        return httpRequest;
    }




    public static void main(String[] args) throws ParseException, org.apache.commons.cli.ParseException {

        final String curlLine = "curl -i -s -k  -X $'POST' \\\n" +
                "    -H $'Content-Type: application/x-www-form-urlencoded' -H $'User-Agent: Dalvik/2.1.0 (Linux; U; Android 6.0.1; Redmi 3 Build/M4B30X)' \\\n" +
                "    -H $'Content-Type: application/x-www-form-urlencoded' -H $'User-Agent: Dalvik/2.1.0 (Linux; U; Android 6.0.1; Redmi 3 Build/M4B30X)' \\\n" +
                "    --data-binary $'pcn=com.zhaoqianhua.cash&screen=%28720%2C1280%29&dpi=%28320%2C320%29&ak=Xz4E3L0mcVhwhAktoDoHCXbtOAsKPG1L&macaddr=MDI6MDA6MDA6MDA6MDA6MDA%3D%0A++++&url=https%3A%2F%2Fapi.map.baidu.com%2Fsdkcs%2Fverify&appid=-1&mb=Redmi+3&from_service=lbs_androidsdk&net=0&from=lbs_yunsdk&os=Android23&sv=4.0.0&imt=1&output=json&cuid=F663AF9A1E6D8107A06B4AB7DFC5BD38%7C87374814251&mcode=FA%3A8A%3AD5%3AE1%3A57%3A30%3A03%3A1D%3A48%3A2E%3A44%3A9B%3AFB%3AF2%3AEE%3A7A%3ABE%3AE5%3AED%3AFF%3Bcom.zhaoqianhua.cash&resid=02&version=1.0.6&name=%E6%89%BE%E9%92%B1%E8%8A%B1&language=zh&ver=1' \\\n" +
                "    $'https://api.map.baidu.com/sdkcs/verify'";

        String headerPattern = "(-H \\$'([^:]*:[^']*)')+";


        Pattern header = Pattern.compile(headerPattern);
        Matcher HeaderMatcher = header.matcher(curlLine);

        while (HeaderMatcher.find()){
            System.out.println(HeaderMatcher.group(2));
        }

        String formDataPattern = "([^=&]+=[^&']*)+";
        Pattern form = Pattern.compile(formDataPattern);
        Matcher formDataMatcher = form.matcher(curlLine);
        while (formDataMatcher.find()){
            System.out.println(formDataMatcher.group(1));
        }

    }
}