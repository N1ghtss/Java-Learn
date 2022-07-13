public class Test1 {
    public static void main(String[] args) {
        Test1 t=new Test1();
        t.chengfa();
    }
    public void chengfa() {
        for (int i = 9; i >= 1; i--) {
            for (int j = 9; j >= 1; j--) {
                if (j <= i) {
                    System.out.print(j+"x"+i+"="+i*j+"\t");
                }else {
                    System.out.print("\t\t");
                }
            }
            System.out.println();
        }
    }
}
