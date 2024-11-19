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
        out.println("<html><head><title>Horoscope</title>");
        out.println("<script>");
        out.println("var name = '" + req.getParameter("name")+"';");
        out.println("document.write('Hello '+name+'<br />');");
        out.println("var zodiac = " + getHoroscopeIndex(req.getParameter("zoidacs")) + ";");
        out.println("var gender = '" + req.getParameter("sex") + "';");
        out.println("if (zodiac < 6){");
        out.println("if (gender == 'Male') {document.write('You will have a long life.')}");
        out.println("else {document.write('You will find a tall handsome stranger.')}");
        out.println("}else{");
        out.println("if (gender == 'Male') {document.write('You will have a rich life.')}");
        out.println("else {document.write('You will have six children.')}");
        out.println("}");
        out.println("</script>");
        out.println("</head><body></body></html>");
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
