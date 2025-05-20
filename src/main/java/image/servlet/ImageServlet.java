package image.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;

@WebServlet("/upload/board/*")
public class ImageServlet extends HttpServlet {
    private final String BASE_PATH = "D:/upload/board/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestedFile = req.getPathInfo();
        File file = new File(BASE_PATH, requestedFile);

        if (!file.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        resp.setContentType(getServletContext().getMimeType(file.getName()));
        Files.copy(file.toPath(), resp.getOutputStream());
    }
}
