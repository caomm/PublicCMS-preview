maven(使用以下文件：.mvn,pom.xml,mvnw,mvnw.cmd)

已安装gradle完整命令行为  mvn clean
未安装gradle完整命令行为 mvnw clean

其中clean可以替换为以下任务：
清空 ：clean
打包 ：install
清空eclipse配置 ：eclipse:clean
配置eclipse工程 ：eclipse:eclipse
清空myeclipse配置 ：eclipse:myeclipse-clean
配置myeclipse工程 ：eclipse:myeclipse
清空idea配置 ：idea:clean
配置idea工程 ：idea:idea
运行工程：jetty:run

gradle(使用以下文件：gradle,settings.gradle,build.gradle,gradlew,gradlew.bat)

已安装gradle完整命令行为  gradle clean
未安装gradle完整命令行为 gradlew clean

其中clean可以替换为以下任务：
清空 ：clean
打包 ：war
//如果在eclipse工程中执行配置eclipse工程命令时，请先关闭publiccms,publiccms-common工程，再执行下面的命令，否则eclipse会干扰Deployment Assembly设置，造成test类也被部署
清空eclipse配置 ：cleanEclipse
配置eclipse工程 ：eclipse
清空idea配置 ：cleanIdea
配置idea工程 ：idea
