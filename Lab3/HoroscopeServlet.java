import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HoroscopeServlet extends HttpServlet {
    public static final String[] zodiacs = {
        "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
        "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"
    };

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        if (name == null || name.isEmpty()) {
            out.println("Please identify yourself (by indicating your name), so that your horoscope can be given!");
            return;
        }
        String sex = req.getParameter("sex");
        String sign = req.getParameter("zodiacs");
        out.println("<html><head><title>Horoscope</title></head><body>");
        out.println("Hello " + name + ",<br>");
        int zodiacIndex = getHoroscopeIndex(sign);
        if (zodiacIndex < 6){
            if (sex.equals("Male")){
                out.println("You will have a long life.");
            } else {
                out.println("You will find a tall handsome stranger.");
            }
        }else {
            if (sex.equals("Male")){
                out.println("You will have a rich life.");
            } else {
                out.println("You will have six children.");
            }
        }
        out.println("</body></html>");
        return;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        doGet(req, res);
    }

    private int getHoroscopeIndex(String sign) {
        for (int i = 0; i < zodiacs.length; i++) {
            if (zodiacs[i].equals(sign)) {
                return i;
            }
        }
        return -1; // Invalid sign
    }
}
