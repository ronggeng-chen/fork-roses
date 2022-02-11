package cn.stylefeng.roses.kernel.system.modular.home.service;

import cn.stylefeng.roses.kernel.log.api.pojo.record.LogRecordDTO;
import cn.stylefeng.roses.kernel.system.api.pojo.home.HomeCompanyInfo;
import cn.stylefeng.roses.kernel.system.api.pojo.user.request.OnlineUserRequest;
import cn.stylefeng.roses.kernel.system.modular.menu.entity.SysMenu;
import cn.stylefeng.roses.kernel.system.modular.statistic.pojo.OnlineUserStat;

import java.util.List;

/**
 * 首页服务接口
 *
 * @author fengshuonan
 * @date 2022/2/11 20:41
 */
public interface HomePageService {

    /**
     * 查询本用户最近操作记录
     *
     * @author fengshuonan
     * @date 2022/2/11 20:40
     */
    List<LogRecordDTO> getRecentLogs();

    /**
     * 获取在线用户统计
     *
     * @author fengshuonan
     * @date 2022/2/11 20:40
     */
    OnlineUserStat getOnlineUserList(OnlineUserRequest onlineUserRequest);

    /**
     * 获取首页公司部门人员信息统计
     *
     * @author fengshuonan
     * @date 2022/2/11 21:03
     */
    HomeCompanyInfo getHomeCompanyInfo();

    /**
     * 获取常用功能
     *
     * @author xixiaowei
     * @date 2022/2/10 11:19
     */
    List<SysMenu> getCommonFunctions();

    /**
     * 数据统计
     *
     * @author xixiaowei
     * @date 2022/2/10 12:07
     */
    void saveStatisticsCacheToDb();
}
