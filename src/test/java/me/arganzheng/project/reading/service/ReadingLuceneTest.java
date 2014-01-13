package me.arganzheng.project.reading.service;

import java.io.IOException;

import me.arganzheng.project.reading.BaseSpringTestCase;
import me.arganzheng.project.reading.common.Page;
import me.arganzheng.project.reading.constants.BookStatus;
import me.arganzheng.project.reading.criteria.BookPagingCriteria;
import me.arganzheng.project.reading.model.Book;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReadingLuceneTest extends BaseSpringTestCase {

    @Autowired
    private BookService bookService;

    @Test
    public void testIndexing() throws IOException {
        // 0. Specify the analyzer for tokenizing text.
        // The same analyzer should be used for indexing and searching
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);

        // 1. create the index
        Directory index = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46, analyzer);

        IndexWriter w = new IndexWriter(index, config);
        BookPagingCriteria pagingCriteria = new BookPagingCriteria();
        pagingCriteria.setIncludeOwnership(false);
        pagingCriteria.setStatusSet(BookStatus.OnShelf, BookStatus.Lent, BookStatus.Return);
        Page<Book> books = bookService.listBook(pagingCriteria);

        for (Book book : books.getRecords()) {
            indexBook(w, book);
        }
        w.close();

        // 2. query
        String querystr = "挪威的森林";

        QueryParser qp = new MultiFieldQueryParser(Version.LUCENE_46, new String[] { "title", "authors", "isbn" },
                                                   analyzer);
        qp.setDefaultOperator(QueryParser.Operator.AND);
        Query q = null;
        try {
            q = qp.parse(querystr);
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        // 3. search
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        // 4. display results
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title") + "\t" + d.get("authors"));
        }

        // reader can only be closed when there
        // is no need to access the documents any more.
        reader.close();
    }

    private void indexBook(IndexWriter w, Book book) throws IOException {
        StringBuilder authors = new StringBuilder();
        for (int i = 0; i < book.getAuthors().size(); i++) {
            authors.append(book.getAuthors().get(i));
            if (i < book.getAuthors().size() - 1) {
                authors.append(",");
            }
        }

        String isbn = book.getIsbn10() + "," + book.getIsbn13();
        indexBook(w, book.getTitle(), authors.toString(), isbn);
    }

    @Test
    public void testSearching() throws IOException {
        // 0. Specify the analyzer for tokenizing text.
        // The same analyzer should be used for indexing and searching
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);

        // 1. create the index
        Directory index = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46, analyzer);

        IndexWriter w = new IndexWriter(index, config);
        indexBook(w, "Lucene in Action", "Erik Hatcher, Otis Gospodnetic", "193398817");
        indexBook(w, "Lucene实战", "(美)麦肯德利斯, 哈彻, 高斯波纳提克", "9787115251770");
        indexBook(w, "HBase in Action", "Nick Dimiduk, Amandeep Khurana", "9781617290527");
        indexBook(w, "HBase实战", "Nick Dimiduk, Amandeep Khurana", "9787115264480");
        indexBook(w, "松本行弘的程序世界", "(日)松本行弘", "9787115255075");
        indexBook(w, "松本若菜 final color", "松本若菜, 西條彰仁", "9784091030719");
        indexBook(w, "挪威的森林", "[日] 村上春树", "9787532725694");
        indexBook(w, "少有人走的路", "[美] M·斯科特·派克", "9787807023777");
        w.close();

        // 2. query
        String querystr = "挪威的森林";

        QueryParser qp = new MultiFieldQueryParser(Version.LUCENE_46, new String[] { "title", "authors", "isbn" },
                                                   analyzer);
        qp.setDefaultOperator(QueryParser.Operator.AND);
        Query q = null;
        try {
            q = qp.parse(querystr);
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        // 3. search
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        // 4. display results
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title"));
        }

        // reader can only be closed when there
        // is no need to access the documents any more.
        reader.close();
    }

    private void indexBook(IndexWriter w, String title, String authors, String isbn) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));
        doc.add(new TextField("authors", authors, Field.Store.YES));
        // use a string field for isbn because we don't want it tokenized
        doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }
}
