package com.example.p7homework.model.bean;

import java.util.List;

public class MpBean {

    /**
     * data : {"data":[{"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101919248/035ACCB1C445047757A7A303EED0DD6B/100","commentCount":8,"expires_time":1614514319503,"favoriteCount":2,"feedCount":0,"followCount":3,"followerCount":4,"hasFollow":false,"historyCount":386,"id":2409,"likeCount":29,"name":"安慕希","qqOpenId":"035ACCB1C445047757A7A303EED0DD6B","score":0,"topCommentCount":0,"userId":1606738320},"authorId":1606738320,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608178875949.jpeg","createTime":1608178881235,"duration":0,"height":1280,"id":1578920475,"itemId":1608178881235,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":3,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/-625769899.mp4","width":720,"feeds_text":"Cat","activityText":"舌尖上的美食"},{"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101919248/035ACCB1C445047757A7A303EED0DD6B/100","commentCount":8,"expires_time":1614514319503,"favoriteCount":2,"feedCount":0,"followCount":3,"followerCount":4,"hasFollow":false,"historyCount":386,"id":2409,"likeCount":29,"name":"安慕希","qqOpenId":"035ACCB1C445047757A7A303EED0DD6B","score":0,"topCommentCount":0,"userId":1606738320},"authorId":1606738320,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608178674836.jpeg","createTime":1608178677058,"duration":0,"feeds_text":"Cat","height":1280,"id":1578920474,"itemId":1608178677058,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":3,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/907348676.mp4","width":720},{"author":{"avatar":"http://thirdqq.qlogo.cn/qqopen/ooKMd9J3c6ibjcnsXM8I2zaCPMEM7qOW8MJGUTdC1okljUqcxk2eibGiacEpKbexqicF/100?v=f1d8","commentCount":2,"expires_time":1613709251321,"favoriteCount":2,"feedCount":0,"followCount":2,"followerCount":1,"hasFollow":false,"historyCount":66,"id":2378,"likeCount":12,"name":"Lisa","qqOpenId":"AAEBF2A31FF903C0E320E571082B182E","score":0,"topCommentCount":0,"userId":1605933254},"authorId":1605933254,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608178385169.jpeg","createTime":1608178388795,"duration":0,"feeds_text":"# Alisa","height":1280,"id":1578920473,"itemId":1608178388795,"itemType":2,"ugc":{"commentCount":1,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":2,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1463366480.mp4","width":720},{"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100","commentCount":417,"description":"小朋友,你是否有很多问号","expires_time":1596726031266,"favoriteCount":17,"feedCount":10,"followCount":109,"followerCount":40,"hasFollow":false,"historyCount":2792,"id":1755,"likeCount":1,"name":"、蓅哖╰伊人为谁笑","qqOpenId":"FE41683AD4ECF91B7736CA9DB8104A5C","score":1000,"topCommentCount":10,"userId":1578919786},"authorId":0,"cover":"http://ppjoke.oss-cn-qingdao.aliyuncs.com/image/202012/ccfd62dab5fe70f0d4be90eee8bcfabf.jpg","createTime":1608137355772,"duration":0,"height":1280,"id":1578920472,"itemId":1608137355772,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":0,"shareCount":0},"url":"http://ppjoke.oss-cn-qingdao.aliyuncs.com/audio/202012/94935cc02c4599b70f1e178ab4626205.mp4","width":720},{"activityText":"舌尖上的美食","author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/D17F991F3A4E0D0136409A3136A1B7ED/100","commentCount":13,"expires_time":1613631982096,"favoriteCount":7,"feedCount":0,"followCount":5,"followerCount":1,"hasFollow":false,"historyCount":188,"id":2375,"likeCount":3,"name":"华狼","qqOpenId":"D17F991F3A4E0D0136409A3136A1B7ED","score":0,"topCommentCount":0,"userId":1605855982},"authorId":1605855982,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608116504650.jpeg","createTime":1608116502989,"duration":0,"feeds_text":"测试一下","height":1280,"id":1578920467,"itemId":1608116502989,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":-1,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608116494477.mp4","width":720},{"activityText":"2020新年快乐","author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/D17F991F3A4E0D0136409A3136A1B7ED/100","commentCount":13,"expires_time":1613631982096,"favoriteCount":7,"feedCount":0,"followCount":5,"followerCount":1,"hasFollow":false,"historyCount":188,"id":2375,"likeCount":3,"name":"华狼","qqOpenId":"D17F991F3A4E0D0136409A3136A1B7ED","score":0,"topCommentCount":0,"userId":1605855982},"authorId":1605855982,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608116119200.jpeg","createTime":1608116117629,"duration":0,"feeds_text":"测试","height":1280,"id":1578920466,"itemId":1608116117629,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":2,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608116094997.mp4","width":720},{"activityText":"2020新年快乐","author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/5816385F0091F18100196275B371D893/100","commentCount":1,"expires_time":1611195502552,"favoriteCount":0,"feedCount":0,"followCount":0,"followerCount":1,"hasFollow":false,"historyCount":29,"id":2298,"likeCount":1,"name":"№柠檬味的菇凉＇","qqOpenId":"5816385F0091F18100196275B371D893","score":0,"topCommentCount":0,"userId":1603419503},"authorId":1603419503,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608098049773.jpeg","createTime":1608098053868,"duration":0,"feeds_text":"我车抛锚了","height":1280,"id":1578920463,"itemId":1608098053868,"itemType":2,"ugc":{"commentCount":8,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":2,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608098044531.mp4","width":720},{"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/5816385F0091F18100196275B371D893/100","commentCount":1,"expires_time":1611195502552,"favoriteCount":0,"feedCount":0,"followCount":0,"followerCount":1,"hasFollow":false,"historyCount":29,"id":2298,"likeCount":1,"name":"№柠檬味的菇凉＇","qqOpenId":"5816385F0091F18100196275B371D893","score":0,"topCommentCount":0,"userId":1603419503},"authorId":1603419503,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608097210852.jpeg","createTime":1608097215489,"duration":0,"feeds_text":"试试看","height":1280,"id":1578920462,"itemId":1608097215489,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":1,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608097197953.mp4","width":720},{"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/1111180113/9B23190299DFFDB88D220A240C301A06/100","commentCount":5,"expires_time":1614502620798,"favoriteCount":6,"feedCount":0,"followCount":6,"followerCount":3,"hasFollow":false,"historyCount":181,"id":2404,"likeCount":14,"name":"Individual","qqOpenId":"9B23190299DFFDB88D220A240C301A06","score":0,"topCommentCount":0,"userId":1606726621},"authorId":1606726621,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608029388912.jpeg","createTime":1608029391469,"duration":0,"feeds_text":"加个话题","height":1280,"id":1578920459,"itemId":1608029391469,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":1,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608029358611.mp4","width":720},{"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101919248/035ACCB1C445047757A7A303EED0DD6B/100","commentCount":8,"expires_time":1614514319503,"favoriteCount":2,"feedCount":0,"followCount":3,"followerCount":4,"hasFollow":false,"historyCount":386,"id":2409,"likeCount":29,"name":"安慕希","qqOpenId":"035ACCB1C445047757A7A303EED0DD6B","score":0,"topCommentCount":0,"userId":1606738320},"authorId":1606738320,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608027392714.jpeg","createTime":1608027394891,"duration":0,"height":1280,"id":1578920458,"itemId":1608027394891,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":2,"shareCount":1},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/-1672519200.mp4","width":720},{"activityText":"2020新年快乐","author":{"avatar":"http://qzapp.qlogo.cn/qzapp/1111254970/2D43A468102A5BE99BE0059878CFB06A/100","commentCount":1,"expires_time":1615708857633,"favoriteCount":1,"feedCount":0,"followCount":4,"followerCount":1,"hasFollow":false,"historyCount":57,"id":2457,"likeCount":2,"name":"耶","qqOpenId":"2D43A468102A5BE99BE0059878CFB06A","score":0,"topCommentCount":0,"userId":1607932857},"authorId":1607932857,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1607997506497.jpeg","createTime":1607997507496,"duration":0,"feeds_text":"哈哈","height":1280,"id":1578920457,"itemId":1607997507496,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":1,"shareCount":1},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1607997499254.mp4","width":720},{"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/F6CAD851053E16BE3F539339F14A55FE/100","commentCount":2,"expires_time":1615202808576,"favoriteCount":2,"feedCount":0,"followCount":3,"followerCount":2,"hasFollow":false,"historyCount":72,"id":2437,"likeCount":5,"name":"4y28","qqOpenId":"F6CAD851053E16BE3F539339F14A55FE","score":0,"topCommentCount":0,"userId":1607426808},"authorId":1607426808,"cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1607941096659.jpeg","createTime":1607941097578,"duration":0,"feeds_text":"哦","height":1280,"id":1578920451,"itemId":1607941097578,"itemType":2,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":0,"shareCount":0},"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1607941088490.mp4","width":720}]}
     * message : 成功
     * status : 200
     */

    private DataBeanX data;
    private String message;
    private int status;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBeanX {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * author : {"avatar":"http://qzapp.qlogo.cn/qzapp/101919248/035ACCB1C445047757A7A303EED0DD6B/100","commentCount":8,"expires_time":1614514319503,"favoriteCount":2,"feedCount":0,"followCount":3,"followerCount":4,"hasFollow":false,"historyCount":386,"id":2409,"likeCount":29,"name":"安慕希","qqOpenId":"035ACCB1C445047757A7A303EED0DD6B","score":0,"topCommentCount":0,"userId":1606738320}
             * authorId : 1606738320
             * cover : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1608178875949.jpeg
             * createTime : 1608178881235
             * duration : 0.0
             * height : 1280
             * id : 1578920475
             * itemId : 1608178881235
             * itemType : 2
             * ugc : {"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":3,"shareCount":0}
             * url : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/-625769899.mp4
             * width : 720
             * feeds_text : Cat
             * activityText : 舌尖上的美食
             */

            private AuthorBean author;
            private int authorId;
            private String cover;
            private long createTime;
            private double duration;
            private int height;
            private int id;
            private long itemId;
            private int itemType;
            private UgcBean ugc;
            private String url;
            private int width;
            private String feeds_text;
            private String activityText;

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public int getAuthorId() {
                return authorId;
            }

            public void setAuthorId(int authorId) {
                this.authorId = authorId;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getItemId() {
                return itemId;
            }

            public void setItemId(long itemId) {
                this.itemId = itemId;
            }

            public int getItemType() {
                return itemType;
            }

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public UgcBean getUgc() {
                return ugc;
            }

            public void setUgc(UgcBean ugc) {
                this.ugc = ugc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getFeeds_text() {
                return feeds_text;
            }

            public void setFeeds_text(String feeds_text) {
                this.feeds_text = feeds_text;
            }

            public String getActivityText() {
                return activityText;
            }

            public void setActivityText(String activityText) {
                this.activityText = activityText;
            }

            public static class AuthorBean {
                /**
                 * avatar : http://qzapp.qlogo.cn/qzapp/101919248/035ACCB1C445047757A7A303EED0DD6B/100
                 * commentCount : 8
                 * expires_time : 1614514319503
                 * favoriteCount : 2
                 * feedCount : 0
                 * followCount : 3
                 * followerCount : 4
                 * hasFollow : false
                 * historyCount : 386
                 * id : 2409
                 * likeCount : 29
                 * name : 安慕希
                 * qqOpenId : 035ACCB1C445047757A7A303EED0DD6B
                 * score : 0
                 * topCommentCount : 0
                 * userId : 1606738320
                 */

                private String avatar;
                private int commentCount;
                private long expires_time;
                private int favoriteCount;
                private int feedCount;
                private int followCount;
                private int followerCount;
                private boolean hasFollow;
                private int historyCount;
                private int id;
                private int likeCount;
                private String name;
                private String qqOpenId;
                private int score;
                private int topCommentCount;
                private int userId;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public long getExpires_time() {
                    return expires_time;
                }

                public void setExpires_time(long expires_time) {
                    this.expires_time = expires_time;
                }

                public int getFavoriteCount() {
                    return favoriteCount;
                }

                public void setFavoriteCount(int favoriteCount) {
                    this.favoriteCount = favoriteCount;
                }

                public int getFeedCount() {
                    return feedCount;
                }

                public void setFeedCount(int feedCount) {
                    this.feedCount = feedCount;
                }

                public int getFollowCount() {
                    return followCount;
                }

                public void setFollowCount(int followCount) {
                    this.followCount = followCount;
                }

                public int getFollowerCount() {
                    return followerCount;
                }

                public void setFollowerCount(int followerCount) {
                    this.followerCount = followerCount;
                }

                public boolean isHasFollow() {
                    return hasFollow;
                }

                public void setHasFollow(boolean hasFollow) {
                    this.hasFollow = hasFollow;
                }

                public int getHistoryCount() {
                    return historyCount;
                }

                public void setHistoryCount(int historyCount) {
                    this.historyCount = historyCount;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getQqOpenId() {
                    return qqOpenId;
                }

                public void setQqOpenId(String qqOpenId) {
                    this.qqOpenId = qqOpenId;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public int getTopCommentCount() {
                    return topCommentCount;
                }

                public void setTopCommentCount(int topCommentCount) {
                    this.topCommentCount = topCommentCount;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }
            }

            public static class UgcBean {
                /**
                 * commentCount : 0
                 * hasDissed : false
                 * hasFavorite : false
                 * hasLiked : false
                 * hasdiss : false
                 * likeCount : 3
                 * shareCount : 0
                 */

                private int commentCount;
                private boolean hasDissed;
                private boolean hasFavorite;
                private boolean hasLiked;
                private boolean hasdiss;
                private int likeCount;
                private int shareCount;

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public boolean isHasDissed() {
                    return hasDissed;
                }

                public void setHasDissed(boolean hasDissed) {
                    this.hasDissed = hasDissed;
                }

                public boolean isHasFavorite() {
                    return hasFavorite;
                }

                public void setHasFavorite(boolean hasFavorite) {
                    this.hasFavorite = hasFavorite;
                }

                public boolean isHasLiked() {
                    return hasLiked;
                }

                public void setHasLiked(boolean hasLiked) {
                    this.hasLiked = hasLiked;
                }

                public boolean isHasdiss() {
                    return hasdiss;
                }

                public void setHasdiss(boolean hasdiss) {
                    this.hasdiss = hasdiss;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }
            }
        }
    }
}
