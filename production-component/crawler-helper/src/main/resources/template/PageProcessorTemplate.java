package __PACKAGE_NAME__;

import com.alpha.business.common.model.query.base.StringQueryRequest;
import com.alpha.business.crawler.AbstractRegPageProcessor;
import com.alpha.common.enums.crawler.PlatformCodeEnum;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;

import java.text.ParseException;

/**
 * __CLASS_CN_NAME__
 * <p>
 * Created by PageProcessorGen on __DATE__.
 */
@Slf4j
//@Component
public class __CLASS_NAME__PageProcessor extends AbstractRegPageProcessor {

    public __CLASS_NAME__PageProcessor() {
        super(PlatformCodeEnum.REG.__ENUM_NAME__);
    }

    @Override
    public PlatformCodeEnum.RegisterSiteResult parseResult(Page page) throws ParseException {

        __PARSER__
        return PlatformCodeEnum.RegisterSiteResult.ERROR;
    }

    @Override
    public Request gen(StringQueryRequest task) throws Exception {
        return Request.__METHOD__("__URL__").putExtra("mobile", task.getData());
    }

    @Override
    protected Site getSite(Request request) {

        return super.getSite(request)
        __HEADERS__
                __BODY__;
    }

    /**
     * encryptionSource : __ENCRYPTION_SOURCE__
     * encryptionAlgorithm : __ENCRYPTION_ALGORITHM__
     * encryptionKey : __ENCRYPTION_KEY__
     * encryptionIvp : __ENCRYPTION_IVP__
     */
    __SIGN__

    public static void main(String[] args) throws InterruptedException {

        for (; ; ) {
            new __CLASS_NAME__PageProcessor().getSpider().processWithResponse(new StringQueryRequest(""));
            Thread.sleep(500);
            new __CLASS_NAME__PageProcessor().getSpider().processWithResponse(new StringQueryRequest(""));
        }
    }
}