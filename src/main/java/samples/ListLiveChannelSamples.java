package samples;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.LiveChannel;

import java.util.List;

/**
 * @author han xinjian
 * @date 2019-07-09 10:52
 **/
public class ListLiveChannelSamples {
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

            // 获取所有的 LiveChannel
            List<LiveChannel> channelList = oss.listLiveChannels(BUCKET_NAME);
            if (channelList != null && channelList.size() > 0) {
                // 打印 LiveChannel info
                channelList.forEach(liveChannel -> {
                    System.out.println("liveChannel name :" + liveChannel.getName());
                    System.out.println("liveChannel status :" + liveChannel.getStatus());
                    System.out.println("liveChannel playUrls :" + liveChannel.getPlayUrls());
                    System.out.println("======================================================================================");
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
