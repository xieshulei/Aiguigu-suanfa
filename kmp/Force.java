package kmp;

public class Force {
    public static void main(String[] args) {

        String a = "aiai houxiaoyun";
        String b = "houxiaoyun";
        violenceMatch(b,a);

    }

    public static void violenceMatch(String a,String b){
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();

        int s1len = s1.length;
        int s2len = s2.length;

        int i = 0;
        int j = 0;

        while (i < s1len && j < s2len){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = 0;
                j = j - (i - 1);
            }
        }
        if (i == s1len){
            System.out.println("找到了");
            return;
        } else {
            System.out.println("完犊子");
            return;
        }
    }
}
