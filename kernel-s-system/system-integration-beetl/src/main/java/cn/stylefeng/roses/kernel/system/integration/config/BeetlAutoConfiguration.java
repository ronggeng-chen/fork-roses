package cn.stylefeng.roses.kernel.system.integration.config;

import cn.stylefeng.roses.kernel.auth.api.LoginUserApi;
import cn.stylefeng.roses.kernel.system.integration.core.CustomBeetlGroupUtilConfiguration;
import cn.stylefeng.roses.kernel.system.integration.core.expander.BeetlConfigExpander;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Beetl模板引擎的配置
 *
 * @author fengshuonan
 * @since 2020/12/27 12:34
 */
@Configuration
public class BeetlAutoConfiguration {

    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    /**
     * Beetl的自定义配置
     *
     * @author fengshuonan
     * @since 2020/12/27 12:34
     */
    @Bean(initMethod = "init")
    public CustomBeetlGroupUtilConfiguration customBeetlGroupUtilConfiguration(LoginUserApi loginUserApi) {
        CustomBeetlGroupUtilConfiguration customBeetlGroupUtilConfiguration = new CustomBeetlGroupUtilConfiguration(loginUserApi);

        // 设置beetl的资源加载器
        customBeetlGroupUtilConfiguration.setResourceLoader(new ClasspathResourceLoader(BeetlAutoConfiguration.class.getClassLoader(), prefix));

        // 设置beetl的配置
        customBeetlGroupUtilConfiguration.setConfigProperties(createBeetlProperties());

        return customBeetlGroupUtilConfiguration;
    }

    /**
     * beetl的视图解析器
     *
     * @author fengshuonan
     * @since 2020/12/27 12:34
     */
    @Bean
    public BeetlSpringViewResolver beetlViewResolver(CustomBeetlGroupUtilConfiguration customBeetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setConfig(customBeetlGroupUtilConfiguration);
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        return beetlSpringViewResolver;
    }

    /**
     * 组装beetl初始化需要的properties
     *
     * @author fengshuonan
     * @since 2020/12/27 12:33
     */
    private Properties createBeetlProperties() {
        Properties properties = new Properties();
        properties.setProperty("DELIMITER_STATEMENT_START", BeetlConfigExpander.getDelimiterStatementStart());
        properties.setProperty("DELIMITER_STATEMENT_END", BeetlConfigExpander.getDelimiterStatementEnd());
        properties.setProperty("HTML_TAG_FLAG", BeetlConfigExpander.getHtmlTagFlag());
        properties.setProperty("RESOURCE.tagRoot", BeetlConfigExpander.getResourceTagRoot());
        properties.setProperty("RESOURCE.tagSuffix", BeetlConfigExpander.getResourceTagSuffix());
        properties.setProperty("RESOURCE.autoCheck", BeetlConfigExpander.getResourceAutoCheck());
        return properties;
    }

}
