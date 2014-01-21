// package me.arganzheng.project.reading.lucene;
//
// import java.io.IOException;
// import java.util.Iterator;
//
// import org.apache.lucene.analysis.Analyzer;
// import org.apache.lucene.analysis.standard.StandardAnalyzer;
// import org.apache.lucene.document.Document;
// import org.apache.lucene.index.IndexReader;
// import org.apache.lucene.queryparser.classic.QueryParser;
// import org.apache.lucene.search.IndexSearcher;
// import org.apache.lucene.search.Query;
// import org.apache.lucene.store.Directory;
// import org.apache.lucene.store.NIOFSDirectory;
//
// import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
//
// public class Searcher {
//
// public void searchIndex(String searchString) throws IOException, ParseException {
// System.out.println("Searching for '" + searchString + "'");
// Directory directory = NIOFSDirectory.getDirectory(INDEX_DIRECTORY);
// IndexReader indexReader = IndexReader.open(directory);
// IndexSearcher indexSearcher = new IndexSearcher(indexReader);
//
// Analyzer analyzer = new StandardAnalyzer();
// QueryParser queryParser = new QueryParser(FIELD_CONTENTS, analyzer);
// Query query = queryParser.parse(searchString);
// Hits hits = indexSearcher.search(query);
// System.out.println("Number of hits: " + hits.length());
//
// Iterator<Hit> it = hits.iterator();
// while (it.hasNext()) {
// Hit hit = it.next();
// Document document = hit.getDocument();
// String path = document.get(FIELD_PATH);
// System.out.println("Hit: " + path);
// }
//
// }
// }
