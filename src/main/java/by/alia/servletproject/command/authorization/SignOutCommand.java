package by.alia.servletproject.command.authorization;

import by.alia.servletproject.command.Command;
import by.alia.servletproject.command.CommandResult;
import by.alia.servletproject.command.session.SessionAttribute;
import by.alia.servletproject.exception.IncorrectDataException;
import by.alia.servletproject.exception.ServiceException;
import by.alia.servletproject.util.pages.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignOutCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute(SessionAttribute.NAME);
        logger.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribute.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}