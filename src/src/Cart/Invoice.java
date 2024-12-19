package src.Cart;

import java.util.ArrayList;
import java.util.Date;
import src.Product.Search;
import java.time.LocalDate;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class Invoice extends Cart{
    private static  int invoiceId;
    private Date date;
    String host = "smtp.gmail.com";
    String port = "587";
    String username = "javalearn324@gmail.com"; // Replace with your email
    String password = "slet qglz oqgq nkjn"; // Replace with your email password or app-specific password

    String subject = "Invoice ";
    
    
    public Invoice(String recipient , ArrayList<CartItem> items , String clientName  , float TotalPrice) {
        invoiceId++;
        LocalDate currentDate = LocalDate.now();
         String invoiceHtml = String.format("""
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/svg+xml" href="/vite.svg" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Vite App</title>
    <style>
      :root {
        font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
        line-height: 1.5;
        font-weight: 400;
        background-color: #f5f5f5;
      }

      body {
        margin: 0;
        min-width: 320px;
        min-height: 100vh;
      }

      #app {
        margin: 0 auto;
        padding: 2rem;
      }

      @media print {
        body {
          background: white;
        }
        button {
          display: none !important;
        }
        #app {
          padding: 0;
        }
      }
    </style>
  </head>
  <body>
    <div
      style="
        max-width: 800px;
        margin: 20px auto;
        padding: 30px;
        background: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        color: #333;
      "
    >
      <!-- Header -->
      <div
        style="
          display: flex;
          justify-content: space-between;
          align-items: center;
          margin-bottom: 20px;
        "
      >
        <img
          src="https://download.odoocdn.com/icons/point_of_sale/static/description/icon.png"
          alt="Company Logo"
          style="height: 50px"
        />
        <h1 style="font-size: 40px; color: #2c3e50; margin: 0">INVOICE</h1>
      </div>

      <hr style="border: none; border-top: 1px solid #eee; margin: 20px 0" />

      <!-- Invoice Info -->
      <div
        style="
          display: flex;
          justify-content: space-between;
          margin-bottom: 20px;
        "
      >
        <div><b style="display: inline;">Date: %s</b></div>
        <div><b style="display: inline;">Invoice No: %s</b></div>
      </div>

      <!-- Customer Info -->
      <div style="margin-bottom: 30px">
        <h3 style="color: #2c3e50; margin-bottom: 10px">Invoiced To:</h3>
        <p style="margin: 5px 0">%s</p>
        <p style="margin: 5px 0">%s</p>
      </div>""", currentDate, invoiceId, clientName, recipient);

    invoiceHtml += """
      <!-- Products Table -->
      <table
        style="width: 100%; border-collapse: collapse; margin-bottom: 30px"
      >
        <thead>
          <tr style="background: #f8f9fa">
            <th
              style="
                padding: 12px;
                text-align: left;
                border-bottom: 2px solid #dee2e6;
              "
            >
              Item ID
            </th>
            <th
              style="
                padding: 12px;
                text-align: left;
                border-bottom: 2px solid #dee2e6;
              "
            >
              Name
            </th>
            <th
              style="
                padding: 12px;
                text-align: center;
                border-bottom: 2px solid #dee2e6;
              "
            >
              Quantity
            </th>
            <th
              style="
                padding: 12px;
                text-align: right;
                border-bottom: 2px solid #dee2e6;
              "
            >
              Subtotal
            </th>
          </tr>
        </thead>
            <tbody>""";
    
    
            for (CartItem item : items) {
                   invoiceHtml += String.format("""
              <tr>
                         <td style="padding: 12px; border-bottom: 1px solid #dee2e6">
                           #%s
                         </td>
                         <td style="padding: 12px; border-bottom: 1px solid #dee2e6">
                           %s
                         </td>
                         <td
                           style="
                             padding: 12px;
                             text-align: center;
                             border-bottom: 1px solid #dee2e6;
                           "
                         >
                           %s
                         </td>
                         <td
                           style="
                             padding: 12px;
                             text-align: right;
                             border-bottom: 1px solid #dee2e6;
                           "
                         >
                           %s
                         </td>
                       </tr>""" , item.getProductId() ,  Search.getProductByID(item.getProductId()).getName() , 1 , Search.getProductByID(item.getProductId()).getPrice());
            }
            
            
            
    invoiceHtml += String.format("""
              </tbody>
              <tfoot>
                <tr>
                  <td
                    colspan="3"
                    style="padding: 12px; text-align: right; font-weight: bold"
                  >
                    Total:
                  </td>
                  <td style="padding: 12px; text-align: right; font-weight: bold">
                    %s
                  </td>
                </tr>
              </tfoot>
            </table>
            """, TotalPrice);

        
    invoiceHtml += String.format("""
            
                  <!-- Notes -->
                  <div style="margin-bottom: 30px">
                    <h3 style="color: #2c3e50; margin-bottom: 10px">Notes:</h3>
                    <p style="background: #f8f9fa; padding: 15px; border-radius: 4px">
                     %s
                    </p>
                  </div>
            
                  <!-- Print Button -->
                  <div style="text-align: center">
                    <button
                      onclick="window.print()"
                      style="
                        background: #2c3e50;
                        color: white;
                        border: none;
                        padding: 12px 30px;
                        border-radius: 4px;
                        cursor: pointer;
                        font-size: 16px;
                        transition: background 0.3s;
                      "
                    >
                      Print Invoice
                    </button>
                  </div>
                </div>
              </body>
            </html>""" , "Thank you for your business! Payment is due within 30 days.");
    
        try {
      // Set up mail server properties
      Properties properties = new Properties();
      properties.put("mail.smtp.host", host);
      properties.put("mail.smtp.port", port);
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");

      // Create a session
          Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(username, password);
        }
      });

      // Create the message
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(username));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
      message.setSubject(subject + "#" + invoiceId);

      // Set email content
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent(invoiceHtml, "text/html");

      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);

      message.setContent(multipart);

      // Send the email
      Transport.send(message);
      System.out.println("Invoice sent successfully!");
    } catch (Exception e) {
      e.printStackTrace();
    }
        
    }
    
    
}
