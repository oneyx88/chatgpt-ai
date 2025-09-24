package com.yixi.chatbot.ai.test;

import cn.hutool.http.HttpStatus;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Test;

import java.io.IOException;


/**
 * @author Yixi Wan
 * @date 2025/9/23 21:00
 * @package com.yixi.chatbot.ai.test
 * <p>
 * Description 单元测试
 */
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20&end_time=2025-06-11T06%3A54%3A26.599-0500");
        httpGet.addHeader("cookie","zsxq_access_token=9C6D0D49-D74D-42BD-8D55-0373BB637DC9_009F04B081160BA3; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221997331696e1556-0848e6ed3f6bab-1f525631-1296000-1997331696f2103%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk5NzMzMTY5NmUxNTU2LTA4NDhlNmVkM2Y2YmFiLTFmNTI1NjMxLTEyOTYwMDAtMTk5NzMzMTY5NmYyMTAzIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221997331696e1556-0848e6ed3f6bab-1f525631-1296000-1997331696f2103%22%7D; abtest_env=product");
        httpGet.addHeader("Content-Type", "application/json;charset=utf-8");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getCode() == HttpStatus.HTTP_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getCode());
        }
    }

    @Test
    public void answer() throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/2854521211824141/comments");

        post.addHeader("cookie", "zsxq_access_token=9C6D0D49-D74D-42BD-8D55-0373BB637DC9_009F04B081160BA3; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221997331696e1556-0848e6ed3f6bab-1f525631-1296000-1997331696f2103%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk5NzMzMTY5NmUxNTU2LTA4NDhlNmVkM2Y2YmFiLTFmNTI1NjMxLTEyOTYwMDAtMTk5NzMzMTY5NmYyMTAzIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221997331696e1556-0848e6ed3f6bab-1f525631-1296000-1997331696f2103%22%7D; abtest_env=product\n");
        post.addHeader("Content-Type", "application/json;charset=utf-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"1\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "utf-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getCode() == HttpStatus.HTTP_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getCode());
        }


    }

}
