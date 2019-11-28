import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.2"

project {

    sequential {
        buildType(Build)
        parallel {
            sequential {
                buildType(Test1)
                buildType(Test2)
            }
            buildType(Test3) {

            }
        }
        buildType(Deploy)
    }

}

object Build : BuildType({
    name = "Build"

    steps {
        script {
            name = "Step One"
            scriptContent = "echo %build.number%"
        }
        script {
            name = "Step Two"
            scriptContent = """
                echo %build.number%
            """.trimIndent()
        }
        script {
            name = "Step Three"
            scriptContent = "echo %build.number%"
        }
    }
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
