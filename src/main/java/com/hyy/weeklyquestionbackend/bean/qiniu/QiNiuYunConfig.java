package com.hyy.weeklyquestionbackend.bean.qiniu;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.util.Base64;
import com.qiniu.util.UrlSafeBase64;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import lombok.Data;
import org.springframework.stereotype.Component;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import java.io.IOException;

/**
 * 七牛云配置
 * @Author: pjj
 * @Classname: QiNiuYunConfig
 * @Date: 2021/05/15
 * @Description:七牛云配置文件
 */

@Data
@Component
public class QiNiuYunConfig {
    private String accessKey = "zMNuFPkCKgZ4oeACpXbI_YWMj5ZaAHCwA84x9mAG";  //密钥
    private String secretKey = "-OuLFGpSjMSVssXHvap5JYZukBURADz2DUy27GvS";  //密钥
    private String bucket = "yyforreal";                                  //空间名
    private String path = "cdn.yywebsite.cn";                   //域名

    /**
     *	获取七牛云的Token
     *	@Author: pjj
     *	@Param: null
     *	@Date: 2021/05/15
     *	@return String 七牛云的Token
     **/
    public String getUpToken() {
        return Auth.create(accessKey, secretKey).uploadToken(bucket, null, 3600, new StringMap().put("insertOnly", 1));
    }

    /**
     *	base64方式上传图片到七牛云
     *	@Author: pjj
     *	@Param: null
     *	@Date: 2021/05/15
     *
     *	@return String 上传图片七牛云返回的图片url
     **/
    public String put64image(byte[] base64, String fileName) throws Exception {
        String file64 = Base64.encodeToString(base64, 0);
        Integer l = base64.length;
        // 请求url
        String url = "http://upload-z2.qiniu.com/putb64/" + l + "/key/" + UrlSafeBase64.encodeToString(fileName);
        // 请求体
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        // 如果以存在该图片那先将原图片从七牛云中删除，再上传一次达到覆盖目的
        if(!response.isSuccessful()){
            delete(fileName);
            client = new OkHttpClient();
            response = client.newCall(request).execute();
        }
        // 上传成功返回图片地址
        return response.isSuccessful()?("http://" + path + "/" + fileName):"Up Img Failed";
    }

    /**
     *	删除七牛云上的图片
     *	@Author: pjj
     *	@Param: fileName 图片名
     *	@Date: 2021/05/15
     *	@return null
     **/
    public void delete(String fileName) throws IOException {
        // 实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(Auth.create(accessKey, secretKey));
        try {
            // 调用delete方法移动文件
            bucketManager.delete(bucket, fileName);
        } catch (QiniuException e) {
            // 捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
        }
    }
}
