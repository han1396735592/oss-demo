package samples;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.LiveChannelStatus;
import com.aliyun.oss.model.SetLiveChannelRequest;

/**
 * @author han xinjian
 * @date 2019-07-09 10:31
 **/
public class PutLiveChannelStatusSamples {
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
            // 创建 SetLiveChannelRequest
            SetLiveChannelRequest request = new SetLiveChannelRequest(BUCKET_NAME, LIVE_CHANNEL_NAME, LiveChannelStatus.Enabled);
            // 设置LiveChannel状态
            oss.setLiveChannelStatus(request);

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
