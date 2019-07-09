package samples;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CreateLiveChannelRequest;
import com.aliyun.oss.model.CreateLiveChannelResult;
import com.aliyun.oss.model.LiveChannelInfo;
import com.aliyun.oss.model.LiveChannelStatus;

/**
 * @author han xinjian
 * @date 2019-07-09 10:31
 **/
public class PutLiveChannelSamples {
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
            // 创建 CreateLiveChannelRequest
            CreateLiveChannelRequest request = new CreateLiveChannelRequest(BUCKET_NAME, LIVE_CHANNEL_NAME);
            request.setLiveChannelStatus(LiveChannelStatus.Enabled);
            // 创建 LiveChannel
            CreateLiveChannelResult channelResult = oss.createLiveChannel(request);
            // 打印 RequestId
            System.out.println("RequestId :" + channelResult.getRequestId());
            // 获取 LiveChannel info
            LiveChannelInfo channelInfo = oss.getLiveChannelInfo(BUCKET_NAME, LIVE_CHANNEL_NAME);
            // 打印 channel status
            System.out.println("channel status :" + channelInfo.getStatus());
            // 打印  PublishUrls
            System.out.println("PublishUrls :" + channelResult.getPublishUrls());
            // 打印 PlayUrls
            System.out.println("PlayUrls :" + channelResult.getPlayUrls());


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
