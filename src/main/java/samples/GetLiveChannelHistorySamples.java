package samples;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.LiveRecord;

import java.util.List;

/**
 * @author han xinjian
 * @date 2019-07-09 12:44
 **/
public class GetLiveChannelHistorySamples {
    /**
     * ENDPOINT 端点
     */
    private static final String ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";
    /**
     * ACCESS_KEY_ID
     */
    private static final String ACCESS_KEY_ID = "<asseccKeyId>";

    /**
     * ACCESS_KEY_SECRET
     */
    private static final String ACCESS_KEY_SECRET = "<assessKeySecret>";

    /**
     * BUCKET_NAME
     */
    private static final String BUCKET_NAME = "<bucketName>";

    /**
     * LIVE_CHANNEL_NAME
     */
    private static final String LIVE_CHANNEL_NAME = "live-channel-name";


    public static void main(String[] args) {

        OSS oss = null;

        try {
            // 创建 oss
            oss = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            // 获取LiveChannel推流记录
            List<LiveRecord> liveChannelHistory = oss.getLiveChannelHistory(BUCKET_NAME, LIVE_CHANNEL_NAME);
            if (liveChannelHistory != null && liveChannelHistory.size() > 0) {
                //打印 history
                liveChannelHistory.forEach(history -> {
                    System.out.println("startDate :" + history.getStartDate());
                    System.out.println("endDate :" + history.getEndDate());
                    System.out.println("remote address :" + history.getRemoteAddress());
                    System.out.println("=============================================");
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oss != null) {
                // 关闭 oss
                oss.shutdown();
            }
        }
    }
}

