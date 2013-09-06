package search.demo

class ArtifactController {

    def index() {
        redirect(action: 'main')
    }

    def main() {
        [existingArtifacts: Artifact.findAll()]
    }

    def save() {
        def name = params.artifactName
        def version = params.artifactVersion
        new Artifact(name: name, ver: version).save()

        redirect(controller: 'artifact', action: 'main')
    }
}
