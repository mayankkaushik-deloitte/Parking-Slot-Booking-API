import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelData {
    public String getString(int sh, int row, int column) throws IOException {
        String excelPath = "data/credentials.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(sh);
        XSSFRow r = null;
        XSSFCell cell = null;
        String st = null;
        r = sheet.getRow(row);
        cell = r.getCell(column);
        st = cell.getStringCellValue();
        return st;
    }
    public void writeToken(Object ObjToken,int sh,int row, int column) throws IOException {
        String excelPath = "data/credentials.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(sh);
        XSSFRow r = null;
        XSSFCell cell = null;
        r= sheet.getRow(row);
        cell = r.createCell(column);
        cell.setCellType(CellType.STRING);
        String token =(String)ObjToken;
        cell.setCellValue(token);
        FileOutputStream fos = new FileOutputStream(excelPath);
        wb.write(fos);
        fos.close();
    }
}
