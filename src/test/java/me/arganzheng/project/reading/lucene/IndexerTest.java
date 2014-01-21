package me.arganzheng.project.reading.lucene;

import java.io.IOException;

import me.arganzheng.project.reading.BaseSpringTestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IndexerTest extends BaseSpringTestCase {

    @Autowired
    Indexer indexer;

    @Test
    public void testRebuildIndex() throws IOException {
        indexer.rebuildIndexes(new BookDataProvider(), new BookDocumentMapper());
    }
}
