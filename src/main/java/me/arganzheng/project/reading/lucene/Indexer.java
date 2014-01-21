package me.arganzheng.project.reading.lucene;

import java.io.File;
import java.io.IOException;
import java.util.List;

import me.arganzheng.project.reading.model.Book;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Component;

@Component
public class Indexer {

    private String      indexPath   = StringUtils.EMPTY;
    private IndexWriter indexWriter = null;

    public Indexer(){
    }

    public Indexer(String indexPath){
        this.indexPath = indexPath;
    }

    public IndexWriter getIndexWriter(boolean eraseExistingIndex) throws IOException {

        if (indexWriter == null) {
            Directory indexDir = FSDirectory.open(new File(indexPath));

            IndexWriterConfig luceneConfig = new IndexWriterConfig(Version.LUCENE_46,
                                                                   new StandardAnalyzer(Version.LUCENE_46));

            if (eraseExistingIndex) {
                luceneConfig.setOpenMode(OpenMode.CREATE);
            } else {
                luceneConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
            }

            indexWriter = new IndexWriter(indexDir, luceneConfig);
        }
        return indexWriter;
    }

    public <T> void rebuildIndexes(DataProvider dataProvider, DocumentMapper<T> mapper) throws IOException {
        // Erase existing index
        getIndexWriter(true);

        // Index all Accommodation entries
        List<T> datas = dataProvider.fetchData();
        while (CollectionUtils.isNotEmpty(datas)) {
            for (T data : datas) {
                addIndex(data, mapper);
            }
            datas = dataProvider.fetchData();
        }

        // Don't forget to close the index writer when done
        closeIndexWriter();
    }

    public void closeIndexWriter() throws IOException {
        if (indexWriter != null) {
            // commit the document to the index，事实上close会自动commit
            indexWriter.commit();
            // now close it off and release the lock
            indexWriter.close();
        }
    }

    public void addIndex(Document document) throws IOException {
        IndexWriter indexWriter = getIndexWriter(false);
        indexWriter.addDocument(document);
    }

    public <T> void addIndex(T data, DocumentMapper mapper) throws IOException {
        Document document = mapper.mapToDocument(data);
        addIndex(document);
    }

    public void indexBook(Book book) throws IOException {
        IndexWriter indexWriter = getIndexWriter(false);

        String isbn = book.getIsbn10() + "," + book.getIsbn13();
        String title = book.getTitle() + "," + book.getSubtitle();

        StringBuilder authorsSB = new StringBuilder();
        for (int i = 0; i < book.getAuthors().size(); i++) {
            authorsSB.append(book.getAuthors().get(i));
            if (i < book.getAuthors().size() - 1) {
                authorsSB.append(",");
            }
        }
        String authors = authorsSB.toString();

        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));
        doc.add(new TextField("authors", authors, Field.Store.YES));
        // use a string field for isbn because we don't want it tokenized
        doc.add(new StringField("isbn", isbn, Field.Store.YES));

        indexWriter.addDocument(doc);

    }
}
