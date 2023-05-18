public class Lab12 {
    public static void main(String[] args) {
        Point point = new Point(0, 1);

        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            point.getX();
        }
        System.out.println("Time:" + (System.currentTimeMillis() - time));

        try {
            long timeRef = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                point.getClass().getMethod("getX").invoke(point);
            }
            System.out.println("TimeRef:" + (System.currentTimeMillis() - timeRef));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
