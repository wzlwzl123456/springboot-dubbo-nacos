package com.weng.consumer;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@EnableDubbo 包含：@EnableDubboConfig解析配置相关的类注册到spring容器,@DubboComponentScan指定@Service扫描路径,@EnableDubboLifecycle注册了两个监听器到spring容器
//@ComponentScan 多个Controller可用来扫描
@EnableDubbo
@SpringBootApplication
public class ConsumerApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/layui/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/layui/");
        super.addResourceHandlers(registry);
    }

}
