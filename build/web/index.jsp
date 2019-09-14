<%-- 
    Document   : index
    Created on : 14-Sep-2019, 10:30:24
    Author     : Fasrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Upload File Form</h1>
        <form action="FileUploadHandler" enctype="multipart/form-data" method="post">
            Enter File Name <input type="text" name="file_name"><br>
            Select<input type="file" name="file2" /><br>
            <input type="submit" value="upload" />
        </form> 
        <%
            String file_name = (String) request.getParameter("filename");
            if (file_name != null) {
                out.println(file_name + " File uploaded successfuly");
            }
        %>
    </center>
</body>
</html>
