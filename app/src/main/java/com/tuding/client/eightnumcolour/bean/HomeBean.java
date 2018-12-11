package com.tuding.client.eightnumcolour.bean;

import java.util.List;

public class HomeBean {

    /**
     * code : 1
     * msg : ok
     * data : [{"image":"http://bhcd-admin.tudingsoft.com/Uploads/Banner/5b5fd65a02487.jpg","link":"","title":"首页幻灯片","detail":"http://bhcd-admin.tudingsoft.com/Uploads/Banner/5b5fdb09348f9.png"},{"image":"http://bhcd-admin.tudingsoft.com/Uploads/Banner/5b5fd64ed7b2a.jpg","link":"","title":"首页","detail":""},{"image":"http://bhcd-admin.tudingsoft.com/Uploads/Banner/5b5fd629cdc83.jpg","link":"","title":"banner","detail":"http://bhcd-admin.tudingsoft.com/Uploads/Banner/5b5fdac5afb5a.png"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * image : http://bhcd-admin.tudingsoft.com/Uploads/Banner/5b5fd65a02487.jpg
         * link :
         * title : 首页幻灯片
         * detail : http://bhcd-admin.tudingsoft.com/Uploads/Banner/5b5fdb09348f9.png
         */

        private String image;
        private String link;
        private String title;
        private String detail;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
