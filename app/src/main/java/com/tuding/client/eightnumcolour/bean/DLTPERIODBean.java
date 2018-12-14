package com.tuding.client.eightnumcolour.bean;

public class DLTPERIODBean {

    /**
     * code : 1
     * msg : success
     * data : {"expert_no":"18147","end_time":"12-15 20:00"}
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
         * expert_no : 18147
         * end_time : 12-15 20:00
         */

        private String expert_no;
        private String end_time;

        public String getExpert_no() {
            return expert_no;
        }

        public void setExpert_no(String expert_no) {
            this.expert_no = expert_no;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }
    }
}
