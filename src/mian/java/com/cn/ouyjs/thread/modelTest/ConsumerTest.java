package thread.modelTest;

/**
 * @author ouyjs
 * @date 2019/7/4 10:49
 */
public class ConsumerTest extends Thread{
    private static final int SIZE = 20;
    private Goods goods;

    public ConsumerTest(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
       while (true) {
           try {
               Thread.sleep((long)(Math.random()*500));
               goods.removeGoods();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
