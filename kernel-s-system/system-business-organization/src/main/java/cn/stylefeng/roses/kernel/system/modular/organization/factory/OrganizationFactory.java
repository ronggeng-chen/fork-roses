package cn.stylefeng.roses.kernel.system.modular.organization.factory;

import cn.stylefeng.roses.kernel.system.modular.organization.entity.HrOrganization;
import cn.stylefeng.roses.kernel.system.pojo.organization.layui.LayuiOrganizationTreeNode;

/**
 * 组织机构实体转化
 *
 * @author chenjinlong
 * @date 2021/1/6 21:03
 */
public class OrganizationFactory {

    /**
     * 实体转换
     *
     * @param hrOrganization 机构信息
     * @return LayuiOrganizationTreeNode layui树实体对象
     * @author chenjinlong
     * @date 2021/1/5 21:07
     */
    public static LayuiOrganizationTreeNode parseOrganizationTreeNode(HrOrganization hrOrganization) {
        LayuiOrganizationTreeNode treeNode = new LayuiOrganizationTreeNode();
        treeNode.setId(hrOrganization.getOrgId());
        treeNode.setParentId(hrOrganization.getOrgParentId());
        treeNode.setTitle(hrOrganization.getOrgName());
        return treeNode;
    }

}