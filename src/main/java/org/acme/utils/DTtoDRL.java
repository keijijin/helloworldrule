package org.acme.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class DTtoDRL {
    public static void main(String args[]) {
        String strDrl = compile("src/main/resources/org/acme/dtables/MessageRule.xlsx");
        System.out.println(strDrl);
        try {
            PrintWriter writer = new PrintWriter(new File("src/main/resources/org/acme/rules/MessageRule.drl"));
            writer.println(strDrl);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String compile(String filename) {
        String drl = "";
        File dtf = new File( filename );
        InputStream is;
        try {
            is = new FileInputStream( dtf );
            SpreadsheetCompiler ssComp = new SpreadsheetCompiler();
            drl = ssComp.compile( is, InputType.XLS );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return drl;
    }
}
