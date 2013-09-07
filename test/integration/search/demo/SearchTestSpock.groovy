package search.demo

import grails.plugin.spock.IntegrationSpec
import groovyx.net.http.HTTPBuilder
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author jbaruch
 * @since 08/09/13
 */
class SearchTestSpock extends Specification {

    @Shared
    HTTPBuilder httpBuilder

    def setupSpec() {
        httpBuilder = new HTTPBuilder('http://localhost:9200')
    }


    @Unroll
    def 'Search for a artifact by query #query'() {
        when:
        def json = httpBuilder.post(path: '/_search', query: [q: query])

        then:
        json.hits.total == count

        def artifact = json.hits.hits[0]._source
        artifact.name == name
        artifact.ver == version
        !artifact.metaClass.hasProperty('description')

        where:
        query | count | name  | version
        'foo' | 1     | 'foo' | '1.0'
        'f*'  | 1     | 'foo' | '1.0'
        'bar' | 1     | 'bar' | '2.0'
        'baz' | 1     | 'baz' | '3.0'
        'b*'  | 2     | 'bar' | '2.0'
    }
}

