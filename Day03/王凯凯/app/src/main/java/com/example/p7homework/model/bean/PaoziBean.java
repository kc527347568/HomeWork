package com.example.p7homework.model.bean;

import java.util.List;

public class PaoziBean {

    /**
     * data : [{"age":29,"city":"杭州","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20200402/b071d2d80a96ea0cfeb391f4fb58ca30.jpg","id":232041,"isConcat":0,"level":2,"nickName":"若寒rock","province":"浙江","sex":"","socialTitle":"粉丝人人爱","userID":232041},{"age":0,"city":"武汉","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20181124/615f9a606619e9f58877d0fe30f34690.jpg","id":102725,"isConcat":0,"level":1,"nickName":"南吕","province":"湖北","sex":"1","socialTitle":"土豪会撒币","userID":102725},{"age":0,"city":"北京","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20200501/5c59f34728106bb1d703c25546c104b1.jpg","id":182301,"isConcat":0,"level":3,"nickName":"八荒原创汉服-玥","province":"北京","sex":"1","socialTitle":"粉丝人人爱","userID":182301},{"age":0,"city":"重庆","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20190116/72eb63b7c9d1b9b44c0367f5a0f29aea.jpg","id":106697,"isConcat":0,"level":4,"nickName":"为止汉服社-维蔚","province":"重庆市","sex":"1","socialTitle":"土豪会撒币","userID":106697},{"age":0,"city":"成都","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20181130/6bbdc43ea13ca0e17b02d6f074c7f1e6.jpg","id":103709,"isConcat":0,"level":5,"nickName":"终是庄周梦了蝶","province":"四川","sex":"0","socialTitle":"土豪会撒币","userID":103709},{"age":0,"city":"西安","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20191219/eadab196db21a4bb8e998330cd0bb561.jpg","id":107479,"isConcat":0,"level":4,"nickName":"染柒","province":"陕西","sex":"1","socialTitle":"级高带我飞","userID":107479},{"age":0,"city":"重庆","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20190102/15d9c634a9c6a2b9e4ed29af43305e7b.jpg","id":106685,"isConcat":0,"level":4,"nickName":"小郎君。","province":"重庆","sex":"0","socialTitle":"级高带我飞","userID":106685},{"age":0,"city":"赣州","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20200417/921aa64685f0ea182779e61f3c116f1b.jpg","id":102233,"isConcat":0,"level":5,"nickName":"虔章司伯言","province":"江西","sex":"0","socialTitle":"粉丝人人爱","userID":102233},{"age":0,"city":"江门","fileBeanList":[],"headUrl":"https://tpcdn.whfpsoft.com:443/File/headPhoto/20181121/4d113d63d4a6959e5f363ce927740ba1.jpg","id":102437,"isConcat":0,"level":4,"nickName":"陆陆陆染","province":"广东","sex":"1","socialTitle":"级高带我飞","userID":102437}]
     * status : {"message":"请求成功！","serverTime":"2020-08-04 16:39:04","statusCode":100}
     */

    private StatusBean status;
    private List<DataBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StatusBean {
        /**
         * message : 请求成功！
         * serverTime : 2020-08-04 16:39:04
         * statusCode : 100
         */

        private String message;
        private String serverTime;
        private int statusCode;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getServerTime() {
            return serverTime;
        }

        public void setServerTime(String serverTime) {
            this.serverTime = serverTime;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
    }

    public static class DataBean {
        /**
         * age : 29
         * city : 杭州
         * fileBeanList : []
         * headUrl : https://tpcdn.whfpsoft.com:443/File/headPhoto/20200402/b071d2d80a96ea0cfeb391f4fb58ca30.jpg
         * id : 232041
         * isConcat : 0
         * level : 2
         * nickName : 若寒rock
         * province : 浙江
         * sex :
         * socialTitle : 粉丝人人爱
         * userID : 232041
         */

        private int age;
        private String city;
        private String headUrl;
        private int id;
        private int isConcat;
        private int level;
        private String nickName;
        private String province;
        private String sex;
        private String socialTitle;
        private int userID;
        private List<?> fileBeanList;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsConcat() {
            return isConcat;
        }

        public void setIsConcat(int isConcat) {
            this.isConcat = isConcat;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSocialTitle() {
            return socialTitle;
        }

        public void setSocialTitle(String socialTitle) {
            this.socialTitle = socialTitle;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public List<?> getFileBeanList() {
            return fileBeanList;
        }

        public void setFileBeanList(List<?> fileBeanList) {
            this.fileBeanList = fileBeanList;
        }
    }
}
