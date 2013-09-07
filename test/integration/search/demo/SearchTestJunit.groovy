package search.demo

import groovyx.net.http.HTTPBuilder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 *
 * @author jbaruch
 * @since 08/09/13
 */
@RunWith(Parameterized)
class SearchTestJunit {

    HTTPBuilder httpBuilder
    String query
    int resultsCount
    String name
    String version

    @Before
    void initBuilder() {
        httpBuilder = new HTTPBuilder('http://localhost:9200')
    }

    SearchTestJunit(String query, int resultsCount, String name, String version) {
        this.query = query
        this.name = name
        this.version = version
        this.resultsCount = resultsCount
    }

    @Parameterized.Parameters
    static Collection<String[]> data() {
        [
                ['foo', 1, 'foo', '1.0'] as Object[],
                ['f*', 1, 'foo', '1.0'] as Object[],
                ['bar', 1, 'bar', '2.0'] as Object[],
                ['baz', 1, 'baz', '3.0'] as Object[],
                ['b*', 2, 'bar', '2.0'] as Object[]
        ] as Collection<String[]>
    }

    @Test
    void testTest() {
        def json = httpBuilder.post(path: '/_search', query: [q: query])
        assert json.hits.total == resultsCount
        def artifact = json.hits.hits[0]._source
        assert artifact.name == name
        assert artifact.ver == version
        assert !artifact.metaClass.hasProperty('description')
    }
}
