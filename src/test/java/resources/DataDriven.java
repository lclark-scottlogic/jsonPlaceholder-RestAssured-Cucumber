package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

  public ArrayList<String> getData(String feature, String caseName) throws IOException {
    ArrayList<String> array = new ArrayList<String>();

    FileInputStream fis = new FileInputStream(
        "C:\\Users\\lclark\\OneDrive - Scott Logic Ltd\\Documents\\Bench 2023\\JsonPlaceholderCucumberDataDrive.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
    int sheets = workbook.getNumberOfSheets();
    for (int i = 0; i < sheets; i++) {
      if (workbook.getSheetName(i).equalsIgnoreCase(feature)) {
        XSSFSheet sheet = workbook.getSheetAt(i);
//Identify test cases column by scanning first row
        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();
        Iterator<Cell> ce = firstRow.cellIterator();
        int k = 0;
        int column = 0;
        while (ce.hasNext()) {
          Cell value = ce.next();
          if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
            //Desired Cell who's index we get
            column = k;
          }
          k++;
        }
        //once column is identified then scan entire testcase column to identify correct row
        while (rows.hasNext()) {
          Row r = rows.next();

          if (r.getCell(column).getStringCellValue().equalsIgnoreCase(caseName)) {

            //pull all data of that row and feed into test
            Iterator<Cell> cv = r.cellIterator();
//            Get rid of row heading from row data
            cv.next();
            while (cv.hasNext()) {
              Cell c = cv.next();
              if(c.getCellType() == CellType.STRING && Objects.equals(c.getStringCellValue(),
                  "null")){
               array.add(null);
              }
              else if (c.getCellType() == CellType.STRING) {
                array.add( c.getStringCellValue());
              }
              else if(c.getCellType() == CellType.NUMERIC){
                array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
              }
            }
            }
          }
        }
      }
    return array;
    }
  }






