package whatap.weaving.v1;

import java.util.List;

/**
 * @since agent v2.0_57-20210831
 */
public class LogSink {

    /**
     * 와탭 로그 설정의 사용자로그설정(logsink_custom_enabled) 활성화 되어 있는 경우에 사용자가 지정한 로그 내용을 쌓는다.
     *
     * @param category 로그 카테고리
     * @param content  로그 내용
     * @since agent v2.0_57-20210831
     */
    public static void trace(String category, String content) {
    }

    /**
     * 와탭 로그 설정의 사용자로그설정(logsink_custom_enabled) 활성화 되어 있는 경우에 사용자가 지정한 로그 내용을 쌓는다.
     *
     * @param category 로그 카테고리
     * @param tags     로그 tag
     * @param content  로그 내용
     * @since agent v2.0_57-20210831
     */
    public static void trace(String category, List<String[]> tags, String content) {
    }
}
