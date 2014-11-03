import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class GeneratePDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document myPDF = new Document();
			PdfWriter.getInstance(myPDF, new FileOutputStream("MyFirstPDFFile.pdf"));
			
			myPDF.open();
			
			PdfPTable myTable = new PdfPTable(4);
			myTable.setWidthPercentage(100);
			myTable.getDefaultCell().setFixedHeight(160);
			
			BaseFont myBaseFont = BaseFont.createFont("times.ttf", BaseFont.IDENTITY_H, true);
			Font black = new Font (myBaseFont, 60f, 0, BaseColor.BLACK);
			Font red = new Font (myBaseFont, 60f, 0, BaseColor.RED);
			
			String cardName = "";
			char color = ' ';
			
			for (int i = 2; i < 14; i++) {
				switch(i) {
				case 10: cardName = "10"; break;
				case 11: cardName = "J"; break;
				case 12: cardName = "Q"; break;
				case 13: cardName = "K"; break;
				case 14: cardName = "A"; break;
				default: cardName = " " + i; break;
				}
				for (int j = 1; j <= 4; j++) {
					switch (j) {
					case 1: color = '♣'; myTable.addCell(new Paragraph(cardName + " " + color, black)); break;
					case 2: color = '♦'; myTable.addCell(new Paragraph(cardName + " " + color, red)); break;
					case 3: color = '♠'; myTable.addCell(new Paragraph(cardName + " " + color, black)); break;
					case 4: color = '♥'; myTable.addCell(new Paragraph(cardName + " " + color, red)); break;
					}
				}
				
			}
			myPDF.add(myTable);	
			myPDF.close();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}

}
