/*
 * Copyright [2020-2030] [https://www.stylefeng.cn]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Guns源码头部的版权声明。
 * 3.请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns
 * 5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns
 * 6.若您的项目无法满足以上几点，可申请商业授权
 */
package cn.stylefeng.roses.kernel.email.api.exception.enums;

import cn.stylefeng.roses.kernel.email.api.constants.MailConstants;
import cn.stylefeng.roses.kernel.rule.constants.RuleConstants;
import cn.stylefeng.roses.kernel.rule.exception.AbstractExceptionEnum;
import lombok.Getter;

/**
 * 邮件相关的异常
 *
 * @author fengshuonan
 * @since 2020/10/23 17:36
 */
@Getter
public enum EmailExceptionEnum implements AbstractExceptionEnum {

    /**
     * 邮件发送异常，请求参数存在空值
     */
    EMAIL_PARAM_EMPTY_ERROR(RuleConstants.BUSINESS_ERROR_TYPE_CODE + MailConstants.MAIL_EXCEPTION_STEP_CODE + "01", "邮件发送失败，请检查参数配置，{}参数可能为空"),

    /**
     * 阿里云邮件发送异常
     */
    ALIYUN_MAIL_SEND_ERROR(RuleConstants.THIRD_ERROR_TYPE_CODE + MailConstants.MAIL_EXCEPTION_STEP_CODE + "02", "阿里云邮件发送异常，errorCode：{}");

    /**
     * 错误编码
     */
    private final String errorCode;

    /**
     * 提示用户信息
     */
    private final String userTip;

    EmailExceptionEnum(String errorCode, String userTip) {
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

}
