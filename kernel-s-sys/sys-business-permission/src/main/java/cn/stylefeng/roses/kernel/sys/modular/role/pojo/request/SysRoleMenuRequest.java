package cn.stylefeng.roses.kernel.sys.modular.role.pojo.request;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 角色菜单关联封装类
 *
 * @author fengshuonan
 * @date 2023/06/10 21:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleMenuRequest extends BaseRequest {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = {edit.class, delete.class})
    @ChineseDescription("主键")
    private Long roleMenuId;

    /**
     * 角色id
     */
    @NotNull(message = "角色id不能为空", groups = {add.class, edit.class})
    @ChineseDescription("角色id")
    private Long roleId;

    /**
     * 菜单id
     */
    @NotNull(message = "菜单id不能为空", groups = {add.class, edit.class})
    @ChineseDescription("菜单id")
    private Long menuId;

}
