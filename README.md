# learning anything 
learning-anything 意在练习各种技术, 学习记录代码, 代码中的注释统一用英文, 感谢star和关注  
learning-anything is meant to practice a variety of techniques, learn and record codes, All comments in the codes are in English. thanks for your star and focus on.   

![](https://img.shields.io/badge/Author-XJJ-orange)
![](https://img.shields.io/badge/Email-2849771625%40qq.com-orange)  
![](https://img.shields.io/github/repo-size/x-j-j/learning-anything?color=lightgrey)
![](https://img.shields.io/github/languages/count/x-j-j/learning-anything?color=lightgrey)
![](https://img.shields.io/github/languages/top/x-j-j/learning-anything?color=lightgrey)
![](https://img.shields.io/github/commit-activity/m/x-j-j/learning-anything?color=lightgrey)
![](https://img.shields.io/github/last-commit/x-j-j/learning-anything?color=lightgrey)
![](https://img.shields.io/github/stars/x-j-j/learning-anything?style=social)
![](https://img.shields.io/github/forks/x-j-j/learning-anything?style=social)

## 已经学习
**学习顺序依次如下：**   
1.《Maven实战》  
2.《Spring Cloud Alibaba原理与实战》中途学习:   
(1)《Mybatis从入门到精通》   
(2) mybatis-plus官网文档     
(3) druid官网文档   
(4) 各个组件官网的 exaples/samples/文档 (因为pdf有些地方过时了)     
(5) 各个组件的源码 (官网最新版本)     
3.《java并发编程的艺术》    
4.《java8实战》  

**下面的天数是单个项目的天数**  
由于不是全天学习 所以以下内容仅供参考 

| project                        | total  |
|--------------------------------|--------|
| 《Maven实战》                      | 5days  |
| 《Spring Cloud Alibaba原理与实战》    | 32days |
| 《Mybatis从入门到精通》 + mybatis-plus | 4days  |
| druid官方文档                      | 1days  |
| 《java并发编程的艺术》                  | 7days  |

## 该项目文档/资源 (learning-doc)
所有pdf/官方源码/组件可执行文件/使用说明  
阿里网盘(永久有效)  https://www.aliyundrive.com/s/ngpTUNYpZ55  
**好些pdf都是花钱买的:| 请珍惜**

## 打算学习:
**pdf:**  
《基于Apache Flink的流处理：流式应用基础、实现及操作》   
《PostgreSQL修炼之道：从小工到专家 第2版》   
《java异步编程实战》(写并发项目会过来再看这块)    
《netty实战》  

**下面是学习 + 阅读源码**  

| 入门         | 中阶     | 高阶         | big data        | netty       | source code | serverless |
|------------|--------|------------|-----------------|-------------|-------------|------------|
| guava      | arthas | flink      | rocketmq-stream | reactor     | protobuf    | rocketmq   |
| guice      | netty  | zookeeper  | flink           | async       | grpc        | knative    |
| swagger-ui | ractor | kubernetes | postgreSQL      | socket      | netty       |            |
| feign      |        |            | guass           | multithread |             |            |
 
## 完成列表
- [ ] learning-algorithm  
- [ ] learning-alibaba   
  - [ ] arthas  
  - [x] druid  
  - [x] spring-cloud-alibaba  
    - [x] nacos  
    - [x] seata
    - [x] sentinel
- [ ] learning-apache
  - [x] rocketmq
  - [ ] dubbo
  - [x] maven
  - [ ] flink
  - [ ] zookeeper
  - [ ] hudi
  - [ ] log4j
  - [ ] groovy
- [ ] learning-database
  - [x] mysql
  - [ ] redis
  - [ ] postgres
  - [ ] gauss
  - [ ] memcached
  - [x] db2
  - [ ] polardb
- [ ] learning-docs
- [ ] learning-front
  - [ ] vue
- [ ] learning-google
  - [ ] grpc
  - [ ] guava
  - [ ] protocol buffer
  - [ ] guice
  - [ ] kubernetes
- [ ] learning-hack
  - [ ] learning-codeql
  - [ ] hack-spring
- [x] learning-java
  - [ ] util
    - [x] concurrency
    - [ ] stream
  - [ ] security
- [ ] learning-spring
  - [ ] spring-boot
    - [ ] 源码 + 源码实践
  - [x] spring-cloud
    - [x] spring-cloud-gateway
- [ ] learning-netty
- [ ] learning-reactor
- [ ] learning-serverless

## idea使用
1.idea打开如果模块过多则使用settings(windows)/preferences(mac) -> build, execution, deployment -> build tools -> maven -> ignore files进行ignore 可使用正则 "*"代表匹配多个字母 ","分割  

## ps学习建议  
### 方法论

学习应该是学起来有干劲，学不够，爽，越学越想学，如何达到呢？  

**1.目标驱动学习**
1)针对开发技术这块，一来是项目源码驱动学习，先找个项目源码，为了搞清楚整个项目的架构(系统性)以及具体代码实现，不得不学习其中每个模块的细节，阅读源码和调试的时候遇到问题和疑惑会越来越多，随着思考的深入，产生的问题在网上也逐渐搜索不到了。  (这里如果是按照pdf实践的，可直接跳到第三步)  
2)于是引出第二点，你想详细的学习这门技术，就去找pdf，从上到下撸，一本一本看  
3)看到后面想继续深入，于是找找某个组件的源码解析pdf，慢慢学呗，反正学完面试的时候不冷场，可以吊打面试官:)  
目标->问题->思考->寻找答案->获得成就感  

**2.系统化驱动学习**  
单点研究nacos并没有给我带来很大的兴趣，只有把它放在整个生态上的某个位置，了解到它的那些功能都是做什么的，才有想要研究好它的欲望。
同理学习mybatis-plus的时候刷文档也要搞清楚他的整体结构(比方说service/mapper层的crud, wrapper/lambdawrapper)  然后在逐点学习

**2.实践驱动学习**  
实践虽然会遇到各种问题，但是解决后会有一种油然而生的踏实感，一种真真实实的获得感，必要实践  

**3.工整考究驱动学习**  
实践的时候要工工整整的，要做就做最好，这样才会引起自豪的心情，想去维护好这个项目，让它越来越好，越来越充实和完美  

**4.填坑式学习**  
学习的过程就是不断的挖坑填坑 挖坑代表种草某种技术 了解但不精进 填坑代表发自内心的去学习这门半知半解的技术   
挖坑的过程就是浏览文章的过程 见到的这种技术次数多了 坑也就挖的差不多了  

**5.复习频次**  
根据艾宾浩斯遗忘曲线复习实践节点在1个小时，1天，1周，1月，1季 效果最好, 记忆最牢靠  
所以我们学习某个相对较大的知识点最好以周为单位, 同时配合做小项目, 按月复习  

### 学习踩坑：  

**1.学不懂**  
基础不牢，如果你不懂springboot，直接学习spring-cloud技术栈，大半会觉得学起来很吃力，这里搜一搜，那里搜一搜，结果调试好久也调试不通。尝试先放开spring-cloud，找一本springboot实践的pdf来学学，你会很有收获。记住欲速而不达。  

**2.步骤都对就是报错**  
两种情况, 其一是不同版本需要的组件的版本也有差异, 需要的组件也有差异, 尝试多试一试不同的组件, 比如教程上写的是引入zookeeper模块, 但实际上需要引入spring-cloud-starter-zookeeper-discovery才能调试通过  
第二是由于挪动包, 改包名导致的不知原因的错误, 试一下重启idea, 仍不行试一试保存内容, 删掉模块重新建一个

**3.pdf比较过时**  
最好跟着官网来(if 官网教程比较多) or 官网samples. because pdf 都比较过时  

**4.失眠**  
你可能是学的有点过了 比如上午学习4小时 下午学习4小时 晚上学习4小时 你100%失眠  
如果这个时候你在准备马拉松 你200%失眠 because 阳虚 + 阴虚  
建议: 减少强度 + 归脾丸 + 补肾阳的  


### 反思建议总结
#### 一 
有时候在想, 比如读到dubbo-spi机制源码那块, 里面有一个wrapperClasses, 以前没见过包装类可能就掠过了, 我自己分析的时候真没注意这块, 看教程才注意  
有两种方案:  
1.前期尽量跟着各种教程来学源码等  
2.当教程枯竭, 读到生僻的源码, 就一定要细致, 最好能搞出流程图, 分析好每个地方的作用  

#### 二
如果pdf教程中的版本比较低 可以直接根据官方给出的sample 进行编写代码  

#### 三.源码
1.源码不要在学习组件的时候阅读, 源码要在熟练使用组件能做项目的前提下去读(或者因为某个功能不知道怎么回事 或者好奇时), 这样带着问题和好奇心会读的更好   
2.阅读源码 不要太细致 弄个框架流程就好 因为扣细了没用也记不住 也不是靠背学源码的    
真正需要细致的时候是你参照源码写一个自己的逻辑的时候 这个时候要细致的参考源码  
3.你能大致看懂框架的源码但是写不出来 是因为你的基础知识还很薄弱  
比如你看懂了nacos-config的流程 但是你没有精通异步和多线程 你就写不出来 这个时候需要去学习异步  
4.学习源码需要首先知道架构和理论 不要先读源码来了解架构  
5.在看《java开发并发编程艺术》的时候跟着作者写了一些代码，作者在看源码的时候都要自己写demo，demo是由浅入深的，先写框架搞清原理(忽略一些实现细节)，然后再逐步完善细节，这样对学习源码很有帮助  
6.多想想 如果是自己会如何设计功能 再去看源码

#### 四
集群不要先配置 项目从简单入手 集群作为优化的方式  

#### 五
尽量在第一遍学的时候就认认真真的学透 如果第一遍草草的学 那么第二遍再重学的时候总有一种我之前已经掌握了的错觉 不自觉地不耐烦  
学透就意味着要有正规的教程 比较有点深度的教程 全面的教程 推荐pdf或者官网 不要搞网上的文章之类的 又不全又错又不深入   

#### 六(pdf中的源码)
pdf中往往配有源码 一定要自己写 然后参照配的代码 这样才算是掌握 否则你复制粘贴 根本不算会 自己写不出 没有思考

## by the way
项目里有阿里云ecs服务器公网地址 也有其他服务的端口账号密码 但是 你访问不了 谢谢 设置了ip白名单  
而且也不要想着信息搜集我 去登录我的其他社交媒体的账户 因为 这个密码唯一 只是这个项目用:)    