# spring-boot-dubbo-nacos

## 介绍
springboot dubbo结合nacos示例
##  Dubbo：分布式微服务框架
服务运行容器Container启动、加载、运行提供者Provider

提供者启动时向注册中心Registry注册自己的服务

注册中心保存服务名和服务地址映射关系，地址变动主动通知消费者Consumer

消费者启动时，向注册中心获取提供者地址列表，通过列表远程连接调用提供者

提供者和消费者定时发送调用次数和时间，监控中心Monitor统计
### Dubbo实际运用
Provider：
服务实现类上注解@DubboSerivce暴露服务的接口

Consumer：
Controller类内注解@DubboReference注入Provider暴露的服务接口，以供调用

启动类上@EnableDubbo：
1、初始化Dubbo核心组件，加载Dubbo配置到内存
2、注册BeanPostProcessor，用来扫描@Service和@Reference注解

## Nacos
### 特点：
#### 数据存储：
Mysql数据库，数据更新直接更新数据库

#### 消息发送：
异步广播，后台线程保证重试

CAP：CP+AP。

持久化存储服务信息（CP），类似Zookeeper的过半机制。

非持久化存储服务信息（AP、官方推荐使用），失去联系的节点仍然可以向系统提供服务（可用性），不过数据不保证同步
## Mybatis
持久层框架，将数据库表和实体类对应起来

### 优点：
最简单的持久层框架
内部封装JDBC，简化注册驱动、创建链接等过程，开发者只需要关注SQL语句本身

### 缺点：
访问数据库SQL语句存在xml文件中，编写SQL语句工作量大
SQL语句依赖于数据库，数据库移植性差

### 工作流程：

程序启动时，使用@MapperScan注解扫描Mapper包下的接口
读取Mybatis配置文件

根据配置构造会话工厂SqlSessionFactory

SqlSessionFactory创建会话对象SqlSession，包含执行SQL语句的方法

SqlSession实例获取Mapper对象并运行Mapper映射的SQL语句，完成数据库的CRUD和事务提交
## Mybatis-Plus
在Mybatis的基础上进行增强而不做改变，无需编写xml文件

Mybatis-Plus对比Mybatis的改动：

Mapper接口继承BaseMapper<pojo类>，就可以直接调用Mapper接口继承的方法运行SQL语句、条件构造器Wrapper实现带条件的SQL语句

### 使用场景：

SQL性能监控、乐观锁、执行分析等插件的使用
不同实体类，查询目的一致、结构类似的SQL语句的简化
···
## Layui
Layui是一套开源的Web UI解决方案，采用模块化规范，遵循原生HTML/CSS/JS的开发方式，有轻量级、简单美观的优点

### 使用流程

1 引入相关文件并连接到HTML

2 layui.use引用原有的或自定义的模块

3 对模块进行相关操作

### 使用心得

Layui在不对原生开发方式作出太大改动的基础上，极大程度地简化了设计前端页面样式的过程，减少了在原生开发中消耗的大量时间精力

