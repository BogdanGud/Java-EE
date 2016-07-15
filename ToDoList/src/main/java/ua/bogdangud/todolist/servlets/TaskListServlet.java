package ua.bogdangud.todolist.servlets;


import ua.bogdangud.todolist.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "taskServlet", urlPatterns = {"/taskServlet"})
public class TaskListServlet extends HttpServlet {
    private CopyOnWriteArrayList<Task> taskList = new CopyOnWriteArrayList<Task>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            addNewTask(req);
        } else if ("update".equals(action)) {
            checkIsCompleteTask(req);
        }

        req.setAttribute("tasks", taskList);
        req.getRequestDispatcher("tasklist.jsp").forward(req, resp);
    }

    private void addNewTask(HttpServletRequest request) {
        Task task = new Task();
        task.setName(request.getParameter("name"));
        task.setCategory(request.getParameter("category"));
        taskList.add(task);
    }

    private void checkIsCompleteTask(HttpServletRequest request) {
        String[] values = request.getParameterValues("status");
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            if (value != null) {
                taskList.remove(i);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
