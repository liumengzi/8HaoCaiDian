package com.tuding.client.eightnumcolour.bean;

import java.util.List;

public class FT9MATCHBean {

    /**
     * code : 1
     * data : {"expect_no":"18168","end_time":"2018-12-13 22:55:00","matchList":[{"bet_no":"18168_rxj_1_0","league":"欧罗巴","home_team":"马赛","away_team":"阿波罗","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.47"},{"name":"平","key":1,"odds":"4.69"},{"name":"负","key":0,"odds":"5.91"}]},{"bet_no":"18168_rxj_2_0","league":"欧罗巴","home_team":"拉齐奥","away_team":"法兰克","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.08"},{"name":"平","key":1,"odds":"3.60"},{"name":"负","key":0,"odds":"3.24"}]},{"bet_no":"18168_rxj_3_0","league":"欧罗巴","home_team":"贝西克","away_team":"马尔默","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.58"},{"name":"平","key":1,"odds":"3.94"},{"name":"负","key":0,"odds":"5.66"}]},{"bet_no":"18168_rxj_4_0","league":"欧罗巴","home_team":"亨克","away_team":"萨堡","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.31"},{"name":"平","key":1,"odds":"5.30"},{"name":"负","key":0,"odds":"9.01"}]},{"bet_no":"18168_rxj_5_0","league":"欧罗巴","home_team":"雷恩","away_team":"阿斯塔","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.62"},{"name":"平","key":1,"odds":"3.74"},{"name":"负","key":0,"odds":"5.60"}]},{"bet_no":"18168_rxj_6_0","league":"欧罗巴","home_team":"维迪奥","away_team":"切尔西","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"5.22"},{"name":"平","key":1,"odds":"3.70"},{"name":"负","key":0,"odds":"1.66"}]},{"bet_no":"18168_rxj_7_0","league":"欧罗巴","home_team":"基辅","away_team":"亚布洛内","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.58"},{"name":"平","key":1,"odds":"3.88"},{"name":"负","key":0,"odds":"5.71"}]},{"bet_no":"18168_rxj_8_0","league":"欧罗巴","home_team":"拉尔纳","away_team":"勒沃","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"3.87"},{"name":"平","key":1,"odds":"3.58"},{"name":"负","key":0,"odds":"1.90"}]},{"bet_no":"18168_rxj_9_0","league":"欧罗巴","home_team":"凯尔特","away_team":"萨茨堡","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.40"},{"name":"平","key":1,"odds":"3.24"},{"name":"负","key":0,"odds":"2.93"}]},{"bet_no":"18168_rxj_10_0","league":"欧罗巴","home_team":"莱比锡","away_team":"罗森博","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.15"},{"name":"平","key":1,"odds":"7.93"},{"name":"负","key":0,"odds":"15.22"}]},{"bet_no":"18168_rxj_11_0","league":"欧罗巴","home_team":"哥本哈","away_team":"波尔多","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.11"},{"name":"平","key":1,"odds":"3.31"},{"name":"负","key":0,"odds":"3.46"}]},{"bet_no":"18168_rxj_12_0","league":"欧罗巴","home_team":"阿森纳","away_team":"卡拉巴","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.21"},{"name":"平","key":1,"odds":"6.21"},{"name":"负","key":0,"odds":"12.34"}]},{"bet_no":"18168_rxj_13_0","league":"欧罗巴","home_team":"迪德朗","away_team":"贝蒂斯","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"8.32"},{"name":"平","key":1,"odds":"5.22"},{"name":"负","key":0,"odds":"1.33"}]},{"bet_no":"18168_rxj_14_0","league":"欧罗巴","home_team":"奥林匹","away_team":"AC米兰","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.70"},{"name":"平","key":1,"odds":"3.22"},{"name":"负","key":0,"odds":"2.60"}]}]}
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
         * expect_no : 18168
         * end_time : 2018-12-13 22:55:00
         * matchList : [{"bet_no":"18168_rxj_1_0","league":"欧罗巴","home_team":"马赛","away_team":"阿波罗","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.47"},{"name":"平","key":1,"odds":"4.69"},{"name":"负","key":0,"odds":"5.91"}]},{"bet_no":"18168_rxj_2_0","league":"欧罗巴","home_team":"拉齐奥","away_team":"法兰克","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.08"},{"name":"平","key":1,"odds":"3.60"},{"name":"负","key":0,"odds":"3.24"}]},{"bet_no":"18168_rxj_3_0","league":"欧罗巴","home_team":"贝西克","away_team":"马尔默","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.58"},{"name":"平","key":1,"odds":"3.94"},{"name":"负","key":0,"odds":"5.66"}]},{"bet_no":"18168_rxj_4_0","league":"欧罗巴","home_team":"亨克","away_team":"萨堡","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.31"},{"name":"平","key":1,"odds":"5.30"},{"name":"负","key":0,"odds":"9.01"}]},{"bet_no":"18168_rxj_5_0","league":"欧罗巴","home_team":"雷恩","away_team":"阿斯塔","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.62"},{"name":"平","key":1,"odds":"3.74"},{"name":"负","key":0,"odds":"5.60"}]},{"bet_no":"18168_rxj_6_0","league":"欧罗巴","home_team":"维迪奥","away_team":"切尔西","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"5.22"},{"name":"平","key":1,"odds":"3.70"},{"name":"负","key":0,"odds":"1.66"}]},{"bet_no":"18168_rxj_7_0","league":"欧罗巴","home_team":"基辅","away_team":"亚布洛内","begin_time":"01:55","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.58"},{"name":"平","key":1,"odds":"3.88"},{"name":"负","key":0,"odds":"5.71"}]},{"bet_no":"18168_rxj_8_0","league":"欧罗巴","home_team":"拉尔纳","away_team":"勒沃","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"3.87"},{"name":"平","key":1,"odds":"3.58"},{"name":"负","key":0,"odds":"1.90"}]},{"bet_no":"18168_rxj_9_0","league":"欧罗巴","home_team":"凯尔特","away_team":"萨茨堡","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.40"},{"name":"平","key":1,"odds":"3.24"},{"name":"负","key":0,"odds":"2.93"}]},{"bet_no":"18168_rxj_10_0","league":"欧罗巴","home_team":"莱比锡","away_team":"罗森博","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.15"},{"name":"平","key":1,"odds":"7.93"},{"name":"负","key":0,"odds":"15.22"}]},{"bet_no":"18168_rxj_11_0","league":"欧罗巴","home_team":"哥本哈","away_team":"波尔多","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.11"},{"name":"平","key":1,"odds":"3.31"},{"name":"负","key":0,"odds":"3.46"}]},{"bet_no":"18168_rxj_12_0","league":"欧罗巴","home_team":"阿森纳","away_team":"卡拉巴","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"1.21"},{"name":"平","key":1,"odds":"6.21"},{"name":"负","key":0,"odds":"12.34"}]},{"bet_no":"18168_rxj_13_0","league":"欧罗巴","home_team":"迪德朗","away_team":"贝蒂斯","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"8.32"},{"name":"平","key":1,"odds":"5.22"},{"name":"负","key":0,"odds":"1.33"}]},{"bet_no":"18168_rxj_14_0","league":"欧罗巴","home_team":"奥林匹","away_team":"AC米兰","begin_time":"04:00","begin_date":"12-14","odds":[{"name":"胜","key":3,"odds":"2.70"},{"name":"平","key":1,"odds":"3.22"},{"name":"负","key":0,"odds":"2.60"}]}]
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
             * bet_no : 18168_rxj_1_0
             * league : 欧罗巴
             * home_team : 马赛
             * away_team : 阿波罗
             * begin_time : 01:55
             * begin_date : 12-14
             * odds : [{"name":"胜","key":3,"odds":"1.47"},{"name":"平","key":1,"odds":"4.69"},{"name":"负","key":0,"odds":"5.91"}]
             */

            private String bet_no;
            private String league;
            private String home_team;
            private String away_team;
            private String begin_time;
            private String begin_date;
            private List<OddsBean> odds;

            public String getBet_no() {
                return bet_no;
            }

            public void setBet_no(String bet_no) {
                this.bet_no = bet_no;
            }

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

            public List<OddsBean> getOdds() {
                return odds;
            }

            public void setOdds(List<OddsBean> odds) {
                this.odds = odds;
            }

            public static class OddsBean {
                /**
                 * name : 胜
                 * key : 3
                 * odds : 1.47
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
