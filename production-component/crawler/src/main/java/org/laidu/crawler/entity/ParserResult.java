package org.laidu.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import us.codecraft.webmagic.Request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * crawler parser result
 *
 * @author tiancai.zang  2018-01-10 17:26.
 */
@Data
@Builder
public class ParserResult {
    private final List<Result> results = new ArrayList<>();
    private final List<Request> requests = new ArrayList<>();

    /**
     * Add result.
     *
     * @param result the result
     */
    public void addResult(Result result){
        results.add(result);
    }

    /**
     * Add results.
     *
     * @param resultList the result list
     */
    public void addResults(List<Result> resultList){
        results.addAll(resultList);
    }

    /**
     * Add request.
     *
     * @param request the request
     */
    public void addRequest(Request request){
        requests.add(request);
    }

    /**
     * Add requests.
     *
     * @param requestList the request list
     */
    public void addRequests(List<Request> requestList){
        requests.addAll(requestList);
    }

    /**
     * The type Result.
     *
     * @param <T> the type parameter
     */
    @Data
    @Builder
    @AllArgsConstructor
    public static class Result<T>{
        private final Date crawlerDate = new Date();
        private T data;
    }
}