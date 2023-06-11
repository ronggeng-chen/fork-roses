package cn.stylefeng.roses.kernel.sys.modular.org.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.dict.api.DictApi;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;
import cn.stylefeng.roses.kernel.rule.pojo.dict.SimpleDict;
import cn.stylefeng.roses.kernel.sys.api.callback.RemoveOrgCallbackApi;
import cn.stylefeng.roses.kernel.sys.modular.org.constants.ApproverConstants;
import cn.stylefeng.roses.kernel.sys.modular.org.entity.HrOrgApprover;
import cn.stylefeng.roses.kernel.sys.modular.org.enums.HrOrgApproverExceptionEnum;
import cn.stylefeng.roses.kernel.sys.modular.org.mapper.HrOrgApproverMapper;
import cn.stylefeng.roses.kernel.sys.modular.org.pojo.request.HrOrgApproverRequest;
import cn.stylefeng.roses.kernel.sys.modular.org.service.HrOrgApproverService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * 组织机构审批人业务实现层
 *
 * @author fengshuonan
 * @date 2023/06/10 21:23
 */
@Service
public class HrOrgApproverServiceImpl extends ServiceImpl<HrOrgApproverMapper, HrOrgApprover> implements HrOrgApproverService, RemoveOrgCallbackApi {

    @Resource
    private DictApi dictApi;

    @Override
    public void add(HrOrgApproverRequest hrOrgApproverRequest) {
        HrOrgApprover hrOrgApprover = new HrOrgApprover();
        BeanUtil.copyProperties(hrOrgApproverRequest, hrOrgApprover);
        this.save(hrOrgApprover);
    }

    @Override
    public void del(HrOrgApproverRequest hrOrgApproverRequest) {
        HrOrgApprover hrOrgApprover = this.queryHrOrgApprover(hrOrgApproverRequest);
        this.removeById(hrOrgApprover.getOrgApproverId());
    }

    @Override
    public void edit(HrOrgApproverRequest hrOrgApproverRequest) {
        HrOrgApprover hrOrgApprover = this.queryHrOrgApprover(hrOrgApproverRequest);
        BeanUtil.copyProperties(hrOrgApproverRequest, hrOrgApprover);
        this.updateById(hrOrgApprover);
    }

    @Override
    public HrOrgApprover detail(HrOrgApproverRequest hrOrgApproverRequest) {
        return this.queryHrOrgApprover(hrOrgApproverRequest);
    }

    @Override
    public PageResult<HrOrgApprover> findPage(HrOrgApproverRequest hrOrgApproverRequest) {
        LambdaQueryWrapper<HrOrgApprover> wrapper = createWrapper(hrOrgApproverRequest);
        Page<HrOrgApprover> sysRolePage = this.page(PageFactory.defaultPage(), wrapper);
        return PageResultFactory.createPageResult(sysRolePage);
    }

    @Override
    public List<SimpleDict> getApproverTypeList() {
        return dictApi.getDictDetailsByDictTypeCode(ApproverConstants.APPROVER_TYPE_DICT_TYPE_CODE);
    }

    @Override
    public List<HrOrgApprover> findList(HrOrgApproverRequest hrOrgApproverRequest) {
        LambdaQueryWrapper<HrOrgApprover> wrapper = this.createWrapper(hrOrgApproverRequest);
        return this.list(wrapper);
    }

    @Override
    public void validateHaveOrgBind(Set<Long> beRemovedOrgIdList) {
        // none
    }

    @Override
    public void removeOrgAction(Set<Long> beRemovedOrgIdList) {
        LambdaUpdateWrapper<HrOrgApprover> hrOrgApproverLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        hrOrgApproverLambdaUpdateWrapper.in(HrOrgApprover::getOrgId, beRemovedOrgIdList);
        this.remove(hrOrgApproverLambdaUpdateWrapper);
    }

    /**
     * 获取信息
     *
     * @author fengshuonan
     * @date 2023/06/10 21:23
     */
    private HrOrgApprover queryHrOrgApprover(HrOrgApproverRequest hrOrgApproverRequest) {
        HrOrgApprover hrOrgApprover = this.getById(hrOrgApproverRequest.getOrgApproverId());
        if (ObjectUtil.isEmpty(hrOrgApprover)) {
            throw new ServiceException(HrOrgApproverExceptionEnum.HR_ORG_APPROVER_NOT_EXISTED);
        }
        return hrOrgApprover;
    }

    /**
     * 创建查询wrapper
     *
     * @author fengshuonan
     * @date 2023/06/10 21:23
     */
    private LambdaQueryWrapper<HrOrgApprover> createWrapper(HrOrgApproverRequest hrOrgApproverRequest) {
        LambdaQueryWrapper<HrOrgApprover> queryWrapper = new LambdaQueryWrapper<>();

        // 根据审批人类型查询
        Integer orgApproverType = hrOrgApproverRequest.getOrgApproverType();
        queryWrapper.eq(ObjectUtil.isNotNull(orgApproverType), HrOrgApprover::getOrgApproverType, orgApproverType);

        // 根据组织机构id查询
        Long orgId = hrOrgApproverRequest.getOrgId();
        queryWrapper.eq(ObjectUtil.isNotNull(orgId), HrOrgApprover::getOrgId, orgId);

        return queryWrapper;
    }

}