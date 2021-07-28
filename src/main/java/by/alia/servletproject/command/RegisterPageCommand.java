package by.alia.servletproject.command;

import by.alia.servletproject.exception.IncorrectDataException;
import by.alia.servletproject.exception.ServiceException;
import by.alia.servletproject.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws IncorrectDataException, ServiceException, IOException {
        System.out.println("REGISTER_PAGE");
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
}
