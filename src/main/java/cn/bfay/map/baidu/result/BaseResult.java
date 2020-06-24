package cn.bfay.map.baidu.result;

/**
 * BaseResult.
 *
 * @author wangjiannan
 */
public class BaseResult {
    /**
     * 结果状态.
     */
    private Integer status;
    /**
     * 错误信息.
     */
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
