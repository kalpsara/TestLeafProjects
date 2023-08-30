package dailychallenge;

public class EqualStrings14 {

    public static void main(String[] args) {

        String[] word1={"ab","c"};
        String[] word2={"a","bc"};
        String s1=null,s2=null;

        for(String words:word1){
            s1=s1+words;
        }
        for(String words:word2){
            s2=s2+words;
        }
        if(s1.equals(s2)){
            System.out.println("true");
        }
        else{ System.out.println("false");}

    }
}
