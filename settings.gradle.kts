rootProject.name = "demo"
include("gradle:flywaydb")
findProject(":gradle:flywaydb")?.name = "flywaydb"
