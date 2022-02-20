//package com.hyy.weeklyquestionbackend.result;
//
//import lombok.Data;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @version v1.0
// * @ClassName ReturnResult
// * @Description TODO
// * @Author bong
// * @Date 2021/10/26 10:37
// **/
//@Data
////返回结果
//public class ReturnResult{
//    private Boolean success;    //是否成功
//    private Integer code;       //状态码
//    private String message;     //提示信息
//    private Map<String,Object> data=new HashMap<>();    //返回的所有数据
//    //根据传入的响应状态设置返回数据
//    public static ReturnResult getState(ResultCodeEnum re){
//        ReturnResult r=new ReturnResult();
//        r.setSuccess(re.getSuccess());
//        r.setCode(re.getCode());
//        r.setMessage(re.getMessage());
//        return r;
//    }
//    /**
//     * 功能描述：单值设置数据
//     *
//     * @param key 键
//     * @param value 值
//     * @return R 返回给前端的数据
//     */
//    public ReturnResult data(String key, Object value){
//        this.data.put(key, value);
//        return this;
//    }
//
//    /**
//     * 功能描述：多值设置数据
//     *
//     * @param map 集合
//     * @return R 返回给前端的数据
//     */
//    public ReturnResult data(Map<String, Object> map){
//        this.setData(map);
//        return this;
//    }
//
//}
