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
package cn.stylefeng.roses.kernel.db.api.factory;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.PageUtil;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 分页的返回结果创建工厂
 * <p>
 * 一般由mybatis-plus的Page对象转为PageResult
 *
 * @author fengshuonan
 * @since 2020/10/15 16:57
 */
public class PageResultFactory {

    /**
     * 将mybatis-plus的page转成自定义的PageResult，扩展了totalPage总页数
     *
     * @author fengshuonan
     * @since 2020/10/15 15:53
     */
    public static <T> PageResult<T> createPageResult(Page<T> page) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setRows(page.getRecords());
        pageResult.setTotalRows(Convert.toInt(page.getTotal()));
        pageResult.setPageNo(Convert.toInt(page.getCurrent()));
        pageResult.setPageSize(Convert.toInt(page.getSize()));
        pageResult.setTotalPage(
                PageUtil.totalPage(pageResult.getTotalRows(), pageResult.getPageSize()));
        return pageResult;
    }

    /**
     * 将mybatis-plus的page转成自定义的PageResult，扩展了totalPage总页数
     *
     * @author fengshuonan
     * @since 2020/10/15 15:53
     */
    public static <T> PageResult<T> createPageResult(List<T> rows, Long count, Integer pageSize, Integer pageNo) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setRows(rows);
        pageResult.setTotalRows(Convert.toInt(count));
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalPage(PageUtil.totalPage(pageResult.getTotalRows(), pageSize));
        return pageResult;
    }

}
