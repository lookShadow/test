/**
 * @author ouyjs
 * @date 2019/7/8 11:22
 */
public class two {
    public static void main(String[] args) {
        /* System.out.println(isTwo(4));*/
        /*  System.out.println(Objects.equals(3,null));*/
    /*    List<String> list1 = new ArrayList();
        list1.add("8860");
        list1.add("8859");
        list1.add("8872");
        list1.add("8871");
        list1.add("8869");

        List<String> list2 = new ArrayList();
        list2.add("8869");
        list2.add("8871");
        list2.add("1");
        System.out.println("list1"+list1);
        list1.removeAll(list2);
        System.out.println("list1"+list1);*/
        //System.out.println("list1.remove(list2)"+list1.remove(list2));
       /* List<Long> billIdList = new ArrayList<>();
        billIdList.add(8860L);
        billIdList.add(8859L);
        List list = new ArrayList();
        list.addAll(billIdList);
        System.out.println(billIdList);
        System.out.println(Joiner.on(",").join(billIdList));

        List<Long> billIdListList = billIdList.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(billIdListList);*/
       /* List<String> list = null;
        list.contains("s");
        System.out.println(list.contains("s"));*/
        System.out.println(sqrt2());
    }

    private static boolean isTwo(int number) {
        return (number & number - 1) == 0;
    }

    static double EPSINON = 0.0000000001;

    private static  double sqrt2() {
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;
        while (high - low > EPSINON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }
        return mid;
    }
}
