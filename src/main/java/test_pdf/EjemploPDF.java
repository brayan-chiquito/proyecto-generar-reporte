package test_pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EjemploPDF {

    public void prueba() {

        String palabra_de_prueba = "hola, que tal?";
        String codigo_prueba = "FO-OP-AD-005";
        String version = "3";
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.getDefault());
        String fecha_formateada = fecha.format(timeFormatter);
        // crear objeto
        Document document = new Document();

        try {
            // crear pdf en blanco
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("d:/pdf-test/Ejemplo_pdf_java.pdf"));

            // abrir documento
            document.open();
            
            // declarar grafico y tamaño del awp grafic
            PdfContentByte cb = writer.getDirectContent();      //configurara ambiente grafico del pdf
            Graphics g = cb.createGraphicsShapes(PageSize.A4.getWidth(), PageSize.A4.getHeight()); // tamaño carta

            //--------------------- pagina 1 --------------------------
            //rectangulo grande superior
            g.setColor(Color.black);
            g.drawRect(30, 30, 530, 90);
            //rectangulos superior pequeño izquierdo
            g.setColor(Color.black);
            g.drawRect(410, 30, 150, 31);
            //rectangulos 2 superior pequeño izquierdo
            g.setColor(Color.black);
            g.drawRect(410, 61, 150, 32);
            //rectangulos 3 superior pequeño izquierdo
            g.setColor(Color.black);
            g.drawRect(410, 93, 150, 27);
            //linea cerra logo
            g.setColor(Color.black);
            g.drawLine(150,30,150,120);
            //logo tcc
            ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/tcc_logo.png"));
            g.drawImage(img1.getImage(), 50, 37, 80, 80, null);
            //codigo
            Font fuente_cuadro_superior = new Font("Tahoma", Font.ITALIC, 8);
            g.setFont(fuente_cuadro_superior);
            g.setColor(Color.black);
            g.drawString("Codigo: " + codigo_prueba, 412, 49);
            g.setColor(Color.black);
            g.drawString("Versíon: " + version, 412, 80);
            g.setColor(Color.black);
            g.drawString("Fecha de actualizacion: " + fecha_formateada, 412, 109);


            //obalo
            //g.setColor(new Color(154, 171, 237));
            //g.fillOval(290, 90, 280, 100);
            //fuente de la letra
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);
            //texto 1
            //g.setColor(Color.RED);
            //g.drawString("Ejemplo crear PDF desde Java", 40, 150);
            //texto2
            //g.setColor(Color.WHITE);
            //g.drawString("PDF desde Java", 290, 150);
            

            //fuente 2 definida
            Font font2 = new Font("Tahoma", Font.PLAIN, 15);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString(palabra_de_prueba, 60, 460);
            g.drawString("en Java", 210, 480);
            
            document.newPage();
            //--------------------- pagina 2 --------------------------
            
            g.setColor(Color.GREEN);
            g.drawLine(1, 1, 200, 200);

            //g.setColor(Color.BLUE);
            //g.drawRect(200, 200, 300, 300);
            
            //ImageIcon img2 = new ImageIcon(getClass().getResource("imagenes/java-duke-guitar.png"));
            //g.drawImage(img2.getImage(), 230, 220, 250, 250, null);
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        // step 5: we close the document
        document.close();

        JOptionPane.showMessageDialog(null, 
                "archivo creado exitosamente!!");
    }

    public static void main(String[] args) {
        EjemploPDF obj = new EjemploPDF();
        obj.prueba();
    }
}
