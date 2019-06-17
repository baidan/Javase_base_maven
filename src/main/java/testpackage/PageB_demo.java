package testpackage;

public class PageB_demo {
    public static void main(String[] main) {
        PageA_demo A1 = new PageA_demo();
        A1.show();
    }

    public static class PageA_demo {
        public void show() {
            System.out.println("thread.A=======");
        }
    }
}