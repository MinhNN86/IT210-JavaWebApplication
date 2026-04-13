package com.session07baitap.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Thay thế web.xml bằng Java-based configuration.
 * Kế thừa AbstractAnnotationConfigDispatcherServletInitializer
 * để tự động cấu hình DispatcherServlet.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // Cấu hình multipart để hỗ trợ upload file
        // Ex05: maxFileSize = 10MB, maxRequestSize = 15MB (cho phép upload banner dung lượng lớn)
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        System.getProperty("java.io.tmpdir"), // thư mục tạm
                        10 * 1024 * 1024,  // maxFileSize: 10MB
                        15 * 1024 * 1024,  // maxRequestSize: 15MB
                        0                  // fileSizeThreshold
                )
        );
    }
}
