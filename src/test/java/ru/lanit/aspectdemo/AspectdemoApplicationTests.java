package ru.lanit.aspectdemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;
import ru.lanit.aspects.MyAspect;
import ru.lanit.config.Config;
import ru.lanit.services.MyService;

import java.util.ArrayList;
import java.util.List;


@EnableConfigurationProperties
@EnableAspectJAutoProxy
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Config.class, MyService.class, MyAspect.class})
public class AspectdemoApplicationTests {

    @Autowired
    private MyService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testLoggable() {
        List<String> list = new ArrayList();
        list.add("test");

        service.method1(list);
        service.method2();
        Assert.assertTrue(service.check());
    }

}

