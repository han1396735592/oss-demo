package samples;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetVodPlaylistRequest;
import com.aliyun.oss.model.OSSObject;

/**
 * @author han xinjian
 * @date 2019-07-09 10:31
 **/
public class GetVodPlaylistSamples {
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

    /**
     * PLAY_LIST_NAME
     */
    private static final String PLAY_LIST_NAME = "my-play-list-name.m3u8";

    /**
     * START_TIME 2019-07-09 10:03:49
     */
    private static final long START_TIME = 1562637829L;

    /**
     * END_TIME 2019-07-09 15:03:49
     */
    private static final long END_TIME = 1562655829L;


    public static void main(String[] args) {
        OSS oss = null;

        try {
            // 创建 oss
            oss = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

            // 创建 GetVodPlaylistRequest
            GetVodPlaylistRequest request = new GetVodPlaylistRequest(BUCKET_NAME, LIVE_CHANNEL_NAME, START_TIME, END_TIME);
            // 获取 OSSObject
            OSSObject vodPlaylist = oss.getVodPlaylist(request);
            // print key
            System.out.println("key :" + vodPlaylist.getKey());
            // print ContentType
            System.out.println("ContentType :" + vodPlaylist.getObjectMetadata().getContentType());

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
