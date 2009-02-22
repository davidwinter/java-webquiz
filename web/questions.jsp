<%@ page import="models.*" %>
<jsp:useBean id="player" class="models.Player" scope="session" />
<jsp:include page="header.jsp" flush="true" />
<h2>Questions</h2>
<p><em><jsp:getProperty name="player" property="name" /></em>, answer all of the questions below, and then submit for your mark.</p>

<form action="mark.jsp" method="post" id="quiz">
    <fieldset>
        <dl>
            <% for (Question question : player.getQuiz().getQuestions()) { %>
            <dt><%= question.getQuestion() %></dt>
                <% for (Answer answer : question.getAnswers()) { %>
                <dd><input type="radio" name="<%= question.getId() %>" value="<%= answer.getId() %>" /><%= answer.getAnswer() %></dd>
                <% } %>
            <% } %>
            
        </dl>
    
        <input type="submit" value="Submit Answers" />
        <input type="reset" value="Clear current Answers" />
    </fieldset>
</form>
<jsp:include page="footer.jsp" flush="true" />