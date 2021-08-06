<!DOCTYPE html>
<html>
    <body>
        Hello World of Spring!
        <br><br>
        <%-- We can read form field data in JSP  --%>
        <%-- By using ${} --%>
        Student name: ${param.studentName}
        <br><br>
        <%-- Access attribute from the Model --%>
        The message: ${message}
    </body>
</html>
