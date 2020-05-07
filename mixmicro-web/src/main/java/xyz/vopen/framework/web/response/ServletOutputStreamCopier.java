package xyz.vopen.framework.web.response;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Http Servlet Response Copier
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 *     <p>
 */
public class ServletOutputStreamCopier extends ServletOutputStream {
  /** Output Stream */
  private OutputStream outputStream;
  /** Copy Byte Array Output Stream */
  private ByteArrayOutputStream copy;

  public ServletOutputStreamCopier(OutputStream outputStream) {
    this.outputStream = outputStream;
    this.copy = new ByteArrayOutputStream(1024);
  }

  @Override
  public void write(int b) throws IOException {
    outputStream.write(b);
    copy.write(b);
  }

  public byte[] getCopy() {
    return copy.toByteArray();
  }

  @Override
  public boolean isReady() {
    return false;
  }

  @Override
  public void setWriteListener(WriteListener writeListener) {}
}
