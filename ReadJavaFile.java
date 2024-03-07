package pkt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadJavaFile {

	public static void main(String[] args) throws IOException {
		
		if (args.length == 0) {
	            System.out.println("Usage: java -jar ReadJavafile.jar Motor.java");
	            System.exit(0);
	        }
		 
        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String className = "";
        while ((st = br.readLine()) != null) {
            if (st.contains("class")) {
                className = st.split(" ")[1];
                System.out.println("Class Name Read from Console: " + className);
            }
            if (st.contains("public") || st.contains("private") || st.contains("protected")) {
                String[] splitString = st.split("\\(");
                String functionName = splitString[0].split(" ")[2];
                System.out.println("Function Name: " + functionName);
                int singleLineCommentCount = 0;
                int multiLineCommentCount = 0;
                int javadocCommentCount = 0;
                while ((st = br.readLine()) != null) {
                    if (st.contains("//")) {
                        singleLineCommentCount++;
                    } else if (st.contains("/*")) {
                        multiLineCommentCount++;
                        while ((st = br.readLine()) != null) {
                            if (st.contains("*/")) {
                                break;
                            }
                        }
                    } else if (st.contains("/**")) {
                        javadocCommentCount++;
                        while ((st = br.readLine()) != null) {
                            if (st.contains("*/")) {
                                break;
                            }
                        }
                    } else if (st.contains("{")) {
                        break;
                    }
                }
                System.out.println("Number of Single-Line Comments for " + functionName + ": " + singleLineCommentCount);
                System.out.println("Number of Multi-Line Comments for " + functionName + ": " + multiLineCommentCount);
                System.out.println("Number of Javadoc Comments for " + functionName + ": " + javadocCommentCount);
                FileWriter fw1 = new FileWriter("javadoc.txt", true);
                fw1.write(javadocCommentCount + "\n");
                fw1.close();
                FileWriter fw2 = new FileWriter("teksatir.txt", true);
                fw2.write(singleLineCommentCount + "\n");
                fw2.close();
                FileWriter fw3 = new FileWriter("coksatir.txt", true);
                fw3.write(multiLineCommentCount + "\n");
                fw3.close();
            }
        }
    }

}
