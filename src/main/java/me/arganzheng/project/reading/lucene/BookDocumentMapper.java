package me.arganzheng.project.reading.lucene;

import me.arganzheng.project.reading.model.Book;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

public class BookDocumentMapper implements DocumentMapper<Book> {

    @Override
    public Document mapToDocument(Book book) {
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

        return doc;
    }
}
