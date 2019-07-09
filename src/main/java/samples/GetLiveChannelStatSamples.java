package samples;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.LiveChannelGenericRequest;
import com.aliyun.oss.model.LiveChannelStat;

/**
 * @author han xinjian
 * @date 2019-07-09 12:00
 **/
public class GetLiveChannelStatSamples {
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
            LiveChannelGenericRequest request = new LiveChannelGenericRequest(BUCKET_NAME, LIVE_CHANNEL_NAME);
            // 获取LiveChannel状态信息
            LiveChannelStat channelStat = oss.getLiveChannelStat(request);
            // print  RemoteAddress
            System.out.println("RemoteAddress :" + channelStat.getRemoteAddress());
            //print PushflowStatus
            System.out.println("PushflowStatus :" + channelStat.getPushflowStatus());
            // print ConnectedDate
            System.out.println("ConnectedDate :" + channelStat.getConnectedDate());
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
