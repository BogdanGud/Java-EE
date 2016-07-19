package ua.bogdangud.todolist.servlets;


import ua.bogdangud.todolist.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "taskServlet", urlPatterns = {"/taskServlet"})
public class TaskListServlet extends HttpServlet {
    private CopyOnWriteArrayList<Task> taskList = new CopyOnWriteArrayList<Task>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(600);
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addNewTask(request);
        } else if ("update".equals(action)) {
            checkIsCompleteTask(request);
        }

        session.setAttribute("tasks", taskList);
        request.getRequestDispatcher("tasklist.jsp").forward(request, response);
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
