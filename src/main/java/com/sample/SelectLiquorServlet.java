package com.sample;

import com.sample.model.LiquorType;

import java.io.IOException;
import javax.servlet.*;
import java.net.http.HttpResponse;
import java.util.List;

@WebServlet(
        name = "selectliquorservlet",
        urlPatterns = "/SelectLiquor"
)

public class SelectLiquorServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String liquorType = req.getParameter("Type");
        LiquorService liquorService = new LiquorService();
        LiquorType l = LiquorType.valueOf(liquorType);

        List liquorBrands = liquorService.getAvailableBrands(l);

        req.setAttribute("brands", liquorBrands);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
    }



}
