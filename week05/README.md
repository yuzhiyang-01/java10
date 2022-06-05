1.写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 GitHub。
第一种自动注解方式：
实现代码：https://github.com/yuzhiyang-01/java10/blob/master/week05/week05/src/main/java/com/yu/week05/code/auto/AutoWiringExample.java
测试代码：https://github.com/yuzhiyang-01/java10/blob/master/week05/week05/src/test/java/com/yu/week05/code/auto/AutoWiringExampleTest.java
第二种Java代码方式：

实现代码：https://github.com/yuzhiyang-01/java10/blob/master/week05/week05/src/main/java/com/yu/week05/code/auto/ConfigWirinExample.java
测试代码：https://github.com/yuzhiyang-01/java10/blob/master/week05/week05/src/test/java/com/yu/week05/code/auto/ConfigWirinExampleTest.java
第三种Xml配置方式：

实现代码：https://github.com/yuzhiyang-01/java10/blob/master/week05/week05/src/main/java/com/yu/week05/code/auto/XmlExample.java
测试代码：https://github.com/yuzhiyang-01/java10/blob/master/week05/week05/src/test/java/com/yu/week05/code/auto/XmlExampleTest.java

2.给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。
在本周项目项目工程文件夹：schoolStart 中实现了自动配置，使用 maven install打包。然后放到了另外一个工程：code中，在pom中引入，最后测试通过

实现代码：https://github.com/yuzhiyang-01/java10/tree/master/week05/schoolStart/src/main/java/com/yu/schoolstart/starter
测试代码：https://github.com/yuzhiyang-01/java10/tree/master/week05/week05/src/test/java/com/yu/week05/code/starter


3.研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：
1）使用 JDBC 原生接口，实现数据库的增删改查操作。
2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
3）配置 Hikari 连接池，改进上述操作。提交代码到 GitHub。

实现代码：https://github.com/yuzhiyang-01/java10/tree/master/week05/week05/src/main/java/com/yu/week05/code/database
jdbc：放置原生jdbc操作和事务操作
Hikari：放置Hikari简单示例
测试代码：
jdbc:运行main函数即可
Hikari 运行其中的：HikariApplication，设置为启动以后自动连接查询
