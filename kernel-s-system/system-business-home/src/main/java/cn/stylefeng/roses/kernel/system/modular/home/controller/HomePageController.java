package cn.stylefeng.roses.kernel.system.modular.home.controller;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.log.api.pojo.manage.LogManagerRequest;
import cn.stylefeng.roses.kernel.log.api.pojo.record.LogRecordDTO;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.system.api.pojo.home.HomeCompanyInfo;
import cn.stylefeng.roses.kernel.system.api.pojo.resource.ResourceRequest;
import cn.stylefeng.roses.kernel.system.api.pojo.user.OnlineUserDTO;
import cn.stylefeng.roses.kernel.system.api.pojo.user.request.OnlineUserRequest;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.system.modular.home.service.HomePageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页控制器
 *
 * @author xixiaowei
 * @date 2022/1/25 9:44
 */
@RestController
@ApiResource(name = "首页")
public class HomePageController {

    @Resource
    private HomePageService homePageService;

    /**
     * 查询动态列表
     *
     * @author xixiaowei
     * @date 2022/1/25 14:52
     */
    @GetResource(name = "查询动态列表", path = "/homePage/getDynamicList")
    public ResponseData<List<LogRecordDTO>> getDynamicList(LogManagerRequest logManagerRequest) {
        return new SuccessResponseData<>(homePageService.getDynamicList(logManagerRequest));
    }

    /**
     * 查询动态列表(分页)
     *
     * @author xixiaowei
     * @date 2022/1/25 10:00
     */
    @GetResource(name = "查询动态列表(分页)", path = "/homePage/getDynamicPage")
    public ResponseData<PageResult<LogRecordDTO>> getDynamicPage(LogManagerRequest logManagerRequest) {
        return new SuccessResponseData<>(homePageService.getDynamicPage(logManagerRequest));
    }

    /**
     * 查询在线用户列表
     *
     * @author xixiaowei
     * @date 2022/1/25 14:11
     */
    @GetResource(name = "查询在线用户列表", path = "/homePage/getOnlineUserList")
    public ResponseData<List<OnlineUserDTO>> getOnlineUserList(OnlineUserRequest onlineUserRequest) {
        return new SuccessResponseData<>(homePageService.getOnlineUserList(onlineUserRequest));
    }

    /**
     * 获取首页企业和公司信息
     *
     * @author xixiaowei
     * @date 2022/2/9 10:12
     */
    @GetResource(name = "获取首页企业和公司信息", path = "/homePage/getHomeCompanyInfo")
    public ResponseData<HomeCompanyInfo> getHomeCompanyInfo() {
        return new SuccessResponseData<>(homePageService.getHomeCompanyInfo());
    }

    /**
     * 获取常用功能接口
     *
     * @author xixiaowei
     * @date 2022/2/10 11:34
     */
    @GetResource(name = "获取常用功能接口", path = "/homePage/getCommonFunctions")
    public ResponseData<List<ResourceRequest>> getCommonFunctions() {
        return new SuccessResponseData<>(homePageService.getCommonFunctions());
    }
}