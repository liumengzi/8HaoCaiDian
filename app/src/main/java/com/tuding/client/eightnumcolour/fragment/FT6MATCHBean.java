package com.tuding.client.eightnumcolour.fragment;

import java.util.List;

public class FT6MATCHBean {

    /**
     * code : 1
     * data : {"expect_no":"18173","end_time":"2018-12-13 22:55:00","matchList":[{"league":"欧罗巴","home_team":"拉齐奥","away_team":"法兰克","begin_time":"01:55","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"2.45"},{"name":"平","key":1,"odds":"2.18"},{"name":"负","key":0,"odds":"3.48"}],"bqc2":[{"name":"胜","key":3,"odds":"2.08"},{"name":"平","key":1,"odds":"3.60"},{"name":"负","key":0,"odds":"3.24"}]}},{"league":"欧罗巴","home_team":"维迪奥","away_team":"切尔西","begin_time":"01:55","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"5.70"},{"name":"平","key":1,"odds":"2.03"},{"name":"负","key":0,"odds":"2.07"}],"bqc2":[{"name":"胜","key":3,"odds":"5.23"},{"name":"平","key":1,"odds":"3.70"},{"name":"负","key":0,"odds":"1.66"}]}},{"league":"欧罗巴","home_team":"莱比锡","away_team":"罗森博","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"1.47"},{"name":"平","key":1,"odds":"2.92"},{"name":"负","key":0,"odds":"7.80"}],"bqc2":[{"name":"胜","key":3,"odds":"1.15"},{"name":"平","key":1,"odds":"7.93"},{"name":"负","key":0,"odds":"15.20"}]}},{"league":"欧罗巴","home_team":"阿森纳","away_team":"卡拉巴","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"1.53"},{"name":"平","key":1,"odds":"2.68"},{"name":"负","key":0,"odds":"7.80"}],"bqc2":[{"name":"胜","key":3,"odds":"1.21"},{"name":"平","key":1,"odds":"6.21"},{"name":"负","key":0,"odds":"12.35"}]}},{"league":"欧罗巴","home_team":"迪德朗","away_team":"贝蒂斯","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"6.20"},{"name":"平","key":1,"odds":"2.45"},{"name":"负","key":0,"odds":"1.72"}],"bqc2":[{"name":"胜","key":3,"odds":"8.33"},{"name":"平","key":1,"odds":"5.22"},{"name":"负","key":0,"odds":"1.33"}]}},{"league":"欧罗巴","home_team":"奥林匹","away_team":"AC米兰","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"3.12"},{"name":"平","key":1,"odds":"1.98"},{"name":"负","key":0,"odds":"3.07"}],"bqc2":[{"name":"胜","key":3,"odds":"2.70"},{"name":"平","key":1,"odds":"3.22"},{"name":"负","key":0,"odds":"2.60"}]}}]}
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
         * expect_no : 18173
         * end_time : 2018-12-13 22:55:00
         * matchList : [{"league":"欧罗巴","home_team":"拉齐奥","away_team":"法兰克","begin_time":"01:55","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"2.45"},{"name":"平","key":1,"odds":"2.18"},{"name":"负","key":0,"odds":"3.48"}],"bqc2":[{"name":"胜","key":3,"odds":"2.08"},{"name":"平","key":1,"odds":"3.60"},{"name":"负","key":0,"odds":"3.24"}]}},{"league":"欧罗巴","home_team":"维迪奥","away_team":"切尔西","begin_time":"01:55","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"5.70"},{"name":"平","key":1,"odds":"2.03"},{"name":"负","key":0,"odds":"2.07"}],"bqc2":[{"name":"胜","key":3,"odds":"5.23"},{"name":"平","key":1,"odds":"3.70"},{"name":"负","key":0,"odds":"1.66"}]}},{"league":"欧罗巴","home_team":"莱比锡","away_team":"罗森博","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"1.47"},{"name":"平","key":1,"odds":"2.92"},{"name":"负","key":0,"odds":"7.80"}],"bqc2":[{"name":"胜","key":3,"odds":"1.15"},{"name":"平","key":1,"odds":"7.93"},{"name":"负","key":0,"odds":"15.20"}]}},{"league":"欧罗巴","home_team":"阿森纳","away_team":"卡拉巴","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"1.53"},{"name":"平","key":1,"odds":"2.68"},{"name":"负","key":0,"odds":"7.80"}],"bqc2":[{"name":"胜","key":3,"odds":"1.21"},{"name":"平","key":1,"odds":"6.21"},{"name":"负","key":0,"odds":"12.35"}]}},{"league":"欧罗巴","home_team":"迪德朗","away_team":"贝蒂斯","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"6.20"},{"name":"平","key":1,"odds":"2.45"},{"name":"负","key":0,"odds":"1.72"}],"bqc2":[{"name":"胜","key":3,"odds":"8.33"},{"name":"平","key":1,"odds":"5.22"},{"name":"负","key":0,"odds":"1.33"}]}},{"league":"欧罗巴","home_team":"奥林匹","away_team":"AC米兰","begin_time":"04:00","begin_date":"12-14","odds":{"bqc1":[{"name":"胜","key":3,"odds":"3.12"},{"name":"平","key":1,"odds":"1.98"},{"name":"负","key":0,"odds":"3.07"}],"bqc2":[{"name":"胜","key":3,"odds":"2.70"},{"name":"平","key":1,"odds":"3.22"},{"name":"负","key":0,"odds":"2.60"}]}}]
         */

        private String expect_no;
        private String end_time;
        private List<MatchListBean> matchList;

        public String getExpect_no() {
            return expect_no;
        }

        public void setExpect_no(String expect_no) {
            this.expect_no = expect_no;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public List<MatchListBean> getMatchList() {
            return matchList;
        }

        public void setMatchList(List<MatchListBean> matchList) {
            this.matchList = matchList;
        }

        public static class MatchListBean {
            /**
             * league : 欧罗巴
             * home_team : 拉齐奥
             * away_team : 法兰克
             * begin_time : 01:55
             * begin_date : 12-14
             * odds : {"bqc1":[{"name":"胜","key":3,"odds":"2.45"},{"name":"平","key":1,"odds":"2.18"},{"name":"负","key":0,"odds":"3.48"}],"bqc2":[{"name":"胜","key":3,"odds":"2.08"},{"name":"平","key":1,"odds":"3.60"},{"name":"负","key":0,"odds":"3.24"}]}
             */

            private String league;
            private String home_team;
            private String away_team;
            private String begin_time;
            private String begin_date;
            private OddsBean odds;

            public String getLeague() {
                return league;
            }

            public void setLeague(String league) {
                this.league = league;
            }

            public String getHome_team() {
                return home_team;
            }

            public void setHome_team(String home_team) {
                this.home_team = home_team;
            }

            public String getAway_team() {
                return away_team;
            }

            public void setAway_team(String away_team) {
                this.away_team = away_team;
            }

            public String getBegin_time() {
                return begin_time;
            }

            public void setBegin_time(String begin_time) {
                this.begin_time = begin_time;
            }

            public String getBegin_date() {
                return begin_date;
            }

            public void setBegin_date(String begin_date) {
                this.begin_date = begin_date;
            }

            public OddsBean getOdds() {
                return odds;
            }

            public void setOdds(OddsBean odds) {
                this.odds = odds;
            }

            public static class OddsBean {
                private List<Bqc1Bean> bqc1;
                private List<Bqc2Bean> bqc2;

                public List<Bqc1Bean> getBqc1() {
                    return bqc1;
                }

                public void setBqc1(List<Bqc1Bean> bqc1) {
                    this.bqc1 = bqc1;
                }

                public List<Bqc2Bean> getBqc2() {
                    return bqc2;
                }

                public void setBqc2(List<Bqc2Bean> bqc2) {
                    this.bqc2 = bqc2;
                }

                public static class Bqc1Bean {
                    /**
                     * name : 胜
                     * key : 3
                     * odds : 2.45
                     */

                    private String name;
                    private int key;
                    private String odds;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getKey() {
                        return key;
                    }

                    public void setKey(int key) {
                        this.key = key;
                    }

                    public String getOdds() {
                        return odds;
                    }

                    public void setOdds(String odds) {
                        this.odds = odds;
                    }
                }

                public static class Bqc2Bean {
                    /**
                     * name : 胜
                     * key : 3
                     * odds : 2.08
                     */

                    private String name;
                    private int key;
                    private String odds;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getKey() {
                        return key;
                    }

                    public void setKey(int key) {
                        this.key = key;
                    }

                    public String getOdds() {
                        return odds;
                    }

                    public void setOdds(String odds) {
                        this.odds = odds;
                    }
                }
            }
        }
    }
}
