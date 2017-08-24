package com.wuyi.wcrawler.service;

import com.wuyi.wcrawler.bean.CrawlerUrlBean;

import java.util.List;

/**
 * Created by wuyi5 on 2017/8/17.
 */
public interface CrawlerUrlService {
    List<CrawlerUrlBean> fetchUrl(int shardingItem, int ShardingTotalCount);
    void crawler(List<CrawlerUrlBean> urls);
}
