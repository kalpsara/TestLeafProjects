package dailychallenge;

public class NumOfWordsInSentences12 {
//java challenge 12/20
	public static void main(String[] args) {
		//String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
		String[] sentences = {"please wait vv ff","continue to fight","continue to win"}; 
		int maxNumOfWords = 0;
		for (int i = 0; i < sentences.length; i++) {
			int numWords = sentences[i].split(" ").length;
			maxNumOfWords = maxNumOfWords < numWords ? numWords : maxNumOfWords; 
		}
		System.out.println("maximum number of words in a sentence is "+maxNumOfWords);

	}

}
