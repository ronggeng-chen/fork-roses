package cn.stylefeng.roses.kernel.sys.modular.org.controller;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.sys.modular.org.entity.HrOrganization;
import cn.stylefeng.roses.kernel.sys.modular.org.pojo.request.HrOrganizationRequest;
import cn.stylefeng.roses.kernel.sys.modular.org.service.HrOrganizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 组织机构信息控制器
 *
 * @author fengshuonan
 * @date 2023/06/10 21:23
 */
@RestController
@ApiResource(name = "组织机构信息")
public class HrOrganizationController {

    @Resource
    private HrOrganizationService hrOrganizationService;

    /**
     * 添加组织机构
     *
     * @author fengshuonan
     * @date 2023/06/10 21:23
     */
    @PostResource(name = "添加组织机构", path = "/hrOrganization/add")
    public ResponseData<HrOrganization> add(@RequestBody @Validated(HrOrganizationRequest.add.class) HrOrganizationRequest hrOrganizationRequest) {
        hrOrganizationService.add(hrOrganizationRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 删除组织机构
     *
     * @author fengshuonan
     * @date 2023/06/10 21:23
     */
    @PostResource(name = "删除组织机构", path = "/hrOrganization/delete")
    public ResponseData<?> delete(@RequestBody @Validated(HrOrganizationRequest.delete.class) HrOrganizationRequest hrOrganizationRequest) {
        hrOrganizationService.del(hrOrganizationRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 编辑组织机构
     *
     * @author fengshuonan
     * @date 2023/06/10 21:23
     */
    @PostResource(name = "编辑组织机构", path = "/hrOrganization/edit")
    public ResponseData<?> edit(@RequestBody @Validated(HrOrganizationRequest.edit.class) HrOrganizationRequest hrOrganizationRequest) {
        hrOrganizationService.edit(hrOrganizationRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 查看组织机构详情
     *
     * @author fengshuonan
     * @date 2023/06/10 21:23
     */
    @GetResource(name = "查看组织机构详情", path = "/hrOrganization/detail")
    public ResponseData<HrOrganization> detail(@Validated(HrOrganizationRequest.detail.class) HrOrganizationRequest hrOrganizationRequest) {
        return new SuccessResponseData<>(hrOrganizationService.detail(hrOrganizationRequest));
    }

    /**
     * 获取列表（带分页）
     *
     * @author fengshuonan
     * @date 2023/06/10 21:23
     */
    @GetResource(name = "分页查询-组织机构", path = "/hrOrganization/page")
    public ResponseData<PageResult<HrOrganization>> page(HrOrganizationRequest hrOrganizationRequest) {
        return new SuccessResponseData<>(hrOrganizationService.findPage(hrOrganizationRequest));
    }

}