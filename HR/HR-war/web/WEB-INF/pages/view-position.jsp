<%-- 
    Document   : view-position
    Created on : 09-Jan-2016, 16:45:25
    Author     : Ale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/style.css" />
        <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,700' rel='stylesheet' type='text/css'>
        <title>View Position</title>
    </head>
    <body>
        <table>
            <tr>
                <td> View Position </td>
                <td> </td>
            </tr>
            <tr>
                <td> Detalii despre pozitie</td>
                <td>
                    <form action="reviewPosition" method="POST">
                        <table>
                            <tr>
                                <td> <input class="btn" type="submit" name ="action" value = "View Comments"></td>   
                            </tr>
                            <tr>
                                <td> <input class="btn" type="submit" name="action" value = "View CVs"></td>   
                            </tr>
                            <tr>
                                <td> <input class="btn" type="submit" name="action" value = "Edit"></td>   
                            </tr>
                            <tr>
                                <td> <input class="btn" type="submit" name="action" value = "Back"></td>   
                            </tr>
                        </table>
                    </form>
                </td>

            </tr>

        </table>



    </body>    
</html>