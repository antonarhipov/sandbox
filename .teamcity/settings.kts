import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildTypeSettings.Type.DEPLOYMENT

version = "2019.2"

project {
    buildType(Config)
    sequential {
        buildType(Build)
        parallel {
            sequential {
                buildType(Test1) {
                }
                buildType(Test2) {
                    dependsOn(Config) {
                        runOnSameAgent = true
                    }
                }
            }
            buildType(Test3)
        }
        buildType(Deploy) {
            type = DEPLOYMENT
        }
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
