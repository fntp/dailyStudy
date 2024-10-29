package com.xuexi.controller;

import com.xuexi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author fntp
 * @since 2024/10/28
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IService iService;

    @GetMapping("/a")
    public void doTestBeanFromIService(HttpServletResponse response) throws IOException {
        response.getWriter().println(iService.getName());
    }

    @GetMapping("/b")
    public void doTestBeanFromBeanConfig(HttpServletResponse response) throws IOException {
        Map<String, String> currentEnv = System.getenv();
        response.getWriter().println();
    }

}
