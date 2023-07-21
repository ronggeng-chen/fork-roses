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
package cn.stylefeng.roses.kernel.log.requestapi.service;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.log.api.pojo.manage.LogManagerRequest;
import cn.stylefeng.roses.kernel.log.requestapi.entity.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 日志记录 service接口
 *
 * @author luojie
 * @since 2020/11/2 17:44
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 新增
     *
     * @param logManagerRequest 参数对象
     * @author chenjinlong
     * @since 2021/1/26 12:52
     */
    void add(LogManagerRequest logManagerRequest);

    /**
     * 删除
     *
     * @param logManagerRequest 参数对象
     * @author chenjinlong
     * @since 2021/1/26 12:52
     */
    void del(LogManagerRequest logManagerRequest);

    /**
     * 删除所有数据
     *
     * @param logManagerRequest 参数对象
     * @author chenjinlong
     * @since 2021/1/26 12:52
     */
    void delAll(LogManagerRequest logManagerRequest);

    /**
     * 查看日志详情
     *
     * @author TSQ
     * @since 2021/1/11 17:51
     */
    SysLog detail(LogManagerRequest logManagerParam);

    /**
     * 查询-列表-按实体对象
     *
     * @param logManagerParam 参数对象
     * @author chenjinlong
     * @since 2021/1/26 12:52
     */
    List<SysLog> findList(LogManagerRequest logManagerParam);

    /**
     * 查询-列表-分页-按实体对象
     *
     * @param logManagerParam 参数对象
     * @author chenjinlong
     * @since 2021/1/26 12:52
     */
    PageResult<SysLog> findPage(LogManagerRequest logManagerParam);

}
