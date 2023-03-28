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
package cn.stylefeng.roses.kernel.rule.pojo.response;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回基类，返回参数可继承此类
 * <p>
 * 可以用于封装通用返回包装器
 * <p>
 *
 * @author yxx
 * @date 2023/03/28 18:08
 */
@Data
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @ChineseDescription("创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @ChineseDescription("创建人")
    private Long createUser;

    /**
     * 创建人姓名
     */
    @ChineseDescription("创建人姓名")
    private String createUserName;

    /**
     * 更新时间
     */
    @ChineseDescription("更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @ChineseDescription("更新人")
    private Long updateUser;

    /**
     * 更新人姓名
     */
    @ChineseDescription("更新人姓名")
    private Long updateUserName;

}
