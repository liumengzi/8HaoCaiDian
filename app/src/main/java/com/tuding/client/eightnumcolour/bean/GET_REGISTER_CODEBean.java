package com.tuding.client.eightnumcolour.bean;


public class GET_REGISTER_CODEBean {

    /**
     * code : 0
     * msg : 发送失败
     * data : {"Message":"触发天级流控Permits:10","RequestId":"7255C7E5-DDAC-4184-9AB6-4DA727178B74","Code":"isv.BUSINESS_LIMIT_CONTROL"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Message : 触发天级流控Permits:10
         * RequestId : 7255C7E5-DDAC-4184-9AB6-4DA727178B74
         * Code : isv.BUSINESS_LIMIT_CONTROL
         */

        private String Message;
        private String RequestId;
        private String Code;

        public String getMessage() {
            return Message;
        }

        public void setMessage(String Message) {
            this.Message = Message;
        }

        public String getRequestId() {
            return RequestId;
        }

        public void setRequestId(String RequestId) {
            this.RequestId = RequestId;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }
    }
}
