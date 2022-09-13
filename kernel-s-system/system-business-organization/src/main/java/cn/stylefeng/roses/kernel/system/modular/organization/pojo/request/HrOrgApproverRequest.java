package cn.stylefeng.roses.kernel.system.modular.organization.pojo.request;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 组织机构审批人封装类
 *
 * @author fengshuonan
 * @date 2022/09/13 23:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HrOrgApproverRequest extends BaseRequest {

    /**
     * 主键id
     */
    @NotNull(message = "主键id不能为空", groups = {edit.class, delete.class})
    @ChineseDescription("主键id")
    private Long orgApproverId;

    /**
     * 组织审批类型：1-负责人，2-部长，3-体系负责人，4-部门助理，5-资产助理（专员），6-考勤专员，7-HRBP，8-门禁员，9-办公账号员，10-转岗须知员
     */
    @ChineseDescription("组织审批类型：1-负责人，2-部长，3-体系负责人，4-部门助理，5-资产助理（专员），6-考勤专员，7-HRBP，8-门禁员，9-办公账号员，10-转岗须知员")
    private Integer orgApproverType;

    /**
     * 组织机构id
     */
    @ChineseDescription("组织机构id")
    private Long orgId;

    /**
     * 用户id
     */
    @ChineseDescription("用户id")
    private Long userId;

}
