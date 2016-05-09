package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import play.mvc.Controller;
import play.mvc.Result;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

public class PdfController extends Controller {
	public Result index(){
		return ok(views.html.uploadpdf.render());
	}
	
	public Result reader() throws IOException, DocumentException{
		
		
		
		//MultipartFormData<File> body = request().body().asMultipartFormData();
	    //play.mvc.Http.MultipartFormData.FilePart<File> picture = body.getFile("pdf");
	    
	   
	        /*String fileName = picture.getFilename();
	        String contentType = picture.getContentType();
	        java.io.File file = picture.getFile();*/
	        
	       
	        
	        PdfReader pdfReader = new PdfReader("itext.pdf");
	        
	       PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("output.pdf"));
	       PdfContentByte content = pdfStamper.getUnderContent(1);//1 for the first page
	        
	       BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ITALIC, BaseFont.CP1250, BaseFont.EMBEDDED);
	       
	        	                    content.beginText();
	      
	        	                    content.setFontAndSize(bf, 18);
	        
	        	                    content.showTextAligned(PdfContentByte.ALIGN_CENTER, "weclome Ritesh", 250,650,0);
	       
	        	                    content.endText();
	                    
	       
	        	                    pdfStamper.close();
	       
	        	                    pdfReader.close();
	        
	                               return ok("File uploaded");
	                               }
	
		public Result writer() throws DocumentException, IOException{
			
			File file = new File("itext.pdf");
            FileOutputStream pdfFileout = new FileOutputStream(file);
            Document doc = new Document();
            
            PdfWriter.getInstance(doc, pdfFileout);
 
            doc.addAuthor("QuicklyJava.com");
            doc.addTitle("This is title");
            doc.open();
           
 
           Paragraph para1 = new Paragraph();
           para1.add("This is Demo pdf File");
            
 
           Paragraph para2 = new Paragraph();
           para2.add("Hope its look fine!!!!!!!!");
 
            doc.add(para1);
            doc.add(para2);
            doc.add(new Chunk("This is Beutiful. "));
            doc.add(new Chunk("This is creative. "));
            doc.add(new Chunk("This is Awesome. "));
            
 
            doc.close();
            pdfFileout.close();
           
            return ok("Data successfully written in File");

			}
		}

