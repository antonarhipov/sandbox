import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.version

version = "2019.2"

project {
    vcsRoot(ProjectVcs)

}

object Build : BuildType({
    name = "Build"
})

object Config : BuildType({
    name = "Config"
})

object Test1 : BuildType({
    name = "Test1"
})

object Test2 : BuildType({
    name = "Test2"
})

object Test3 : BuildType({
    name = "Test3"
})

object Deploy : BuildType({
    name = "Deploy"
})

object ProjectVcs : GitVcsRoot({
    name = "ProjectVcs"
    url = "git://some.git.repository"
})

