package com.session05baitap.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Khởi tạo Spring DispatcherServlet bằng Java configuration
 * Thay thế cho cấu hình trong web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Cấu hình Root Application Context (nếu cần)
     * Sử dụng cho các bean chung (Service, Repository, v.v)
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * Cấu hình Servlet Application Context
     * Sử dụng cho Web MVC beans (Controller, ViewResolver, v.v)
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * Cấu hình URL Pattern cho DispatcherServlet
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

