package dailychallenge;

public class FormSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        //s.split("\\s");
        String stringArray[] = s.split("\\s");
        String newStringArray[] = new String[stringArray.length];
        String result = "";
        int j = 0;

        for (String s1 : stringArray) {

// Traverse the String from start to end
            if (s1 != null) {
                for (int i = 0; i < s1.length(); i++) {

                    // Check if the specified character is not digit ̰
                    // then add this character into result variable
                    if (!Character.isDigit(s1.charAt(i))) {
                        result = result + s1.charAt(i);
                    } else {
                        j = Math.abs(i - j);

                        //newStringArray[Math.abs(i-j)]=result;
                    }

                }
                newStringArray[j] = result;
            }


            j++;


        }
        System.out.println(result);


    }
}
