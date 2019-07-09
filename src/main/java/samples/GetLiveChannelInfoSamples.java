package samples;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.LiveChannelInfo;

/**
 * @author han xinjian
 * @date 2019-07-09 12:44
 **/
public class GetLiveChannelInfoSamples {
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
            // 获取LiveChannel配置信息
            LiveChannelInfo liveChannelInfo = oss.getLiveChannelInfo(BUCKET_NAME, LIVE_CHANNEL_NAME);
            // 打印当前的状态信息
            System.out.println("live channel status :" + liveChannelInfo.getStatus());
            // print type
            System.out.println("type :" + liveChannelInfo.getTarget().getType());
            // print PLAY_LIST_NAME
            System.out.println("play list name :" + liveChannelInfo.getTarget().getPlaylistName());
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

