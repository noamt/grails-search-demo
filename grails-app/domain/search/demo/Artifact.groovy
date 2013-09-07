package search.demo

class Artifact {

    String id
    String name
    String ver
    String desc

    static constraints = {
    }

    static searchable = {
        only = ['id', 'name', 'ver']
        id index: 'no'
        name boost: 0.5
        desc index: 'no'
    }
}
