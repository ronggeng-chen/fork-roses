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
package cn.stylefeng.roses.kernel.sys.modular.role.pojo.request;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 角色绑定权限的请求
 *
 * @author fengshuonan
 * @since 2023/6/13 13:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleBindPermissionRequest extends BaseRequest {

    /**
     * 角色id
     */
    @NotNull(message = "角色id不能为空", groups = roleBindPermission.class)
    @ChineseDescription("角色id")
    private Long roleId;

    /**
     * 模块下的所有的菜单和菜单下的功能
     * <p>
     * 一个模块指的是一行菜单和菜单下的功能
     */
    @ChineseDescription("模块下的所有的菜单和菜单下的功能")
    @NotEmpty(message = "模块下的所有的菜单和菜单下的功能不能为空", groups = roleBindPermission.class)
    private List<Long> modularTotalItemList;

    /**
     * 选中的菜单和菜单下的功能集合
     * <p>
     * 如果这里传空，则是取消选中这个模块下的所有菜单和功能
     */
    @ChineseDescription("选中的菜单和菜单下的功能集合")
    private List<Long> selectedItemList;

    /**
     * 参数校验分组：角色绑定权限
     */
    public @interface roleBindPermission {
    }

}
