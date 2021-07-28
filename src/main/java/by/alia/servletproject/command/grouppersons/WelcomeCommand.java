package by.alia.servletproject.command.grouppersons;

import by.alia.servletproject.command.Command;
import by.alia.servletproject.command.CommandResult;
import by.alia.servletproject.exception.IncorrectDataException;
import by.alia.servletproject.exception.ServiceException;
import by.alia.servletproject.model.Person;
import by.alia.servletproject.service.PersonService;
import by.alia.servletproject.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.alia.servletproject.command.grouppersons.constant.GroupConstant.*;

public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();

        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}