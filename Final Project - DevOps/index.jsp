<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bullhit.Game" %>

<%
    if ("POST".equalsIgnoreCase(request.getMethod())
            && "reset".equals(request.getParameter("action"))) {
        session.removeAttribute("game");
        session.removeAttribute("result");
        response.sendRedirect("index.jsp");
        return;
    }

    Game game = (Game) session.getAttribute("game");

    if (game == null) {
        game = new Game();
        session.setAttribute("game", game);
    }

    String result = (String) session.getAttribute("result");
    session.removeAttribute("result");
    if (result == null) {
        result = "";
    }
    String guess = request.getParameter("guess");

    if ("POST".equalsIgnoreCase(request.getMethod()) && guess != null) {
        result = game.checkGuess(guess);
        session.setAttribute("result", result);
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Bull Hit Game</title>
</head>

<body>

    <h1>Bull Hit Game hey gushhhhhhh</h1>

    <p>
        Guess the secret combination of 4 different letters between A and H.
    </p>

    <form method="post">

        <label for="guess">Enter your guess:</label>

        <input
            type="text"
            id="guess"
            name="guess"
            maxlength="4"
            placeholder="ABCD"
            required
        >

        <button type="submit">Check Guess</button>

    </form>

   <% if (!result.isEmpty()) { %>

    <h3><%= result %></h3>

<% } %>

<% if (!game.getHistory().isEmpty()) { %>

    <h2>Guess History</h2>

    <ul>
        <% for (String attempt : game.getHistory()) { %>
            <li><%= attempt %></li>
        <% } %>
    </ul>

<% } %>


<br>

<a href="rules.jsp">How to Play</a>

<br><br>

<form method="post" action="index.jsp">
    <input type="hidden" name="action" value="reset">
    <button type="submit">New Game</button>
</form>

</body>

</html>
