package utils;

/**
 * @author ouyjs
 * @date 2019/7/4 14:04
 */
//当Test的父类TestUtils 只有private的构造函数,test不能继承TestUtils
public class Test extends TestUtils {

    public Test(){
        super(1);
    }
}
