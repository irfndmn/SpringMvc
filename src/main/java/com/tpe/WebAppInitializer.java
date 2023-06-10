package com.tpe;
//web.xml yerine bu classi kullancaz
// dispatcher servletin tanimlanmasi.. config classlarin yerini isaretlicez


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // dispatcher servlet in


    @Override
    protected Class<?>[] getRootConfigClasses() {
return new Class[]{
        RootContextConfig.class
};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
