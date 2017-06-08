package Utility;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class JyperionListener implements ITestListener {
	private Document document = null;

	PdfPTable successTable = null, failTable = null;

	private HashMap<Integer, Throwable> throwableMap = null;

	private int nbExceptions = 0;

	public JyperionListener() {
		log("JyperionListener()");

		this.document = new Document();
		this.throwableMap = new HashMap<Integer, Throwable>();
	}

	public void onTestSuccess(ITestResult result) {
		log("onTestSuccess("+result+")");

		if (successTable == null) {
			this.successTable = new PdfPTable(new float[]{.3f, .3f, .1f, .3f});

			Paragraph p = new Paragraph("PASSED TESTS", new
					Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)) );

			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(6);
			cell.setBackgroundColor(BaseColor.GREEN);
			this.successTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
		}

		PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass().toString()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getName().toString()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.successTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;

			@SuppressWarnings("unused")
			Paragraph p = new Paragraph("PASSED TESTS", new
					Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)) );

		} else {
			this.successTable.addCell(new PdfPCell(new Paragraph("")));
		}
	}

	public void onTestFailure(ITestResult result) {
		log("onTestFailure("+result+")");

					
//				String file=System.getProperty("user.dir")+"\\"+"screenshot"+(new Random().nextInt()+".png");
//				try{
//					screenshot.takeSnapShot(screenshot.getDriver(), file);
//				} catch (Exception e){
//					e.printStackTrace();
//				}
				
								
		if (this.failTable == null) {
			this.failTable = new PdfPTable(new float[]{.3f, .3f, .1f, .3f});
			this.failTable.setTotalWidth(20f);

			Paragraph p = new Paragraph("FAILED TESTS", new
					Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)) );

			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(6);
			cell.setBackgroundColor(BaseColor.RED);
			this.failTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
		}

		PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass().toString()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getName().toString()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.failTable.addCell(cell);
		//String exception = result.getThrowable() == null ? "" : result.getThrowable().toString();
		//cell = new PdfPCell(new Paragraph(exception));
		//this.failTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			
			
//			Chunk imdb= new Chunk ("[SCREEN SHOT]", new
//					Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)) );
//					imdb.setAction(new PdfAction("file:///"+file));
//			
//					
			Paragraph excep = new Paragraph(
					new Chunk(throwable.toString(), 
							new Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)) ).
					setLocalGoto("" + throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.failTable.addCell(cell);
		} else {
			this.failTable.addCell(new PdfPCell(new Paragraph("")));
		}
	}

	public void onTestSkipped(ITestResult result) {
		log("onTestSkipped("+result+")");
	}

	public void onStart(ITestContext context) {
		log("onStart("+context+")");
		try {
			Random rn = new Random();
			PdfWriter.getInstance(this.document, new FileOutputStream(context.getName()+rn.nextInt(1)+".pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.document.open();

		Paragraph p = new Paragraph(context.getName() + " TESTNG RESULTS",
				FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD));

		try {
			this.document.add(p);
			this.document.add(new Paragraph(new Date().toString()));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		log("onFinish("+context+")");

		try {
			if (this.failTable != null) {
				log("Added fail table");
				this.failTable.setSpacingBefore(15f);
				this.document.add(this.failTable);
				this.failTable.setSpacingAfter(15f);
			}

			if (this.successTable != null) {
				log("Added success table");
				this.successTable.setSpacingBefore(15f);
				this.document.add(this.successTable);
				this.successTable.setSpacingBefore(15f);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		Paragraph p = new Paragraph("EXCEPTIONS SUMMARY",
				FontFactory.getFont(FontFactory.HELVETICA, 16));
		try {
			this.document.add(p);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

		Set<Integer> keys = this.throwableMap.keySet();

		assert keys.size() == this.nbExceptions;

		for(Integer key : keys) {
			Throwable throwable = this.throwableMap.get(key);

			Chunk chunk = new Chunk(throwable.toString(),
					FontFactory.getFont(FontFactory.HELVETICA, 12));
			chunk.setLocalDestination("" + key);
			Paragraph throwTitlePara = new Paragraph(chunk);
			try {
				this.document.add(throwTitlePara);
			} catch (DocumentException e3) {
				e3.printStackTrace();
			}

			StackTraceElement[] elems = throwable.getStackTrace();
			@SuppressWarnings("unused")
			String exception = "";
			for(StackTraceElement ste : elems) {
				Paragraph throwParagraph = new Paragraph(ste.toString());
				try {
					this.document.add(throwParagraph);
				} catch (DocumentException e2) {
					e2.printStackTrace();
				}
			}
		}

		this.document.close();
	}

	public static void log(Object o) {
		System.out.println("[JyperionListener] " + o);
	}
	@Override
	public void onTestStart(ITestResult result) {

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
}