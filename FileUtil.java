import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @Title: 文件操作
 * @Description: 
 * @Company: bqjr
 * @author nengquan.huang
 * @version：2016年11月8日 下午2:36:26
 */
public class FileUtil {
	/**
	 * 根据文件全路径读取文件内容，返回每一行内容
	 * @param filePath
	 * @return List<String>
	 */
	public List<String> readExternalFileLines(String filePath){
		List<String> list = new ArrayList<String>();
		File inputfile = new File(filePath);
		if (inputfile.exists()) {
			BufferedReader input = null;
			String text="";					
				try {
					
					input = new BufferedReader(new InputStreamReader(new FileInputStream(inputfile))); 
					while ((text = input.readLine()) != null){
						list.add(text.trim());
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				} finally{
					try {
						input.close();
					} catch (IOException e) {
					}					
				}
		} else {
			System.err.println(inputfile+" does not exist");
		}
		return list;
	}
	/**
	 * 读取资源文件内容并返回
	 * @param pathFile
	 * @return
	 */
	public List<String> readLine(String pathFile){
		List<String> list = new ArrayList<String>();
		String path = FileUtil.class.getClassLoader().getResource(pathFile).getFile();
		File inputfile = new File(path);
		if (inputfile.exists()) {
			BufferedReader input = null;
			String text="";					
				try {
					
					input = new BufferedReader(new InputStreamReader(new FileInputStream(inputfile))); 
					while ((text = input.readLine()) != null){
						list.add(text.trim());
						//System.out.println(text.trim());
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				} finally{
					try {
						input.close();
					} catch (IOException e) {
					}					
				}
		} else {
			System.err.println(inputfile+" does not exist");
		}
		return list;
	}
	
	public List<String> readLineResourcesFile(String fileName){
		String file = FileUtil.class.getClassLoader().getResource("").getPath();
		List<String> list = readLine(file+fileName);
		return list;
	}
	
	public void writeToFile(String path, String fileName, String content) {
		if(path == null){
			return;
		}
		//判断路径是否存在
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		
		String filePath = path + File.separator + fileName;
		File file = new File(filePath);
		try{
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.delete();
				file.createNewFile();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		//写文件
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
