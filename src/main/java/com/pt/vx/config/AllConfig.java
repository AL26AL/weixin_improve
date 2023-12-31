package com.pt.vx.config;


import com.pt.vx.domain.BirthDay;
import com.pt.vx.domain.FunctionConfig;
import com.pt.vx.domain.User;

import java.util.ArrayList;
import java.util.List;

public class AllConfig {
    //每天七点准时提醒
    public static final String cron = "0 0 7 * * ?"; //分别代表：秒、分、时、日、月、星期
    public static final String VxAppId = "wx6fca59f7ce56c8c4";
    public static final String VxAppSecret = "7d079948f3ef328ba29b206ef56ada8c";
    public static final String WeatherKey = "df08abb05375692d9a6222b731a16439";
    public static final String WeatherKey_HeFeng = "421ac7c2bf5649e9a04a9bf7532e9340";

    //下列所有填写的  true 为开启， false 为不开启 ，#XXXXXX是颜色16进制HEX码（不知道颜色16进制HEX码可以百度）
    //系统开关
    public static final boolean OPEN_MESSAGE_SPLIT = true; //开启消息分裂（大于100字的消息会被分裂成多个,如tianGou超过了一百个字的话：{{tianGou.DATA}}{{tianGou1.DATA}}））
    public static final boolean OPEN_WEATHER_NOW = false; //切换天气类型为实时（false为天气预报，true为实时天气）
    public static final boolean OPEN_HF_WEATHER = true; //切换天气源为和风天气（目前只支持天气预报）
    public static final boolean OPEN_MASTER_MODEL = false; //不开启唯一模式。开启后，后面的用户只会收到第一个用户的内容。
    public static final boolean OPEN_RANDOM_COLOR = true; //开启随机消息颜色
    public static final String[] random_colors = {"#FFCCCC", "#33A1C9", "#DC143C","#FF0000","#6B8E23","#236B8E","#FF7F00"}; //参与随机的颜色,颜色为颜色HEX码（不知道可以百度）


    //基本类型消息
    public static final FunctionConfig open_name = new FunctionConfig(true,"#FFCCCC");//开启称呼
    public static final FunctionConfig open_birthDay = new FunctionConfig(true,"#FFCCCC"); //开启日期计算
    public static final FunctionConfig open_weather = new FunctionConfig(true,"#33A1C9"); //开启天气预报
    public static final FunctionConfig open_other_info= new FunctionConfig(true,"#DC143C"); //开启额外信息
    public static final String info_birthday = "生日快乐！！！"; //第一个日期倒计时到0天的时候展示的额外信息
    public static final String info_birthday2 = "周年快乐！！！"; //第三个日期倒计时到0天的时候展示的额外信息
    public static final String info_weather_rain = "出门记得带伞哦~"; //天气预报有雨的时候展示的额外信息
    public static final String info_weather_temperature_0 = "温度过低，加厚加厚！！！"; //温度≤0的时候展示的额外信息
    public static final String info_weather_temperature_10 = "温度很低，多穿点衣服哦！"; //温度≤10的时候展示的额外信息
    public static final String info_weather_temperature_20 = "温度有点低，注意别着凉啦~"; //温度≤20的时候展示的额外信息
    public static final String info_weather_prefix_day = "白天"; //白天天气的前缀，比如温度≤0的时候就会展示为： 白天温度过低，加厚加厚！！！
    public static final String info_weather_prefix_night = "晚上"; //晚上天气的前缀
    public static final String info_weather_prefix_now = "现在"; //现在天气的前缀


    //额外类型消息
    public static final FunctionConfig open_history_today = new FunctionConfig(false,"#FF7F00"); //不开启历史上的今天
    public static final FunctionConfig open_qinghua = new FunctionConfig(true,"#FF7F00"); //是否开启情话一句
    public static final FunctionConfig open_dongman = new FunctionConfig(false,"#FF7F00"); //不开启动漫台词
    public static final FunctionConfig open_tiangou = new FunctionConfig(true,"#FF7F00"); //是否开启舔狗日记
    public static final FunctionConfig open_world_read = new FunctionConfig(true,"#FF7F00"); //是否开启世界新闻
    public static final FunctionConfig open_random_read = new FunctionConfig(true,"#FF7F00"); //是否开启随机短句
    public static final FunctionConfig open_wozairenjian = new FunctionConfig(true,"#FF7F00"); //是否开启散文集我在人间凑日子
    public static final FunctionConfig open_poetry = new FunctionConfig(false,"#FF7F00"); //不开启随机诗句
    public static final FunctionConfig open_english = new FunctionConfig(false,"#FF7F00"); //不开启每日英语
    public static final FunctionConfig open_miyu = new FunctionConfig(false,"#FF7F00"); //不开启谜语
    public static final FunctionConfig open_horoscope= new FunctionConfig(false,"#FF7F00"); //不开启星座解析
    public static final FunctionConfig random_module = new FunctionConfig(true,"#FF7F00"); //随机一个开启了的额外类型消息(只会推送随机的)

    private static void init(){
        userList.add(getUser(
                "o7sBj6fe7VR6sDNL4n9KmNOFdULw",
                "hPybEFHFR1xknG7Z98kNX7WD-IQWJBZQA8ws38POlws",
                "我亲爱的晨曦宝贝",
                "北京市海淀区",
                "北京",
                new BirthDay(2003,3,22,true,true)
        ));

        userList.add(getUser(
                "o7sBj6YWpUe8x7DXF5dWIqhKiyqE",
                "hPybEFHFR1xknG7Z98kNX7WD-IQWJBZQA8ws38POlws",
                "可爱的我",
                "北京市海淀区",
                "北京",
                new BirthDay(2004,4,9,false,true)
        ));



    }

    public static final List<User> userList = new ArrayList<>();
    static {
        init();
    }


    private static User getUser(String vx, String templateId, String username, String address, String city, BirthDay... birthDays){
        User user=new User();
        user.setVx(vx);
        user.setUserName(username);
        user.setBirthDays(birthDays);
        user.setAddress(address);
        user.setCity(city);
        user.setTemplateId(templateId);
        return user;
    }
    private static User getUser(String vx, String templateId, String username, BirthDay... birthDays){
        return getUser(vx,templateId,username,null,null,birthDays);
    }
    private static User getUser(String vx, String templateId, BirthDay... birthDays){
        return getUser(vx,templateId,null,null,null,birthDays);
    }
    private static User getUser(String vx,BirthDay... birthDays){
        return getUser(vx,null,null,null,null,birthDays);
    }

}
