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
package cn.stylefeng.roses.kernel.validator.api.validators.date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 日期校验格式，通过format的参数来校验格式
 *
 * @author fengshuonan
 * @since 2020/11/18 21:30
 */
public class DateValueValidator implements ConstraintValidator<DateValue, String> {

    private Boolean required;

    private String format;

    @Override
    public void initialize(DateValue constraintAnnotation) {
        this.required = constraintAnnotation.required();
        this.format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String dateValue, ConstraintValidatorContext context) {

        if (StrUtil.isEmpty(dateValue)) {
            // 校验是不是必填
            if (required) {
                return false;
            } else {
                return true;
            }
        } else {
            try {
                // 校验日期格式
                DateUtil.parse(dateValue, format);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

    }
}
