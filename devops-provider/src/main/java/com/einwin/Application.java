package com.einwin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/***
 * 一句话的功能说明描述
 * @author     ：Joy
 * @createTime ：2018/03/15 15:10
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    //@Bean
    //public WebMvcConfigurer corsConfigurer() {
    //    return new WebMvcConfigurerAdapter() {
    //        @Override
    //        public void addCorsMappings(CorsRegistry registry) {
    //            registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
    //        }
    //    };
    //}
}
