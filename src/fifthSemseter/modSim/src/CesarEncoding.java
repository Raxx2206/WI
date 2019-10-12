package fifthSemseter.modSim.src;

public class CesarEncoding {

    public String cipher(String s, int shift) {
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                if (c + shift > 90) {
                    cipher.append((char) (((c + shift) % 90) + 64));
                } else {
                    cipher.append((char) (c + shift));
                }
            } else if (c >= 97 && c <= 122) {
                if (c + shift > 122) {
                    cipher.append((char) (((c + shift) % 122) + 96));
                } else {
                    cipher.append((char) (c + shift));
                }
            } else {
                cipher.append(c);
            }
        }

        return cipher.toString();
    }

}
