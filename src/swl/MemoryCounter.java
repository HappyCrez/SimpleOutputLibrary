package swl;

import swl.Text;

public class MemoryCounter {
    public static int countBytesInText(Text text) {
        String memory = text.getText();
        return memory.length();
    }

    public static int countBytesInImage(char[][] art) {
        int memory = 0;
        for (char[] row : art)
            for (char c : row)
                memory++;
        return memory; 
    }
}
