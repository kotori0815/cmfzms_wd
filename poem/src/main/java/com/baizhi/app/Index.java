package com.baizhi.app;

import com.baizhi.entity.Poetry;
import com.baizhi.entity.Poet;
import com.baizhi.service.PoetryService;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wd199 on 2017/6/24.
 */

public class Index {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object poetDao = context.getBean("poetryService");
        PoetryService service = (PoetryService) poetDao;
        List<Poetry> poetryList = service.queryAll();


        try {
            FSDirectory fsDirectory = FSDirectory.open(Paths.get("F:\\ＪＡＶＡ＿ＢＡＩＺＨＩ\\Data\\后期项目\\poets\\index"));

            IndexWriter indexWriter = new IndexWriter(fsDirectory, new IndexWriterConfig(new StandardAnalyzer()));

            for (Poetry poetry : poetryList) {

                Document document = new Document();

                document.add(new IntField("id", poetry.getId(), Field.Store.YES));
                document.add(new StringField("title", poetry.getTitle(), StringField.Store.YES));
                document.add(new TextField("poet", poetry.getPoet().getName(), TextField.Store.YES));
                document.add(new TextField("content", poetry.getContent(), TextField.Store.YES));
                // 日期类型
                indexWriter.addDocument(document);
            }
            indexWriter.commit();
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, Object> searchByHighLighter(int page, int size, String keyWord,String type) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            FSDirectory fsDirectory = FSDirectory.open(Paths.get("F:\\ＪＡＶＡ＿ＢＡＩＺＨＩ\\Data\\后期项目\\poets\\index"));
            //FSDirectory fsDirectory = FSDirectory.open(Paths.get("E:\\后期项目\\lucene资料\\index\\thirdIndex"));
            DirectoryReader directoryReader = DirectoryReader.open(fsDirectory);
            // 所有文档数
            directoryReader.maxDoc();
            // 有索引的文档数
            directoryReader.numDocs();

            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

            QueryParser queryParser;

            if (type.equals("poem")){
                queryParser= new QueryParser("content", new StandardAnalyzer());
            }else {
                queryParser= new QueryParser("poet", new StandardAnalyzer());
            }


            Query query = queryParser.parse(keyWord);

            TopDocs topDocs = null;

            // 第一页直接检索
            if (page == 1) {
                topDocs = indexSearcher.search(query, size);
            } else {
                // 计算start
                int start = (page - 1) * size;
                topDocs = indexSearcher.search(query, start);
                // 最后一个ScoreDoc对象
                // 参数一：当前页的上一页的最后一个ScoreDoc对象  参数二：检索条件  参数：查几条
                // searchAfter：从参数一的ScoreDoc对象后 进行检索，并检索参数三 条文档
                topDocs = indexSearcher.searchAfter(topDocs.scoreDocs[topDocs.scoreDocs.length - 1], query, size);
            }
            // 获取命中数  符合条件总条数
            // 总页数：
            System.out.println("总命中数：" + topDocs.totalHits);

            // 指定高亮格式
            SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<span style='color:red'>", "</span>");

            // 创建Scorer
            QueryScorer queryScorer = new QueryScorer(query);
            // 创建高亮器
            Highlighter highlighter = new Highlighter(formatter, queryScorer);

            ScoreDoc[] scoreDocs = topDocs.scoreDocs;

            ArrayList<Poetry> list = new ArrayList<Poetry>();

            for (ScoreDoc scoreDoc : scoreDocs) {

                System.out.println("文档得分：" + scoreDoc.score);

                int docId = scoreDoc.doc;
                Document document = indexSearcher.doc(docId);

                String highlighterBestFragment = highlighter.getBestFragment(new StandardAnalyzer(), "content", document.get("content"));
                System.out.println(document.get("id") + "  " + document.get("title") + "  " + highlighterBestFragment + "  " + document.get("poet"));

                Poetry poetry = new Poetry();
                poetry.setId(Integer.valueOf(document.get("id")));
                poetry.setTitle(document.get("title"));
                poetry.setContent(highlighterBestFragment);
                Poet poet = new Poet();
                poet.setName(document.get("poet"));
                poetry.setPoet(poet);
                poetry.setScore(Double.valueOf(scoreDoc.score));
                list.add(poetry);
            }
            map.put("total", topDocs.totalHits);
            map.put("poetryList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
