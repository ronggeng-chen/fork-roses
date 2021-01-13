package cn.stylefeng.roses.kernel.message.api.pojo;

import cn.stylefeng.roses.kernel.message.api.enums.MessageProrityLevelEnum;
import cn.stylefeng.roses.kernel.message.api.enums.MessageReadFlagEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 系统消息的查询参数
 *
 * @author liuhanqing
 * @date 2021/1/2 21:23
 */
@Data
public class MessageResponse implements Serializable {

    /**
     * 消息id
     */
    private Long messageId;

    /**
     * 接收用户id
     */
    private Long receiveUserId;

    /**
     * 发送用户id
     */
    private Long sendUserId;

    /**
     * 消息标题
     */
    private String messageTitle;

    /**
     * 消息的内容
     */
    private String messageContent;

    /**
     * 消息优先级
     */
    private String priorityLevel;

    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 消息发送时间
     */
    private Date messageSendTime;

    /**
     * 业务id
     */
    private Long businessId;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 阅读状态：0-未读，1-已读
     */
    private Integer readFlag;

    /**
     * 消息优先级
     */
    private String priorityLevelValue;

    /**
     * 阅读状态：0-未读，1-已读
     */
    private String readFlagValue;

    public String getPriorityLevelValue(){
        AtomicReference<String> value = new AtomicReference<>("");
        Optional.ofNullable(this.priorityLevel).ifPresent(val ->{
            value.set(MessageProrityLevelEnum.getName(this.priorityLevel));
        });
        return value.get();
    }

    public String getReadFlagValue(){
        AtomicReference<String> value = new AtomicReference<>("");
        Optional.ofNullable(this.readFlag).ifPresent(val ->{
            value.set(MessageReadFlagEnum.getName(this.readFlag));
        });
        return value.get();
    }
}
