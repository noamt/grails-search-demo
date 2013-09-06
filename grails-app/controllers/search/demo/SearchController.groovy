package search.demo

class SearchController {

    def index() {
        redirect(action: 'main')
    }

    def main() {
    }

    def search() {
        def results = Artifact.search(params.query)
        render(template: 'results', model: [results: results.searchResults])
    }
}
