
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/style.css" />
        <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,700' rel='stylesheet' type='text/css'>
        <title>View CV</title>
    </head>
    <body>            
        <table>
            <tr>
                <td> View CV </td>
                <td> </td>
            </tr>
            <tr>
                <td> ${candidate.cv}</td>
                <td>
                    <form action="reviewCv" method="POST">
                        <table>
                            <tr>
                                <td> <input type="submit" name ="accept" value = "Accept"></td>   
                            </tr>
                            <tr>
                                <td> <input type="submit" name="reject" value = "Reject"></td>   
                            </tr>
                            <tr>
                                <td> <input type="submit" name="comments" value = "All comments"></td>   
                            </tr>
                            <tr>
                                <td> <input type="submit" name="back" value = "Back"></td>   
                            </tr>
                        </table>
                    </form>
                </td>

            </tr>
            <
        </table>


        <script src="${pageContext.request.contextPath}/resources/admin.js"></script>
    </body>    
</html>
