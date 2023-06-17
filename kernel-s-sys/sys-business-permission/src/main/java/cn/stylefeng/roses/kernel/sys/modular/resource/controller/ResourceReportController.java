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
package cn.stylefeng.roses.kernel.sys.modular.resource.controller;

import cn.stylefeng.roses.kernel.rule.enums.ResBizTypeEnum;
import cn.stylefeng.roses.kernel.scanner.api.ResourceReportApi;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.scanner.api.pojo.resource.ReportResourceParam;
import cn.stylefeng.roses.kernel.scanner.api.pojo.resource.SysResourcePersistencePojo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 微服务汇报资源接口
 *
 * @author fengshuonan
 * @since 2021/9/25 17:55
 */
@RestController
@ApiResource(name = "微服务汇报资源接口", resBizType = ResBizTypeEnum.SYSTEM)
public class ResourceReportController {

    @Resource
    private ResourceReportApi resourceReportApi;

    /**
     * 接收远程服务资源
     *
     * @author fengshuonan
     * @since 2021/9/25 17:55
     */
    @PostResource(path = "/resourceService/reportResources", name = "汇报资源")
    public void reportResources(@RequestBody ReportResourceParam reportResourceReq) {
        resourceReportApi.reportResources(reportResourceReq);
    }

    /**
     * 接收远程服务资源
     *
     * @author fengshuonan
     * @since 2021/9/25 17:55
     */
    @PostResource(path = "/resourceService/reportResourcesAndGetResult", name = "汇报资源")
    public List<SysResourcePersistencePojo> reportResourcesAndGetResult(@RequestBody ReportResourceParam reportResourceReq) {
        return resourceReportApi.reportResourcesAndGetResult(reportResourceReq);
    }

}
