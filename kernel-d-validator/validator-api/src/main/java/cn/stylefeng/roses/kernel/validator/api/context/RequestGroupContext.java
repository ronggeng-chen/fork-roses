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
package cn.stylefeng.roses.kernel.validator.api.context;

/**
 * 保存控制器的方法上的校验组，group class
 *
 * @author fengshuonan
 * @since 2020/11/4 14:31
 */
public class RequestGroupContext {

    private static final ThreadLocal<Class<?>> GROUP_CLASS_HOLDER = new ThreadLocal<>();

    /**
     * 设置临时的校验分组
     *
     * @author fengshuonan
     * @since 2020/11/4 14:32
     */
    public static void set(Class<?> groupValue) {
        GROUP_CLASS_HOLDER.set(groupValue);
    }

    /**
     * 获取临时校验分组
     *
     * @author fengshuonan
     * @since 2020/11/4 14:32
     */
    public static Class<?> get() {
        return GROUP_CLASS_HOLDER.get();
    }

    /**
     * 清除临时缓存的校验分组
     *
     * @author fengshuonan
     * @since 2020/11/4 14:32
     */
    public static void clear() {
        GROUP_CLASS_HOLDER.remove();
    }

}
