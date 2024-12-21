import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ScrappingTableDataTests extends Setup{

    @Test
    public void sharePriceDataScrapping() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        List<WebElement> table = driver.findElements(By.className("table"));
        WebElement element = table.get(1);
        List <WebElement> allRows = element.findElements(By.tagName("tr"));
//        System.out.println("Test Value:"+allRows);

        BufferedWriter writer = new BufferedWriter(new FileWriter("output_data.txt"));

        for(WebElement row:allRows){
            List <WebElement> cells = row.findElements(By.tagName("td"));
            for (int i = 0; i < cells.size(); i++) {
                String cellText = cells.get(i).getText();

                System.out.print(cellText + "\t");

                writer.write(cellText);

                if (i < cells.size() - 1) {
                    writer.write("\t");
                }
            }
            writer.newLine();
        }
        writer.close();
    }
}
