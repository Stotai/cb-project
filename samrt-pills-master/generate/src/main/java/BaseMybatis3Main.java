import org.mybatis.generator.api.ShellRunner;

import java.io.File;

/**
 * 
 * @author linw
 *
 */
public class BaseMybatis3Main {
	
	private static String XML_NAME_QMCS = "start";

	public static void generate(String xmlName) {  
        String config = ClassLoader.getSystemResource("xml/MyBatisCodeGenerator-" + xmlName + ".xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
			ShellRunner.main(arg);
    }
	
	public static void main(String[] args) {
		File file=new File("C:\\com");
		deleteDir(file);
		file=new File("C:\\mybatis");
		deleteDir(file);
		generate(XML_NAME_QMCS);
	}



	private static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i=0; i<children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}
}  