package me.arganzheng.project.reading.lucene;

import org.apache.lucene.document.Document;

public interface DocumentMapper<T> {

    Document mapToDocument(T data);
}
