package com.tuding.client.eightnumcolour.bean;

import java.util.List;

public class NOTERESULTBean {

    /**
     * code : 1
     * data : {"ft6":{"expect_no":"18172","kj_date":"2018-12-13","expect_type":"lcbqc","result":["3","1","3","3","0","0","1","3","3","3","3","3"]},"ft9":{"expect_no":"18167","kj_date":"2018-12-13","expect_type":"sf","result":["0","1","1","1","0","3","3","0","1","3","3","3","1","3"]},"dlt":{"expect_no":"18146","kj_date":"2018-12-12","expect_type":"dlt","result_red":["03","08","09","13","33"],"result_blue":["01","02"]},"ssq":{"expect_no":"18145","kj_date":"2018-12-11","expect_type":"ssq","result_red":["03","09","13","22","23","25"],"result_blue":["06"]}}
     * msg : 成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * ft6 : {"expect_no":"18172","kj_date":"2018-12-13","expect_type":"lcbqc","result":["3","1","3","3","0","0","1","3","3","3","3","3"]}
         * ft9 : {"expect_no":"18167","kj_date":"2018-12-13","expect_type":"sf","result":["0","1","1","1","0","3","3","0","1","3","3","3","1","3"]}
         * dlt : {"expect_no":"18146","kj_date":"2018-12-12","expect_type":"dlt","result_red":["03","08","09","13","33"],"result_blue":["01","02"]}
         * ssq : {"expect_no":"18145","kj_date":"2018-12-11","expect_type":"ssq","result_red":["03","09","13","22","23","25"],"result_blue":["06"]}
         */

        private Ft6Bean ft6;
        private Ft9Bean ft9;
        private DltBean dlt;
        private SsqBean ssq;

        public Ft6Bean getFt6() {
            return ft6;
        }

        public void setFt6(Ft6Bean ft6) {
            this.ft6 = ft6;
        }

        public Ft9Bean getFt9() {
            return ft9;
        }

        public void setFt9(Ft9Bean ft9) {
            this.ft9 = ft9;
        }

        public DltBean getDlt() {
            return dlt;
        }

        public void setDlt(DltBean dlt) {
            this.dlt = dlt;
        }

        public SsqBean getSsq() {
            return ssq;
        }

        public void setSsq(SsqBean ssq) {
            this.ssq = ssq;
        }

        public static class Ft6Bean {
            /**
             * expect_no : 18172
             * kj_date : 2018-12-13
             * expect_type : lcbqc
             * result : ["3","1","3","3","0","0","1","3","3","3","3","3"]
             */

            private String expect_no;
            private String kj_date;
            private String expect_type;
            private List<String> result;

            public String getExpect_no() {
                return expect_no;
            }

            public void setExpect_no(String expect_no) {
                this.expect_no = expect_no;
            }

            public String getKj_date() {
                return kj_date;
            }

            public void setKj_date(String kj_date) {
                this.kj_date = kj_date;
            }

            public String getExpect_type() {
                return expect_type;
            }

            public void setExpect_type(String expect_type) {
                this.expect_type = expect_type;
            }

            public List<String> getResult() {
                return result;
            }

            public void setResult(List<String> result) {
                this.result = result;
            }
        }

        public static class Ft9Bean {
            /**
             * expect_no : 18167
             * kj_date : 2018-12-13
             * expect_type : sf
             * result : ["0","1","1","1","0","3","3","0","1","3","3","3","1","3"]
             */

            private String expect_no;
            private String kj_date;
            private String expect_type;
            private List<String> result;

            public String getExpect_no() {
                return expect_no;
            }

            public void setExpect_no(String expect_no) {
                this.expect_no = expect_no;
            }

            public String getKj_date() {
                return kj_date;
            }

            public void setKj_date(String kj_date) {
                this.kj_date = kj_date;
            }

            public String getExpect_type() {
                return expect_type;
            }

            public void setExpect_type(String expect_type) {
                this.expect_type = expect_type;
            }

            public List<String> getResult() {
                return result;
            }

            public void setResult(List<String> result) {
                this.result = result;
            }
        }

        public static class DltBean {
            /**
             * expect_no : 18146
             * kj_date : 2018-12-12
             * expect_type : dlt
             * result_red : ["03","08","09","13","33"]
             * result_blue : ["01","02"]
             */

            private String expect_no;
            private String kj_date;
            private String expect_type;
            private List<String> result_red;
            private List<String> result_blue;

            public String getExpect_no() {
                return expect_no;
            }

            public void setExpect_no(String expect_no) {
                this.expect_no = expect_no;
            }

            public String getKj_date() {
                return kj_date;
            }

            public void setKj_date(String kj_date) {
                this.kj_date = kj_date;
            }

            public String getExpect_type() {
                return expect_type;
            }

            public void setExpect_type(String expect_type) {
                this.expect_type = expect_type;
            }

            public List<String> getResult_red() {
                return result_red;
            }

            public void setResult_red(List<String> result_red) {
                this.result_red = result_red;
            }

            public List<String> getResult_blue() {
                return result_blue;
            }

            public void setResult_blue(List<String> result_blue) {
                this.result_blue = result_blue;
            }
        }

        public static class SsqBean {
            /**
             * expect_no : 18145
             * kj_date : 2018-12-11
             * expect_type : ssq
             * result_red : ["03","09","13","22","23","25"]
             * result_blue : ["06"]
             */

            private String expect_no;
            private String kj_date;
            private String expect_type;
            private List<String> result_red;
            private List<String> result_blue;

            public String getExpect_no() {
                return expect_no;
            }

            public void setExpect_no(String expect_no) {
                this.expect_no = expect_no;
            }

            public String getKj_date() {
                return kj_date;
            }

            public void setKj_date(String kj_date) {
                this.kj_date = kj_date;
            }

            public String getExpect_type() {
                return expect_type;
            }

            public void setExpect_type(String expect_type) {
                this.expect_type = expect_type;
            }

            public List<String> getResult_red() {
                return result_red;
            }

            public void setResult_red(List<String> result_red) {
                this.result_red = result_red;
            }

            public List<String> getResult_blue() {
                return result_blue;
            }

            public void setResult_blue(List<String> result_blue) {
                this.result_blue = result_blue;
            }
        }
    }
}
