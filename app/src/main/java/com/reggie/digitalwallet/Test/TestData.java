package com.reggie.digitalwallet.Test;

import com.reggie.digitalwallet.Model.Community;
import com.reggie.digitalwallet.Model.Goods;
import com.reggie.digitalwallet.Model.News;
import com.reggie.digitalwallet.Model.Specialist;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 24073 on 2018/1/24.
 */

public class TestData {

    public static List<News> getNewsData1(){
        List<News> newsData1 = new ArrayList<>();

        News news1 = new News("研究者观察：区块链金融风险及监管","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140749209559.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");
        News news2 = new News("日本Coincheck回应：新经币受损客户即将获赔","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140726104066.jpg","2018/3/24","知乎日报","https://token.im/posts/101?locale=zh-CN");
        News news3 = new News("新动向！韩国政府欲施行加密货币交易所许可证制度","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140332258031.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");
        News news4 = new News("英国亮出首个比特币交易自律组织","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140323579656.jpg","2018/3/24","币友圈","https://token.im/posts/101?locale=zh-CN");
        News news5 = new News("Kraken首席执行官：ENS将会是连接以太坊和互联网的桥梁","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802130817271850.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");

        newsData1.add(news5); newsData1.add(news2); newsData1.add(news1); newsData1.add(news4); newsData1.add(news3); newsData1.add(news5);

        return newsData1;
    }

    public static List<News> getNewsData2(){
        List<News> newsData1 = new ArrayList<>();

        News news1 = new News("突围BAT，区块链创业与投资的机会在哪里？","http://m.qpic.cn/psb?/V121cQJl2i1o9n/rjM29jIiTEi1MbTL450wwSzh8cwt7LQHGYyBNV*.exE!/b/dFYBAAAAAAAA","2018/3/24","公信宝","https://mp.weixin.qq.com/s/PQ-MySWmt_3aQrp55SLDzg");
        News news2 = new News("回家传送门！公信宝布洛克城更新下载点这里","http://m.qpic.cn/psb?/V121cQJl2i1o9n/B7m*KTEyuI9JPMDIG.gKWNHkRTov5EddYBUWfHS0sHk!/b/dPMAAAAAAAAA","2018/3/10","公信宝","https://mp.weixin.qq.com/s/Tz1tSg56vFTHfpT1wq1Ibw");
        News news3 = new News("星链，欢迎加入布洛克城大家族！","http://m.qpic.cn/psb?/V121cQJl2i1o9n/md69ho33JKsM8GawQIEX7gRBWxPEQxLGUw0dtOO.8ZQ!/b/dEIBAAAAAAAA","2018/3/2","公信宝","https://token.im/posts/101?locale=zh-CN");
        News news4 = new News("公信宝开发进展通报","http://www.mypcera.com/star/u1/2006/02/22/20060222134251391454.jpg","2018/2/24","公信宝","https://token.im/posts/101?locale=zh-CN");
        News news5 = new News("今天，SWTC正式加入布洛克城","http://m.qpic.cn/psb?/V121cQJl2i1o9n/8Q9TCeUg7yUA0WySDlvBRFzokvPvfp6vVD9JtPJU2h4!/b/dPMAAAAAAAAA","2018/2/11","公信宝","https://token.im/posts/101?locale=zh-CN");
        News news6 = new News("辟谣：公信宝官方没有任何ETH置换GXC的行为","http://m.qpic.cn/psb?/V121cQJl2i1o9n/MSLVDVQIzzeoe15hUL.rZ9pj0KqF9UuRE3FZDQ*XW2U!/b/dAgBAAAAAAAA","2018/1/24","公信宝","https://token.im/posts/101?locale=zh-CN");

        newsData1.add(news1); newsData1.add(news2); newsData1.add(news3); newsData1.add(news4); newsData1.add(news5); newsData1.add(news6);

        return newsData1;
    }

    public static List<News> getNewsData3(){
        List<News> newsData1 = new ArrayList<>();

        News news1 = new News("Kraken首席执行官：加密货币总市值今年有望达到1万亿美元","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140749209559.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");
        News news2 = new News("日本Coincheck回应：新经币受损客户即将获赔","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140726104066.jpg","2018/3/24","知乎日报","https://token.im/posts/101?locale=zh-CN");
        News news3 = new News("新动向！韩国政府欲施行加密货币交易所许可证制度","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140332258031.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");
        News news4 = new News("英国亮出首个比特币交易自律组织","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140323579656.jpg","2018/3/24","币友圈","https://token.im/posts/101?locale=zh-CN");
        News news5 = new News("研究者观察：区块链金融风险及监管","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802130817271850.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");

        newsData1.add(news1); newsData1.add(news2); newsData1.add(news3); newsData1.add(news4); newsData1.add(news5); newsData1.add(news1);

        return newsData1;
    }

    public static List<News> getNewsData4(){
        List<News> newsData1 = new ArrayList<>();

        News news1 = new News("研究者观察：区块链金融风险及监管","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140749209559.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");
        News news2 = new News("日本Coincheck回应：新经币受损客户即将获赔","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140726104066.jpg","2018/3/24","知乎日报","https://token.im/posts/101?locale=zh-CN");
        News news3 = new News("新动向！韩国政府欲施行加密货币交易所许可证制度","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140332258031.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");
        News news4 = new News("英国亮出首个比特币交易自律组织","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802140323579656.jpg","2018/3/24","币友圈","https://token.im/posts/101?locale=zh-CN");
        News news5 = new News("Kraken首席执行官：ENS将会是连接以太坊和互联网的桥梁","http://7fvhfe.com1.z0.glb.clouddn.com/wp-content/uploads/2018/02/201802130817271850.jpg","2018/3/24","巴比特","https://token.im/posts/101?locale=zh-CN");

        newsData1.add(news5); newsData1.add(news2); newsData1.add(news1); newsData1.add(news4); newsData1.add(news3); newsData1.add(news5);

        return newsData1;
    }

    public static List<Community> getCommunityData1(){

        List<Community> communityList = new ArrayList<>();

        Community community1 = new Community("http://tvax3.sinaimg.cn/crop.143.0.399.399.50/b89d7a1dly8fj7i6hvedrj20go0b3mxv.jpg","币友小张","今天12:01","春天到了，春困了呢","http://wx1.sinaimg.cn/bmiddle/5470383fly1fpnw3ylbzlj21di0qown2.jpg",1,1,1);
        Community community2 = new Community("http://tvax3.sinaimg.cn/crop.614.0.762.762.50/788fa6f3ly8foeo8jzm47j21kw11xh6c.jpg","老詹","今天13:10","炒币赚了钱，来现场看NBA的啦啦操！哈哈哈哈","http://wx2.sinaimg.cn/mw690/788fa6f3gy1fofrwr5luvj20u00jyqs3.jpg",1,1,1);
        Community community3 = new Community("http://tvax1.sinaimg.cn/crop.0.0.400.400.50/44a43c7aly8fjw6mp1p0sj20b40b4jxa.jpg","张大炮","今天13:12","我可能真的老了，接受不了新事物了……比如……新出现的区块链这个词，在哪儿加儿化音？？？？？","http://ww3.sinaimg.cn/bmiddle/006QR6H0gy1fpnwg60592j30zk0qoq7g.jpg",1,1,1);
        Community community4 = new Community("http://tva4.sinaimg.cn/crop.66.37.288.288.50/41740844jw8ev5mjh5eiij20bo0egdgi.jpg","我很秀","今天12:13","区块链未来的应用并未明朗，而币圈价格的涨落似乎比区块链更精彩。如果说之前坊间还充斥着“比特币能让流浪汉住进豪宅，告诉他们的妻子能一夜暴富”的传说，现在则是各种小心谨慎和踌躇掂量。","http://wx4.sinaimg.cn/bmiddle/66031b59ly1fpnvcbkwfhj212m0qbah9.jpg",1,1,1);
        Community community5 = new Community("http://tvax1.sinaimg.cn/crop.0.9.493.493.180/006QR6H0ly8finoq4mvzxj30dp0e8wep.jpg","小爱","今天13:40","区块链冥币真的是解决了我疑惑好久的冥币通胀问题，建议大力推广","http://wx1.sinaimg.cn/mw690/7fa92467gy1flyoqx4nwnj20fa0a5jsx.jpg",1,1,1);

        communityList.add(community1);
        communityList.add(community2);
        communityList.add(community3);
        communityList.add(community4);
        communityList.add(community5);

        return communityList;
    }


    public static List<Specialist> getSpecialistData(){
        List<Specialist> specialists = new ArrayList<>();
        Specialist specialist1 = new Specialist("带你一起初探区块链的前世今生","老吴", "和大家一起讨论一下区块链的内容","http://120.79.17.123/static/img/crowdfunding2.jpg");
        Specialist specialist2 = new Specialist("区块链到底有哪些商业应用","小刘", "将为大家介绍什么是区块链，区块链的特点和前景","http://120.79.17.123/static/img/crowdfunding2.jpg");
        Specialist specialist3 = new Specialist("加密数字货币入门及前景","大薛", "近期，数字货币的快速上涨引发了大家的兴趣","http://120.79.17.123/static/img/crowdfunding2.jpg");
        Specialist specialist4 = new Specialist("焦虑的互联网人未来改怎么办","lukehuo", "作为区块链技术的典型代表，比特币是","http://120.79.17.123/static/img/crowdfunding2.jpg");
        Specialist specialist5 = new Specialist("带你一起初探区块链的前世今生","老吴", "和大家一起讨论一下区块链的内容","http://120.79.17.123/static/img/crowdfunding2.jpg");
        Specialist specialist6 = new Specialist("区块链到底有哪些商业应用","小刘", "将为大家介绍什么是区块链，区块链的特点和前景","http://120.79.17.123/static/img/crowdfunding2.jpg");


        specialists.add(specialist1);
        specialists.add(specialist2);
        specialists.add(specialist3);
        specialists.add(specialist4);
        specialists.add(specialist5);
        specialists.add(specialist6);

        return specialists;
    }

    public static List<Goods> getGoodsData(){
        List<Goods> goodsList = new ArrayList<>();
        Goods goods1 = new Goods("大疆 晓 掌上无人机", R.mipmap.goods1, (float)0.82);
        Goods goods2 = new Goods("奥林巴斯TG-5", R.mipmap.goods2, (float)0.73);
        Goods goods3 = new Goods("理光GR2", R.mipmap.goods3, (float)0.66);
        Goods goods4 = new Goods("insta360 nano", R.mipmap.goods4, (float)0.81);
        Goods goods5 = new Goods("佳能600D入门单反", R.mipmap.goods5, (float)0.87);
        Goods goods6 = new Goods("佳能700D单反", R.mipmap.goods6, (float)0.72);
        Goods goods7 = new Goods("佳能EOS M6 微型相机", R.mipmap.goods7, (float)0.12);
        Goods goods8 = new Goods("佳能EOS 5D Mark IV", R.mipmap.goods8, (float)0.90);

        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        goodsList.add(goods4);
        goodsList.add(goods5);
        goodsList.add(goods6);
        goodsList.add(goods7);
        goodsList.add(goods8);

        return goodsList;

    }

}
