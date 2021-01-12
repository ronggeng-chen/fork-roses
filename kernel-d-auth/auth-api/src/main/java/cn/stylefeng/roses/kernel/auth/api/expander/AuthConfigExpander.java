package cn.stylefeng.roses.kernel.auth.api.expander;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.stylefeng.roses.kernel.config.api.context.ConfigContext;

import java.util.ArrayList;
import java.util.List;

import static cn.stylefeng.roses.kernel.auth.api.constants.AuthConstants.*;

/**
 * 权限相关配置快速获取
 *
 * @author fengshuonan
 * @date 2020/10/17 16:10
 */
public class AuthConfigExpander {

    /**
     * 获取不被权限控制的url
     *
     * @author fengshuonan
     * @date 2020/10/17 16:12
     */
    public static List<String> getNoneSecurityConfig() {
        String noneSecurityUrls = ConfigContext.me().getSysConfigValueWithDefault("SYS_NONE_SECURITY_URLS", String.class, "");
        if (StrUtil.isEmpty(noneSecurityUrls)) {
            return new ArrayList<>();
        } else {
            return StrUtil.split(noneSecurityUrls, ',');
        }
    }

    /**
     * 用于auth校验的jwt的秘钥
     *
     * @author fengshuonan
     * @date 2021/1/2 18:52
     */
    public static String getAuthJwtSecret() {
        String sysJwtSecret = ConfigContext.me().getConfigValueNullable("SYS_AUTH_JWT_SECRET", String.class);

        // 没配置就返回一个随机密码
        if (sysJwtSecret == null) {
            return RandomUtil.randomString(20);
        } else {
            return sysJwtSecret;
        }
    }

    /**
     * 用于auth模块权限校验的jwt失效时间
     * <p>
     * 这个时间也是“记住我”功能的过期时间，默认为7天
     * <p>
     * 如果登录的时候开启了“记住我”，则用户7天内免登录
     *
     * @author fengshuonan
     * @date 2021/1/2 18:53
     */
    public static Long getAuthJwtTimeoutSeconds() {
        return ConfigContext.me().getSysConfigValueWithDefault("SYS_AUTH_JWT_TIMEOUT_SECONDS", Long.class, DEFAULT_AUTH_JWT_TIMEOUT_SECONDS);
    }

    /**
     * 获取session过期时间，默认3600秒
     * <p>
     * 在这个时段内不操作，会将用户踢下线，从新登陆
     * <p>
     * 如果开启了记住我功能，在session过期后会从新创建session
     *
     * @author fengshuonan
     * @date 2020/10/20 9:32
     */
    public static Long getSessionExpiredSeconds() {
        return ConfigContext.me().getSysConfigValueWithDefault("SYS_SESSION_EXPIRED_SECONDS", Long.class, 3600L);
    }

    /**
     * 获取单账号单端登录的开关
     * <p>
     * 单账号单端登录为限制一个账号多个浏览器登录
     *
     * @return true-开启单端限制，false-关闭单端限制
     * @author fengshuonan
     * @date 2020/10/21 14:31
     */
    public static boolean getSingleAccountLoginFlag() {
        return ConfigContext.me().getSysConfigValueWithDefault("SYS_SINGLE_ACCOUNT_LOGIN_FLAG", Boolean.class, false);
    }

    /**
     * 获取携带token的header头的名称
     *
     * @author fengshuonan
     * @date 2020/10/22 14:11
     */
    public static String getAuthTokenHeaderName() {
        return ConfigContext.me().getSysConfigValueWithDefault("SYS_AUTH_HEADER_NAME", String.class, DEFAULT_AUTH_HEADER_NAME);
    }

    /**
     * 获取携带token的param传参的名称
     *
     * @author fengshuonan
     * @date 2020/10/22 14:11
     */
    public static String getAuthTokenParamName() {
        return ConfigContext.me().getSysConfigValueWithDefault("SYS_AUTH_PARAM_NAME", String.class, DEFAULT_AUTH_PARAM_NAME);
    }

    /**
     * 会话信息是否增加保存在 cookie 中
     * <p>
     * 如果开启此开关，会发生两件事：
     * <p>
     * 1.则登录过程中创建会话时，会HttpServletResponse对象进行addCookie()操作
     * <p>
     * 2.获取当前用户token会多一个从cookie中获取token这个方式
     * <p>
     * 一般这个开关的开启，用在单体不分离的版本中
     *
     * @author fengshuonan
     * @date 2020/12/27 13:15
     */
    public static Boolean getSessionAddToCookie() {
        return ConfigContext.me().getSysConfigValueWithDefault("SYS_SESSION_ADD_TO_COOKIE", Boolean.class, Boolean.FALSE);
    }

    /**
     * 会话保存在cookie中时，cooke的name
     *
     * @author fengshuonan
     * @date 2020/12/27 13:18
     */
    public static String getSessionCookieName() {
        return ConfigContext.me().getSysConfigValueWithDefault("SYS_SESSION_COOKIE_NAME", String.class, DEFAULT_AUTH_HEADER_NAME);
    }

}
