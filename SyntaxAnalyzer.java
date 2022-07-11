import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SyntaxAnalyzer {
    public static void main(String[] args) {
            Parser parser = new Parser("a := 2;\n"
            		+ "b := 5;\n"
            		+ "if (a < b) then\n"
            		+ "    repeat\n"
            		+ "        a = a + 1\n"
            		+ "    until (b < a)\n"
            		+ "end");
            parser.start();
    }
}
