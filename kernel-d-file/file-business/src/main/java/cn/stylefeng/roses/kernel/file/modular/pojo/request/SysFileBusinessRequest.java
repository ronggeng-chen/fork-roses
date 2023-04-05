package cn.stylefeng.roses.kernel.file.modular.pojo.request;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 业务关联的文件封装类
 *
 * @author fengshuonan
 * @date 2023/03/31 13:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysFileBusinessRequest extends BaseRequest {

    /**
     * 主键id
     */
    @NotNull(message = "主键id不能为空", groups = {edit.class, delete.class})
    @ChineseDescription("主键id")
    private Long fileBusinessId;

    /**
     * 业务的编码，业务自定义
     */
    @ChineseDescription("业务的编码，业务自定义")
    private String businessCode;

    /**
     * 业务主键id
     */
    @ChineseDescription("业务主键id")
    @NotNull(message = "业务主键id不能为空", groups = addFileDownloadCount.class)
    private Long businessId;

    /**
     * 关联文件表的id
     */
    @ChineseDescription("关联文件表的id")
    @NotNull(message = "文件id不能为空", groups = addFileDownloadCount.class)
    private Long fileId;

    /**
     * 下载次数
     */
    @ChineseDescription("下载次数")
    private Integer downloadCount;

    /**
     * 租户id
     */
    @ChineseDescription("租户id")
    private Long tenantId;

    /**
     * 添加文件下载次数
     */
    public @interface addFileDownloadCount {

    }

}
