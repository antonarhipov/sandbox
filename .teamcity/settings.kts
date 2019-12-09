import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.sequential
import jetbrains.buildServer.configs.kotlin.v2019_2.version

version = "2019.2"

project {
    buildType(Config)
    sequential {
        buildType(Build)

        parallel {
            buildType(Test1) {
                runOnSameAgent = true
            }
            buildType(Test2)
            buildType(Test3)

            dependsOn(Config)
        }

        buildType(Deploy)
    }
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
