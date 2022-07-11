import java.util.Arrays;
import java.util.StringTokenizer;

public class Scanner{
    private String[] symbols = {"+", "-", "*", "/", "=", "<", "(", ")", ";", ":", "{", "}", "\n", "\r"};
    private StringTokenizer tokenizer;

    private int line = 1;
    private boolean comment = false;

    public Scanner(String input) {
        tokenizer = new StringTokenizer(input, Arrays.toString(symbols), true);
    }

    public String nextToken(){
        String token = "";
        if (tokenizer.hasMoreTokens()) {
            while (token.isBlank()) { 
                if (token.contentEquals("\n"))
                    line++;
                if (tokenizer.hasMoreTokens())
                    token = tokenizer.nextToken();
                else {
                    token = "";
                    break;
                }
            }
            if (token.contentEquals("{")) {
                comment = true;
                while (!token.contentEquals("}")) {
                    if (token.contentEquals("\n"))
                        line++;
                    if (tokenizer.hasMoreTokens())
                        token = tokenizer.nextToken();
                    else {
                        token = "";
                        return token;
                    }
                }
                comment = false;
                return nextToken(); 
            }
            if (!token.isBlank()) {
                return token;
            }
        }
        return token;
    }

    public int getLine() {
        return line;
    }

    public boolean isComment() {
        return comment;
    }

}