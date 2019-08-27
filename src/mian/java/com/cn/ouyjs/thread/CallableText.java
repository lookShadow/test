package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author ouyjs
 * @date 2019/6/13 9:42
 */
public class CallableText {
    public static void main(String[] args) {
        List<Callable<User>> u = new ArrayList<>();
        u.add(()-> text());
        u.add(new Callable<User>() {
            @Override
            public User call() throws Exception {
                return text();
            }
        });

        u.forEach(user->{
            try {
                System.out.println(user.call().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static User text(){
        return new User("2","2");
    }
}
