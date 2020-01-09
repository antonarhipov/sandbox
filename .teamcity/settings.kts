import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

version = "2019.2"

project {
    vcsRoot(ProjectVcs)

    buildType(BuildA)
    buildType(BuildB)
}

object ProjectVcs : GitVcsRoot({
    name = "ProjectVcs"
    url = "git://some.git.repository"
})

//---------------------------------------------------------------------------

open class MyCommonTemplate : BuildType({
    steps {
        script {
            scriptContent = """echo "Hello from base template" """
        }
    }
})

object BuildA : MyCommonTemplate() {
    init {
        steps {
            script {
                scriptContent = """echo "More steps for A" """
            }
        }
    }
}

object BuildB : MyCommonTemplate() {
    init {
        steps {
            script {
                scriptContent = """echo "More steps for B" """
            }
        }
    }
}