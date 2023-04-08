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
package cn.stylefeng.roses.kernel.mongodb.api;

import java.util.List;
import java.util.Optional;

/**
 * Mongodb数据存储的api，适用于存map类型数据，存储在guns_map集合中
 *
 * @author huziyang
 * @since 2021/03/20 16:24
 */
public interface MongodbApi<T, ID> {

    /**
     * 新增数据
     *
     * @param gunsMapEntity 数据存储的参数
     * @return 返回数据结果
     * @author huziyang
     * @since 2020/10/27 17:38
     */
    T insert(T gunsMapEntity);

    /**
     * 修改数据
     *
     * @param gunsMapEntity 数据存储的参数
     * @return 返回数据结果
     * @author huziyang
     * @since 2020/10/27 17:38
     */
    T update(T gunsMapEntity);

    /**
     * 根据id删除
     *
     * @param id 集合id
     * @author huziyang
     * @since 2020/10/27 17:38
     */
    void deleteById(ID id);

    /**
     * 根据id查询
     *
     * @param id 集合id
     * @return 返回查询到数据的Optional
     * @author huziyang
     * @since 2020/10/27 17:38
     */
    Optional<T> findById(ID id);

    /**
     * 查询所有数据
     *
     * @return 返回所有数据列表
     * @author huziyang
     * @since 2020/10/27 17:38
     */
    List<T> findAll();
}
