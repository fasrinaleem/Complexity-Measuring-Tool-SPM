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
      
        
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
   
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      
    </head>
    <body>
       

          <nav>
    <div class="nav-wrapper red lighten-1">
      <a href="#" class="brand-logo center">Complexity Measuring Tool</a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
        <li><a href="sass.html"> </a></li>
        <li><a href="badges.html"></a></li>
        <li><a href="collapsible.html"></a></li>
      </ul>
    </div>
  </nav>
        
        
        
    <center>
        <h2>Upload File Form</h2>
        <form action="FileUploadHandler" enctype="multipart/form-data" method="post">
           <input type="text" name="file_name"  style="width:220px" placeholder="Enter the file name"><br>
            <input type="file" name="file2"   style="padding-bottom:25px"/><br>
            
            <div class="btn waves-effect cyan lighten-1" >
            <input type="submit" value="upload" style="color:white" />
            </div>
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
