package thread.modelTest;

/**
 * @author ouyjs
 * @date 2019/7/4 10:49
 */
public class ProducerTest extends Thread{

    private static final int SIZE = 10;
    private Goods goods;

    public ProducerTest(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
        int count = 1;
        while (true){
            try {
                Thread.sleep((long)(Math.random()*500));
                goods.addGoods(count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
