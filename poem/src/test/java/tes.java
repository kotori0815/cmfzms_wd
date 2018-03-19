import com.baizhi.dao.PoetDao;
import com.baizhi.dao.PoetryDao;
import com.baizhi.entity.Poet;
import com.baizhi.entity.Poetry;
import com.baizhi.service.PoetryService;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Paths;
import java.util.List;

/**
 * Created by wd199 on 2017/6/24.
 */
public class tes {
    @Test
    public void t2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object poetryDao = context.getBean("poetryDao");
        PoetryDao dao = (PoetryDao) poetryDao;
        List<Poetry> poetryList = dao.selectPoetry(new Poetry());
        for (Poetry poetry : poetryList) {
            System.out.println(poetry);
        }
    }

    @Test
    public void t() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object poetDao = context.getBean("poetDao");
        PoetDao dao = (PoetDao) poetDao;
        List<Poet> poets = dao.selectPoet(new Poet());
        for (Poet poet : poets) {
            System.out.println(poet);
        }
    }


    @Test
    public void t3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object poetDao = context.getBean("poetryService");
        PoetryService service = (PoetryService) poetDao;
        List<Poetry> poetryList = service.queryAll();
        for (Poetry poetry : poetryList) {
            System.out.println(poetry);
        }

        Poetry poetry = service.queryOne(9116);
        System.out.println(poetry);
    }



    @Test
    public void searchByHighLighter(){
        int nowPage = 20;
        int pageSize = 10;

        try {
            FSDirectory fsDirectory = FSDirectory.open(Paths.get("D:\\index"));
            //FSDirectory fsDirectory = FSDirectory.open(Paths.get("E:\\后期项目\\lucene资料\\index\\thirdIndex"));
            DirectoryReader directoryReader = DirectoryReader.open(fsDirectory);
            // 所有文档数
            directoryReader.maxDoc();
            // 有索引的文档数
            directoryReader.numDocs();

            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

            QueryParser queryParser = new QueryParser("content",new StandardAnalyzer());
            Query query = queryParser.parse("爱");

            TopDocs topDocs = null;

            // 第一页直接检索
            if(nowPage==1){
                topDocs = indexSearcher.search(query,pageSize);
            }else{
                // 计算start
                int start = (nowPage-1)*pageSize;
                topDocs = indexSearcher.search(query,start);
                // 最后一个ScoreDoc对象
                // 参数一：当前页的上一页的最后一个ScoreDoc对象  参数二：检索条件  参数：查几条
                // searchAfter：从参数一的ScoreDoc对象后 进行检索，并检索参数三 条文档
                topDocs = indexSearcher.searchAfter(topDocs.scoreDocs[topDocs.scoreDocs.length-1],query,pageSize);
            }
            // 获取命中数  符合条件总条数
            // 总页数：
            System.out.println("总命中数："+topDocs.totalHits);

            // 指定高亮格式
            SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<span style='color:red'>", "</span>");

            // 创建Scorer
            QueryScorer queryScorer = new QueryScorer(query);
            // 创建高亮器
            Highlighter highlighter = new Highlighter(formatter,queryScorer);

            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {

                System.out.println("文档得分：" + scoreDoc.score);

                int docId = scoreDoc.doc;
                Document document = indexSearcher.doc(docId);

                String highlighterBestFragment =highlighter.getBestFragment(new StandardAnalyzer(),"content",document.get("content"));

                System.out.println(document.get("id") + "  " + document.get("title") + "  " + highlighterBestFragment + "  " + document.get("poet"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
