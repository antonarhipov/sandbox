package patches.templates

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Template
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a template with id = 'MyTemplate'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, Template({
    id("MyTemplate")
    name = "MyTemplate"

    steps {
        script {
            id = "RUNNER_3"
            scriptContent = """echo "First""""
        }
    }
}))

