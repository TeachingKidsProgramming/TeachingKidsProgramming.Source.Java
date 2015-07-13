package org.teachingextensions.virtualproctor;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.teachingextensions.approvals.lite.util.MySystem;
import org.teachingextensions.approvals.lite.util.ThreadLauncher;
import org.teachingextensions.approvals.lite.util.ThreadUtils;
import org.teachingextensions.approvals.lite.util.io.FileUtils;
import org.teachingextensions.approvals.lite.util.lambda.Action0;

public class VirtualProctorWeb extends WindowAdapter
{
  private boolean finished = false;
  @Override
  public void windowClosing(WindowEvent event)
  {
    final BufferedImage scaled = ScreenCapture.getScaledImageOf(event.getComponent(), 200, 150);
    ThreadLauncher.launch(new Action0()
    {
      @Override
      public void call()
      {
        sendImageToWeb(scaled);
        finished = true;
      }
    });
  }
  public void sendImageToDisk(BufferedImage image) throws IOException
  {
    String filename = "C:\\temp\\VirtualProctor.png";
    ImageIO.write(image, "png", new File(filename));
    //TestUtils.displayFile(filename);
  }
  @Override
  public void windowClosed(WindowEvent e)
  {
    while (!finished)
    {
      ThreadUtils.sleep(50);
    }
  }
  public void sendImageToWeb(BufferedImage image)
  {
    //sendToWebLegacy(image);
    sendToWeb(image);
  }
  private void sendToWeb(BufferedImage image)
  {
    try
    {
      URL url = new URL("http://steady-fin-94022.appspot.com/screenshots");
      postImageToUrl(image, url);
    }
    catch (Exception e)
    {
      MySystem.event(e.getMessage());
    }
  }
  private void postImageToUrl(BufferedImage image, URL url) throws URISyntaxException, IOException,
      ClientProtocolException
  {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpPost uploadFile = new HttpPost(url.toURI());
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "png", baos);
    InputStream is = new ByteArrayInputStream(baos.toByteArray());
    builder
        .addBinaryBody("file", is, ContentType.APPLICATION_OCTET_STREAM, VirtualProctor.internals.getFullName());
    HttpEntity multipart = builder.build();
    uploadFile.setEntity(multipart);
    HttpResponse response = httpClient.execute(uploadFile);
    if (response.getStatusLine().getStatusCode() == 204)
    {
      MySystem.event("we've got it!");
    }
    else
    {
      MySystem.event("oh no, the internet ate your screenshot!");
    }
  }
  private void sendToWebLegacy(BufferedImage image)
  {
    try
    {
      String urlFormat = "http://virtualproctor-tkp.appspot.com/org.teachingkidsprogramming.virtualproctor.UploadImageRack?fileName=%s.png";
      String name = URLEncoder.encode(VirtualProctor.internals.getFullName(), "ISO-8859-1");
      URL url = new URL(String.format(urlFormat, name));
      URLConnection connection = url.openConnection();
      connection.setDoOutput(true);
      connection.setDoInput(true);
      OutputStream outputStream = connection.getOutputStream();
      ImageIO.write(image, "png", outputStream);
      outputStream.close();
      String content = FileUtils.readStream((InputStream) connection.getContent());
      MySystem.event(content);
    }
    catch (UnknownHostException e)
    {
      MySystem.event("No internet connection");
    }
    catch (Exception e)
    {
      MySystem.warning(e);
    }
  }
}
