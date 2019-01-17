package login;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ImageServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ImageServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Properties prop = new Properties();
		prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
		String path = prop.getProperty("INVOICE-DIRECTORY");

		logger.info("The  path is : " + path);

		String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");

		logger.info("The  filename is : " + filename);

		File file = new File(path, filename);
		String filePath[] = filename.split("/");
		logger.info("FILE IN SERVLET :: " + file);

		response.setHeader("Content-Type", getServletContext().getMimeType(filename));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		try {
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (IOException e) {
			logger.info("......EXCEPTION ImageServlet 47 :: " + e.getMessage());
			// serveDefaultImage(filePath[0],path,response);
		}
	}

	/**
	 * @param filename
	 * @param response
	 * @throws IOException
	 */
	private void serveDefaultImage(String filePath, String path, HttpServletResponse response) throws IOException {
		String filename = filePath + "/default.png";
		File file = new File(path, filename);
		logger.info("FILE IN SERVE METHOD :: " + file);
		response.setHeader("Content-Type", getServletContext().getMimeType(filename));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		Files.copy(file.toPath(), response.getOutputStream());
	}

}
