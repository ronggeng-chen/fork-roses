package cn.stylefeng.roses.kernel.group.modular.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.stylefeng.roses.kernel.auth.api.context.LoginContext;
import cn.stylefeng.roses.kernel.group.modular.entity.SysGroup;
import cn.stylefeng.roses.kernel.group.modular.mapper.SysGroupMapper;
import cn.stylefeng.roses.kernel.group.modular.pojo.SysGroupRequest;
import cn.stylefeng.roses.kernel.group.modular.service.SysGroupService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 业务分组业务实现层
 *
 * @author fengshuonan
 * @date 2022/05/11 12:54
 */
@Service
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements SysGroupService {

    @Override
    public List<SysGroup> findGroupList(SysGroupRequest sysGroupRequest) {
        // 增加两个固定的选中和取消选项
        SysGroup addGroup = new SysGroup();
        addGroup.setGroupBizCode("PROJECT");
        addGroup.setGroupName("所有分组");

        SysGroup noneGroup = new SysGroup();
        noneGroup.setGroupBizCode("PROJECT");
        noneGroup.setGroupName("未分组");

        String groupBizCode = sysGroupRequest.getGroupBizCode();
        Long userId = LoginContext.me().getLoginUser().getUserId();
        List<SysGroup> userGroupList = this.baseMapper.getUserGroupList(groupBizCode, userId);

        userGroupList.add(0, noneGroup);
        userGroupList.add(0, addGroup);

        return userGroupList;
    }

    @Override
    public List<SysGroup> addSelect(SysGroupRequest sysGroupRequest) {
        // 增加两个固定的选中和取消选项
        SysGroup addGroup = new SysGroup();
        addGroup.setGroupBizCode("PROJECT");
        addGroup.setGroupName("添加分组");

        // 未分组
        SysGroup noneGroup = new SysGroup();
        noneGroup.setGroupBizCode("PROJECT");
        noneGroup.setGroupName("未分组");

        String groupBizCode = sysGroupRequest.getGroupBizCode();
        Long userId = LoginContext.me().getLoginUser().getUserId();
        List<SysGroup> userGroupList = this.baseMapper.getUserGroupList(groupBizCode, userId);

        userGroupList.add(0, noneGroup);
        userGroupList.add(0, addGroup);

        return userGroupList;
    }

    @Override
    public void add(SysGroupRequest sysGroupRequest) {
        ArrayList<SysGroup> sysGroups = new ArrayList<>();
        Long userId = LoginContext.me().getLoginUser().getUserId();
        List<Long> businessIdList = sysGroupRequest.getBusinessIdList();

        // 移除当前用户在这个bizCode下已经绑定的分组
        LambdaUpdateWrapper<SysGroup> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SysGroup::getGroupBizCode, sysGroupRequest.getGroupBizCode());
        updateWrapper.in(SysGroup::getBusinessId, businessIdList);
        updateWrapper.eq(SysGroup::getUserId, userId);
        this.remove(updateWrapper);

        // 如果分组名称是未分组，则删除分组
        if (!sysGroupRequest.getGroupName().equals("未分组")) {
            for (Long bizId : businessIdList) {
                SysGroup sysGroup = new SysGroup();
                sysGroup.setGroupName(sysGroupRequest.getGroupName());
                sysGroup.setGroupBizCode(sysGroupRequest.getGroupBizCode());
                sysGroup.setBusinessId(bizId);
                sysGroup.setUserId(userId);
                sysGroups.add(sysGroup);
            }

            this.saveBatch(sysGroups);
        }
    }

    @Override
    public void del(SysGroupRequest sysGroupRequest) {

        Long userId = LoginContext.me().getLoginUser().getUserId();

        LambdaUpdateWrapper<SysGroup> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysGroup::getUserId, userId);
        wrapper.eq(SysGroup::getGroupBizCode, sysGroupRequest.getGroupBizCode());
        wrapper.in(SysGroup::getBusinessId, sysGroupRequest.getBusinessIdList());

        this.remove(wrapper);
    }

    @Override
    public List<Long> findUserGroupDataList(SysGroupRequest sysGroupRequest) {

        Long userId = LoginContext.me().getLoginUser().getUserId();

        LambdaQueryWrapper<SysGroup> sysGroupLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysGroupLambdaQueryWrapper.eq(SysGroup::getUserId, userId);
        sysGroupLambdaQueryWrapper.eq(SysGroup::getGroupBizCode, sysGroupRequest.getGroupBizCode());
        sysGroupLambdaQueryWrapper.eq(StrUtil.isNotBlank(sysGroupRequest.getGroupName()), SysGroup::getGroupName, sysGroupRequest.getGroupName());

        List<SysGroup> list = this.list(sysGroupLambdaQueryWrapper);
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        } else {
            return list.stream().map(SysGroup::getBusinessId).collect(Collectors.toList());
        }
    }

}
