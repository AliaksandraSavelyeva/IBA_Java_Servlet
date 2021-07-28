<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <H2>Welcome ${name}</H2>
    <div>
        <table class ="container" border="2">
            <caption>Список вашей группы</caption>
            <tr>
                <th>Имя</th>
                <th>Телефон</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${group}" var="person">
                <tr><td>${person.name}</td>
                    <td>${person.phone}</td>
                    <td>${person.email}</td>
                </tr>
            </c:forEach>
        </table>
        <p><font color="red">${errorMessage}</font></p>
        <form method="POST" action="GroupListServlet">
            Новый :
            <p> Введите имя <input name="nname" type="text" /> </p>
            <p> Введите телефон <input name="nphone" type="text" /> </p>
            <p> Введите email <input name="nemail" type="text" /> </p>
            <input name="add" type="submit" />
        </form>
    </div>
</body>
</html>
