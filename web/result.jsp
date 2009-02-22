<%@ page import="models.*" %>
<%@ page import="java.util.Vector" %>
<jsp:useBean id="player" class="models.Player" scope="session" />
<%-- The following is not a bean, but a vector... --%>
<%-- So can't use <jsp:useBean...> --%>
<% Vector<Player> highScorePlayers = (Vector<Player>) session.getAttribute("highScorePlayers"); %>
<jsp:include page="header.jsp" flush="true" />
<h2>Result</h2>

<p class="result">You scored <span class="score"><%= player.getMark() %>%</span></p>
    
<h2>10 Most High Scores</h2>

<table class="highscores">
    <tr>
        <th>Name</th>
        <th>Score</th>
    </tr>
    <% for (Player scorePlayer : highScorePlayers) { %>
    <tr>
        <td><%= scorePlayer.getName() %></td>
        <td><%= scorePlayer.getMark() %>%</td>
    </tr>
    <% } %>
</table>
<jsp:include page="footer.jsp" flush="true" />