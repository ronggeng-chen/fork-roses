package cn.stylefeng.roses.kernel.sys.modular.role.pojo.request;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 系统角色封装类
 *
 * @author fengshuonan
 * @date 2023/06/10 21:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleRequest extends BaseRequest {

    /**
     * 主键id
     */
    @NotNull(message = "主键id不能为空", groups = {edit.class, delete.class})
    @ChineseDescription("主键id")
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空", groups = {add.class, edit.class})
    @ChineseDescription("角色名称")
    private String roleName;

    /**
     * 角色编码
     */
    @NotBlank(message = "角色编码不能为空", groups = {add.class, edit.class})
    @ChineseDescription("角色编码")
    private String roleCode;

    /**
     * 序号
     */
    @NotNull(message = "序号不能为空", groups = {add.class, edit.class})
    @ChineseDescription("序号")
    private BigDecimal roleSort;

    /**
     * 数据范围类型：10-仅本人数据，20-本部门数据，30-本部门及以下数据，40-指定部门数据，50-全部数据
     */
    @NotNull(message = "数据范围类型：10-仅本人数据，20-本部门数据，30-本部门及以下数据，40-指定部门数据，50-全部数据不能为空", groups = {add.class, edit.class})
    @ChineseDescription("数据范围类型：10-仅本人数据，20-本部门数据，30-本部门及以下数据，40-指定部门数据，50-全部数据")
    private Integer dataScopeType;

    /**
     * 状态：1-启用，2-禁用
     */
    @NotNull(message = "状态：1-启用，2-禁用不能为空", groups = {add.class, edit.class})
    @ChineseDescription("状态：1-启用，2-禁用")
    private Integer statusFlag;

    /**
     * 备注
     */
    @ChineseDescription("备注")
    private String remark;

    /**
     * 是否是系统角色：Y-是，N-否。系统角色不能删除
     */
    @NotBlank(message = "是否是系统角色：Y-是，N-否。系统角色不能删除不能为空", groups = {add.class, edit.class})
    @ChineseDescription("是否是系统角色：Y-是，N-否。系统角色不能删除")
    private String roleSystemFlag;

}
