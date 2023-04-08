package cn.stylefeng.roses.kernel.system.integration.core.expander;

import cn.stylefeng.roses.kernel.config.api.context.ConfigContext;
import cn.stylefeng.roses.kernel.system.integration.core.consts.BeetlConstants;

/**
 * Beetl模板引擎相关配置
 *
 * @author fengshuonan
 * @since 2020/12/27 11:36
 */
public class BeetlConfigExpander {

    /**
     * 边界符开始符号
     *
     * @author fengshuonan
     * @since 2020/12/27 12:27
     */
    public static String getDelimiterStatementStart() {
        return ConfigContext.me().getSysConfigValueWithDefault("DELIMITER_STATEMENT_START", String.class, BeetlConstants.DEFAULT_DELIMITER_STATEMENT_START);
    }

    /**
     * beetl边界符的结束符号
     *
     * @author fengshuonan
     * @since 2020/12/27 12:27
     */
    public static String getDelimiterStatementEnd() {
        return ConfigContext.me().getSysConfigValueWithDefault("DELIMITER_STATEMENT_END", String.class, BeetlConstants.DEFAULT_DELIMITER_STATEMENT_END);
    }

    /**
     * 自定义标签文件Root目录
     *
     * @author fengshuonan
     * @since 2020/12/27 12:27
     */
    public static String getResourceTagRoot() {
        return ConfigContext.me().getSysConfigValueWithDefault("RESOURCE_TAG_ROOT", String.class, BeetlConstants.DEFAULT_RESOURCE_TAG_ROOT);
    }

    /**
     * 自定义标签文件后缀
     *
     * @author fengshuonan
     * @since 2020/12/27 12:27
     */
    public static String getResourceTagSuffix() {
        return ConfigContext.me().getSysConfigValueWithDefault("RESOURCE_TAG_SUFFIX", String.class, BeetlConstants.DEFAULT_RESOURCE_TAG_SUFFIX);
    }

    /**
     * 是否检测文件变化,开发用true合适，但线上要改为false
     *
     * @author fengshuonan
     * @since 2020/12/27 12:27
     */
    public static String getResourceAutoCheck() {
        return ConfigContext.me().getSysConfigValueWithDefault("RESOURCE_AUTO_CHECK", String.class, BeetlConstants.DEFAULT_RESOURCE_AUTO_CHECK);
    }

    /**
     * 自定义支持HTML标签
     *
     * @author liuhanqing
     * @since 2021/1/16 21:06
     */
    public static String getHtmlTagFlag() {
        return ConfigContext.me().getSysConfigValueWithDefault("HTML_TAG_FLAG", String.class, BeetlConstants.DEFAULT_HTML_TAG_FLAG);
    }

}
