package com.baizhi;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by wd199 on 2017/6/23.
 */
public class LaceneTest {

    /**
     *创建索引文件
     */
    @Test
    public void createIndex() throws IOException {
        //指定索引文件的存储位置
        String work="working,woking up";
        FSDirectory open = FSDirectory.open(Paths.get("F:\\indexfolder"));

        //保存在磁盘
        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        //创建分析器
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(standardAnalyzer);
        //创建索引写入配置对象

        //创建索引写入器

        //给document添加域

    }
}
