package fifthSemseter.modSim.src;

public class DeleteVocal {
    private String text;
    private String vocals = "aeiouAEIOU";

    public DeleteVocal(String s) {
        text = s;
    }

    public String delete1() {
        StringBuilder sentenceWithoutVocals = new StringBuilder(text);
        for (int i = 0; i < sentenceWithoutVocals.length(); i++) {

            for (int j = 0; j < vocals.length(); j++) {
                if (sentenceWithoutVocals.charAt(i) == vocals.charAt(j)) {
                    sentenceWithoutVocals.deleteCharAt(i);
                    i--;
                    break;
                }
            }

        }
        return sentenceWithoutVocals.toString();
    }

    public String delete2() {
        StringBuilder senetenceWithoutVocals = new StringBuilder();
        for (Character c : text.toCharArray()) {
            int i = 0;
            while(i < vocals.length()) {
                if(c == vocals.charAt(i)) {
                    break;
                }
                i++;
            }
            if (i == vocals.length())
                senetenceWithoutVocals.append(c);
        }

        return senetenceWithoutVocals.toString();
    }

    public String delete3() {
        return text.replaceAll("[aeiouAEIOU]", "");
    }

}
