package heapStark.jackson;

import heapStark.utils.BaseCodeEnum;

/**
 * Created by wangzhilei3 on 2017/12/28.
 */
public enum Gender implements BaseCodeEnum {
    MALE(1, "男"),
    FEMALE(2, "女");
    private int code;
    private String message;

    Gender(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Gender{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
