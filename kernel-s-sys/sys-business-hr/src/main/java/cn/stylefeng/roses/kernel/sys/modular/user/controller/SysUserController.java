package cn.stylefeng.roses.kernel.sys.modular.user.controller;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.sys.modular.user.entity.SysUser;
import cn.stylefeng.roses.kernel.sys.modular.user.pojo.request.SysUserRequest;
import cn.stylefeng.roses.kernel.sys.modular.user.service.SysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统用户控制器
 *
 * @author fengshuonan
 * @date 2023/06/10 21:26
 */
@RestController
@ApiResource(name = "系统用户")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 添加
     *
     * @author fengshuonan
     * @date 2023/06/10 21:26
     */
    @PostResource(name = "添加", path = "/sysUser/add")
    public ResponseData<SysUser> add(@RequestBody @Validated(SysUserRequest.add.class) SysUserRequest sysUserRequest) {
        sysUserService.add(sysUserRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 删除
     *
     * @author fengshuonan
     * @date 2023/06/10 21:26
     */
    @PostResource(name = "删除", path = "/sysUser/delete")
    public ResponseData<?> delete(@RequestBody @Validated(SysUserRequest.delete.class) SysUserRequest sysUserRequest) {
        sysUserService.del(sysUserRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 编辑
     *
     * @author fengshuonan
     * @date 2023/06/10 21:26
     */
    @PostResource(name = "编辑", path = "/sysUser/edit")
    public ResponseData<?> edit(@RequestBody @Validated(SysUserRequest.edit.class) SysUserRequest sysUserRequest) {
        sysUserService.edit(sysUserRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 查看详情
     *
     * @author fengshuonan
     * @date 2023/06/10 21:26
     */
    @GetResource(name = "查看详情", path = "/sysUser/detail")
    public ResponseData<SysUser> detail(@Validated(SysUserRequest.detail.class) SysUserRequest sysUserRequest) {
        return new SuccessResponseData<>(sysUserService.detail(sysUserRequest));
    }

    /**
     * 获取列表
     *
     * @author fengshuonan
     * @date 2023/06/10 21:26
     */
    @GetResource(name = "获取列表", path = "/sysUser/list")
    public ResponseData<List<SysUser>> list(SysUserRequest sysUserRequest) {
        return new SuccessResponseData<>(sysUserService.findList(sysUserRequest));
    }

    /**
     * 获取列表（带分页）
     *
     * @author fengshuonan
     * @date 2023/06/10 21:26
     */
    @GetResource(name = "分页查询", path = "/sysUser/page")
    public ResponseData<PageResult<SysUser>> page(SysUserRequest sysUserRequest) {
        return new SuccessResponseData<>(sysUserService.findPage(sysUserRequest));
    }

}