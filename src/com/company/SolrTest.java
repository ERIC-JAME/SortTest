package com.company;

/**
 * 添加及更新索引
 */
//public class SolrTest {
//    private String solrUrl = "http://localhost:8081/solr";
//
//    public void testUpdateIndex() {
//        //创建solr服务对象，通过此对象想solr服务发送请求
//        SolrServer solrServer = new HttpSolrServer(solrUrl);
//        //创建document
//        SolrInputDocument solrInputDocument = new SolrInputDocument();
//        //向文件中添加域
//        solrInputDocument.addField();
//        solrInputDocument.addField();
//        solrInputDocument.addField();
//        solrInputDocument.addField();
//        solrInputDocument.addField();
//
//        //创建索引
//        SolrServer.add(solrInputDocument);
//
//        //提交
//        SolrServer.commit();
//    }
//
//    /**
//     * 删除索引
//     */
//    public void deleteIndex(){
//        //创建solr服务对象，通过此对象想solr服务发送请求
//        SolrServer solrServer = new HttpSolrServer(solrUrl);
//        //通过主键id删除
//        solrServer.deleteById("225");
//
//        //自定义查询id删除
//        solrServer.deleteByQuery("id:225");
//
//        //提交
//        SolrServer.commit();
//    }
//
//    /**
//     * 搜索方法
//     */
////    public void testSearchIndex() throws Exception{
////        //创建solr服务对象，通过此对象向solr服务发起请求
////        SolrServer solrServer = new HttpSolrServer(solrUrl);
////        //创建查询对象
////        SolrQuery query = new SolrQuery();
////        //设置查询关键字,q不能省
////        query.set("q","product_keywords:枕头");
////
////        //指定过滤
////        query.set("fq","product_price:[1 TO 40]");
////        query.set("fq","product_catalog_name:幽默杂货");
////
////        //排序
////        //参数：filed域，排序类型(desc降/asc升)
////        query.addSort("product_price",SolrQuery.ORDER.desc);
////
////        //分页
////        //实际开发时，知道当前页码和每页显示的个数最后求出开始下标
////        int curPage = 1;
////        int rows = 15;
////    }
//}
