/*
 * Copyright [2020-2030] [https://www.stylefeng.cn]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Guns源码头部的版权声明。
 * 3.请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns
 * 5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns
 * 6.若您的项目无法满足以上几点，可申请商业授权
 */
package cn.stylefeng.roses.kernel.sys.api;

import cn.stylefeng.roses.kernel.sys.api.pojo.user.OnlineUserItem;
import cn.stylefeng.roses.kernel.sys.api.pojo.user.SimpleUserDTO;
import cn.stylefeng.roses.kernel.sys.api.pojo.user.UserValidateDTO;

import java.util.List;

/**
 * 基础核心业务Api
 *
 * @author fengshuonan
 * @date 2023-06-10 20:50:43
 */
public interface SysUserServiceApi {

    /**
     * 获取用户的基本信息
     *
     * @author fengshuonan
     * @since 2023/6/11 21:07
     */
    SimpleUserDTO getUserInfoByUserId(Long userId);

    /**
     * 获取用户真实姓名
     *
     * @author fengshuonan
     * @since 2023/6/16 22:26
     */
    String getUserRealName(Long userId);

    /**
     * 获取用于用户校验的
     *
     * @param account 用户账号
     * @author fengshuonan
     * @since 2023/6/17 21:56
     */
    UserValidateDTO getUserLoginValidateDTO(String account);

    /**
     * 更新用户的登录ip和最后登录时间
     *
     * @author fengshuonan
     * @since 2023/6/17 22:46
     */
    void updateUserLoginInfo(Long userId, String ip);

    /**
     * 获取用户是否是超级管理员
     *
     * @author fengshuonan
     * @since 2023/6/17 23:09
     */
    boolean getUserSuperAdminFlag(Long userId);

    /**
     * 查询所有的用户id集合
     *
     * @author fengshuonan
     * @since 2023/6/18 9:05
     */
    List<Long> queryAllUserIdList();

    /**
     * 判断用户是否存在
     *
     * @author fengshuonan
     * @since 2023/6/18 9:06
     */
    Boolean userExist(Long userId);

    /**
     * 获取用户的账号和姓名信息
     * <p>
     * 一般用在获取在线用户列表
     *
     * @author fengshuonan
     * @since 2023/7/2 13:22
     */
    OnlineUserItem getUserNameAccountInfo(Long userId);

    /**
     * 获取用户账号和姓名信息
     * <p>
     * 一般用在获取在线用户列表
     *
     * @param onlineUserItems 查询条件，在此用户id列表中查询
     * @param searchText      查询条件，查询账号或姓名包含此字符串的结果
     * @author fengshuonan
     * @since 2023/7/2 13:36
     */
    List<OnlineUserItem> getUserNameAccountInfoListByCondition(List<OnlineUserItem> onlineUserItems, String searchText);

}