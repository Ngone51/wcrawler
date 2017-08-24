package com.wuyi.wcrawler.service.impl;

import com.wuyi.wcrawler.bean.CrawlerUrlBean;
import com.wuyi.wcrawler.crawler.Crawler;
import com.wuyi.wcrawler.crawler.UrlCrawler;
import com.wuyi.wcrawler.dao.CrawlerUrlDao;
import com.wuyi.wcrawler.service.CrawlerUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuyi5 on 2017/8/17.
 */

@Service
public class CrawlerUrlServiceImpl implements CrawlerUrlService {
    @Autowired
    CrawlerUrlDao crawlerUrlDao;
    @Autowired
    UrlCrawler urlCrawler;
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<CrawlerUrlBean> fetchUrl(int shardingItem, int shardingTotalCount) {
        Map<String, Object> url_param_map = new HashMap<String, Object>();
        url_param_map.put("shardingItem", shardingItem);
        url_param_map.put("shardingTotalCount", shardingTotalCount);
        List<CrawlerUrlBean> urls = crawlerUrlDao.select(url_param_map);
        if(urls.size() > 0) {
            clockUrl((urls));
        } else {
            return null;
        }
        return urls;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void clockUrl(List<CrawlerUrlBean> urls) {
        List<Integer> ids = new ArrayList<Integer>();
        for(CrawlerUrlBean url : urls) {
            ids.add(url.getId());
        }
        crawlerUrlDao.updateUrlStatus(ids);
    }

    public void crawler(List<CrawlerUrlBean> urls) {

        for (CrawlerUrlBean url: urls) {
            urlCrawler.run(url);
        }
    }
}