import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by wb-chenchaobin on 2015/12/8.
 */
public class UploadAction extends ActionSupport {
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    public String excute(){
        try {
            destPath="D:\\";
            File destFile = new File(destPath,myFileFileName);
            FileUtils.copyFile(myFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;

    }

    public File getMyFile() {
        System.out.println("getMyFile.....");
        return myFile;
    }

    public void setMyFile(File myFile) {
        System.out.println("setMyFile....");
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        System.out.println("getMyFileContentType.....");
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        System.out.println("setMyFileContentType......");
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        System.out.println("getMyFileFileName....");
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        System.out.println("setMyFileFileName....");
        this.myFileFileName = myFileFileName;
    }
}
