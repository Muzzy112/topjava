package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");

        // получил MealToList на 2000 калорий
        List<MealTo> MealToList = MealsUtil.getFilteredWithExcess(MealsUtil.getMealList(), LocalTime.MIN, LocalTime.MAX, 2000);

        List<List<String>> mealsExc = MealToToStringList(MealToList);
        req.setAttribute("meals", mealsExc);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }

    //списо списка строк из всех MealTo
    private List<List<String>> MealToToStringList(List<MealTo> MealToList){
        List<List<String>> StringsList = new ArrayList<>();
        for (MealTo mt : MealToList) {
            StringsList.add(getS(mt.toString()));
        }
        return StringsList;
    }

    // делаю Список строк из MealTo
    private List<String> getS(String s){
        List<String> mealToStringList = new ArrayList<>();
        String[] ss = s.replaceAll("['{} ]", "").replace('T', ' ').split("(=|,)");
        for (int i = 1; i < 8; i = i+2) {
            mealToStringList.add(ss[i]);
        }
        return mealToStringList;
    }
}
