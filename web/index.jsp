<jsp:include page="header.jsp" flush="true" />
<h2>Welcome</h2>
<p>Please enter your name below to start the quiz.</p>

<form action="play.jsp" method="post" id="quiz">
    <fieldset>
        <p><label for="name">Your name:</label> 
        <input type="text" name="name" id="name" /></p>
    
        <input type="submit" value="Start Quiz" />
    </fieldset>
</form>
<jsp:include page="footer.jsp" flush="true" />