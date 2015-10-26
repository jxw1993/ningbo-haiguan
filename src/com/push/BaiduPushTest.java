package com.push;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushBroadcastMessageRequest;
import com.baidu.yun.channel.model.PushBroadcastMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;

public class BaiduPushTest {

	public static int pushBroadcastMessage(String Content)  
    {           
        BaiduChannelClient channelClient = initPushClient();  
        try{  
            // 4. 创建请求类对象  
            PushBroadcastMessageRequest request = new PushBroadcastMessageRequest();  
            request.setDeviceType(3);   
            // device_type => 1: web 2: pc 3:android  
            // 4:ios 5:wp  
            request.setMessage(Content);  
            // 5. 调用pushMessage接口  
            PushBroadcastMessageResponse response = channelClient  
                    .pushBroadcastMessage(request);
            // 6. 认证推送成功  
            System.out.println("push amount : " + response.getSuccessAmount());  
            return response.getSuccessAmount();
        }   
        catch (ChannelClientException e)   
        {  
            // 处理客户端错误异常  
            e.printStackTrace(); 
            return 1;
        }   
        catch (ChannelServerException e)   
        {  
            // 处理服务端错误异常  
            System.out.println(String.format(  
                    "request_id: %d, error_code: %d, error_message: %s",  
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));  
            return 2;
        }  

    }
    private static BaiduChannelClient initPushClient() 
    {  
            //这两个key自己申请
           String apiKey = "dGXG3T9Zd29gZIRRjUT4PGbM";
            String secretKey = "INUDxeoqhUiLVwXFDh8Gs7jj4YkF8hqZ";
        // 1. 设置developer平台的ApiKey/SecretKey  
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);   
        // 2. 创建BaiduChannelClient对象实例  
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);   
        // 3. 若要了解交互细节，请注册YunLogHandler类  
        channelClient.setChannelLogHandler(new YunLogHandler()  
        {              
            @Override  
            public void onHandle(YunLogEvent event)   
            {  
                System.out.println(event.getMessage());  
            }  
        });  
        return channelClient;  
    }
    public static void main(String[] args) {
    	BaiduPushTest.pushBroadcastMessage("你好");
	}
}
