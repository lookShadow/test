package thread.redis;

/**
 * @author ouyjs
 * @date 2019/7/29 9:30
 */
public class ShareParam {
    Integer count;
    ShareParam(int count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
