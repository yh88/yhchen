import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileOut {
    public static void main(String[] args) {
        System.out.println();
        FileOutputStream fos = null;
        File file;
        String content = "abcd...";
        try {
            file = new File("t.txt");
            //如果文件不存在，则新建
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            byte[] bt = content.getBytes();
            fos.write(bt);
            fos.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("关闭出现问题...");
            }
        }


    }

    /**
     * 生成随机字符串，生成指定列，每列字符串长度不一致，随机取
     * @param i ,表示有几列，以分号分隔
     * @return
     */
    public static String getString(int i){

        String str = "qwertyuioplkjhgfdsazxcvbnm1234567890";
        StringBuffer sb = new StringBuffer();
        //长度随机
        for(int j=0;j<str.length();j++){

        }
        return null;
    }
}
