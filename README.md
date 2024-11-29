
## 学生问答社区后端

> 项目详细说明及配套前端：https://github.com/YYForReal/WeeklyQuestionCommunity 

技术栈：Springboot

运行配置：

- MySQL数据库
1. 根据根目录下sql文件创建数据库community(自带数据)
2. 修改src/main/java/resources/application.yml下的数据库连接配置。
    - 默认数据库地址：127.0.0.1
    - 默认数据库名：community

- 七牛云对象存储
1. 申请七牛云对象存储的密钥（AccessKey和SecretKey）

  有免费测试域名30天使用的。https://portal.qiniu.com/


2. 通过密钥修改`src/main/java/com/hyy/weeklyquestionbackend/bean/qiniu/QiNiuYunConfig`的默认配置

~~~java
private String accessKey = "";  //密钥
private String secretKey = "-"; //密钥
private String bucket = "";//空间名：自己取的（类似于文件夹名字）
private String path = ""; //域名：官网会给的测试域名或者自己注册一个加速域名
~~~

