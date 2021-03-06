
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.model.meta.*;
import org.openxava.util.*;

/**
 * Program Generator created by TL2Java
 * @version Wed Nov 15 10:30:49 CET 2017
 */
public class InitMembersPG {
    Properties properties = new Properties();



private MetaModel metaModel=null;
public void setMetaModel(MetaModel metaModel) {
	this.metaModel = metaModel;
}

private boolean ejb=false;
public void setEjb(boolean ejb) {
	this.ejb = ejb;
}

public static void generate(XPathContext context, ProgramWriter out, MetaModel metaModel, boolean ejb) throws XavaException {
	InitMembersPG pg = new InitMembersPG();
	pg.setMetaModel(metaModel);
	pg.setEjb(ejb);
	pg.generate(context, out);
}



    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    out.print(" \n\n\tprivate void initMembers() {");
    
    		Iterator itPropertiesToInit = metaModel.getMetaPropertiesPersistents().iterator();
    		while (itPropertiesToInit.hasNext()) {
    			MetaProperty p = (MetaProperty) itPropertiesToInit.next();
    			String propertyName = Strings.firstUpper(p.getName());
    			if (!p.getType().isPrimitive()) {				
    		
    out.print(" \n\t\tset");
    out.print(propertyName);
    out.print("(null);");
    
    			}
    			else if (p.isNumber()) {
    		
    out.print(" \n\t\tset");
    out.print(propertyName);
    out.print("(0);");
    	
    			}
    			else if (p.getType().getName().equals("boolean")) {
    		
    out.print(" \n\t\tset");
    out.print(propertyName);
    out.print("(false);");
    
    			}
    		}
    		
    
    		if (ejb) {
    			for (Iterator it = metaModel.getMetaReferencesWithMapping().iterator(); it.hasNext(); ) {
    				MetaReference ref = (MetaReference) it.next();
    				String refName = Strings.firstUpper(ref.getName());
    		
    out.print(" \n\t\tset");
    out.print(refName);
    out.print("Key(null);");
    
    			}
    		}
    		
    out.print(" \t\n\t}");
    
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * A program generator is typically (but not always) invoked
     * with a command line with arguments for the XML input file
     * and output file.
     */    
    public static void main(String[] args) {
        try {
            ProgramWriter out = args.length>=2
                ?new ProgramWriter(new FileOutputStream(args[1]))
                :new ProgramWriter(System.out);
            InitMembersPG pg = new InitMembersPG();
            for (int j=1; j<=args.length; ++j) {
                pg.properties.put("arg"+j, args[j-1]);
            }
            pg.generate(new XPathContext(args[0]), out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This array provides program generator development history
     */
    public String[][] history = {
        { "Wed Nov 15 10:30:49 CET 2017", // date this file was generated
             "..\\OpenXava\\generator\\initMembers.xml", // input file
             "..\\OpenXava\\generator\\InitMembersPG.java" }, // output file
        {"Mon Apr 09 16:45:30 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Mon Apr 09 16:39:37 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Mon Apr 09 16:37:21 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 14:49:11 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 14:30:24 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 11:13:01 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 10:57:04 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Wed Apr 26 11:15:41 EDT 2000", "..\\input\\TL2Java.xml", "TL2Java1.java", }, 
        {"April 2000", "hand coded", "TL2Java1.java", }, 

    };
}